/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jwonkafx.core;

import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.jwonkafx.db.ConexionSQLServer;
import org.jwonkafx.model.Cliente;
import org.jwonkafx.model.DetalleVenta;
import org.jwonkafx.model.Empleado;
import org.jwonkafx.model.FormaPago;
import org.jwonkafx.model.Marca;
import org.jwonkafx.model.Persona;
import org.jwonkafx.model.Producto;
import org.jwonkafx.model.Venta;

/**
 *
 * @author Carlos Aviña
 */
public class ControladorVentas {
    public ObservableList<Producto> getProductos(String producto) throws Exception
    {
        String sql = "{call dbo.pa_sel_productos(?)}";
        
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        CallableStatement cstmt = connSQLServer.abrir().prepareCall(sql);
        
        cstmt.setString(1,producto);
        
        ObservableList<Producto> productos = FXCollections.observableArrayList();
        Producto p = null;
        Marca m = null;
        
        ResultSet rs = cstmt.executeQuery();
        
        while(rs.next())
        {
            m = new Marca();
            m.setNombre(rs.getString("Marca"));
                    
            p = new Producto();
            p.setId(rs.getInt("IdProducto"));
            p.setNombre(rs.getString("Producto"));
            p.setDescripcion(rs.getString("Descripcion"));
            p.setPrecio(rs.getFloat("Precio"));
            p.setStock(rs.getInt("Stock"));
            p.setMarca(m);
            
            productos.add(p);
        }
        rs.close();
        
        cstmt.close();
        connSQLServer.cerrar();
        
        return productos;
    }
    
    public ObservableList<Venta> getVentas() throws Exception
    {
        String sql = "{call dbo.pa_sel_venta()}";
        
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        CallableStatement cstmt = connSQLServer.abrir().prepareCall(sql);
        
        ObservableList<Venta> ventas = FXCollections.observableArrayList();
        Venta v = null;
        Empleado e = null;
        Cliente c = null;
        FormaPago f = null;
        Persona pe = null;
        Persona pc = null;
        
        ResultSet rs = cstmt.executeQuery();
        while(rs.next())
        {
            v = new Venta();
            e = new Empleado();
            c = new Cliente();
            f = new FormaPago();
            pe = new Persona();
            pc = new Persona();
            
            pe.setNombre(rs.getString("Empleado"));
            pc.setNombre(rs.getString("Cliente"));
            
            e.setId(rs.getInt("IdEmpleado"));
            e.setPersona(pe);
            c.setId(rs.getInt("IdCliente"));
            c.setPersona(pc);
            f.setDescripcion(rs.getString("Descripcion"));
            
            v.setId(rs.getInt("IdVenta"));
            v.setFecha(rs.getString("Fecha"));
            v.setTotal(rs.getFloat("Total"));
            v.setEmpleado(e);
            v.setCliente(c);
            v.setFormaPago(f);
            
            ventas.add(v);
        }
        rs.close();
        
        cstmt.close();
        connSQLServer.cerrar();
        
        return ventas;
    }
    
    public ObservableList<DetalleVenta> getDetalleVenta(int IdVenta) throws Exception
    {
        String sql = "{call dbo.pa_sel_detalleVenta(?)}";
        ObservableList<DetalleVenta> detalleVentas = FXCollections.observableArrayList();
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        CallableStatement cstmt = connSQLServer.abrir().prepareCall(sql);
        
        cstmt.setInt(1,IdVenta);
        
        DetalleVenta d = null;
        Producto p = null;
        Marca m = null;
        
        //ConexionSQLServer connSQLServer = new ConexionSQLServer();
        //PreparedStatement pstmt = connSQLServer.abrir().prepareStatement(sql);
        ResultSet rs = cstmt.executeQuery();
        
        while(rs.next())
        {
            d = new DetalleVenta();
            p = new Producto();
            m = new Marca();
            
            m.setNombre(rs.getString("Marca"));
            
            p.setNombre(rs.getString("Producto"));
            p.setDescripcion(rs.getString("Descripcion"));
            p.setPrecio(rs.getFloat("Precio"));
            p.setFotografia(rs.getString("Fotografia"));
            p.setMarca(m);
            
            d.setCantidadProducto(rs.getInt("CantidadProducto"));
            d.setPrecio(rs.getFloat("Total"));
            d.setProducto(p);
            
            detalleVentas.add(d);
        }
        rs.close();
        cstmt.close();
        connSQLServer.cerrar();
        
        return detalleVentas;
    }
    
    public void insertar(Venta v, ObservableList<DetalleVenta> listD) throws Exception
    {
        float total = 0;
        for(int i = 0;i < listD.size();i++)
        {
                total += listD.get(i).getPrecio();
        }
        v.setTotal(total);
        //INSERTAR VENTA
        String sql = "{call dbo.pa_ins_RealizarVenta(?,?,?,?,?)}";
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        CallableStatement cstmt = connSQLServer.abrir().prepareCall(sql);
        
        cstmt.setInt(1,v.getEmpleado().getId());
        cstmt.setInt(2,v.getCliente().getId());
        cstmt.setInt(3,v.getFormaPago().getId());
        cstmt.setFloat(4,v.getTotal());
        cstmt.registerOutParameter(5,java.sql.Types.INTEGER);
        
        cstmt.executeUpdate();
        v.setId(cstmt.getInt(5));
        connSQLServer.cerrar();
        
        //INSERTAR DETALLE VENTA
        for(int i = 0;i < listD.size();i++)
        {
            sql = "{call dbo.pa_ins_detalleVenta(?,?,?,?)}";
            connSQLServer = new ConexionSQLServer();
            cstmt = connSQLServer.abrir().prepareCall(sql);
        
            cstmt.setInt(1,listD.get(i).getCantidadProducto());
            cstmt.setFloat(2,listD.get(i).getPrecio());
            cstmt.setInt(3,v.getId());
            cstmt.setInt(4,listD.get(i).getProducto().getId());
        
            cstmt.executeUpdate();
            connSQLServer.cerrar();
        }
    }
    
    public ObservableList<FormaPago> getFormaPago() throws Exception
    {
        String sql = "{call dbo.pa_sel_formaPago()}";
        
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        CallableStatement cstmt = connSQLServer.abrir().prepareCall(sql);
        
        ObservableList<FormaPago> formaPago = FXCollections.observableArrayList();
        FormaPago f = null;
        
        ResultSet rs = cstmt.executeQuery();
        
        while(rs.next())
        {
            f = new FormaPago();
            f.setId(rs.getInt("IdFormaPago"));
            f.setDescripcion(rs.getString("Descripcion"));
            
            formaPago.add(f);
        }
        rs.close();
        
        cstmt.close();
        connSQLServer.cerrar();
        
        return formaPago;
    }
    
    public void deleteVenta(int IdVenta) throws Exception
    {
        String sql = "{call dbo.pa_del_venta(?)}";
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        CallableStatement cstmt = connSQLServer.abrir().prepareCall(sql);
        
        cstmt.setInt(1,IdVenta);
        
        cstmt.executeUpdate();
        connSQLServer.cerrar();
    }
}
