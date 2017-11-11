/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jwonkafx.core;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.jwonkafx.db.ConexionSQLServer;
import org.jwonkafx.model.Producto;
import org.jwonkafx.model.Marca;

/**
 *
 * @author danie
 */
public class ControladorProducto {
     public void insert(Producto pr) throws Exception
    {
        String sql="{call dbo.InsertarProducto(?,?,?,?,?,?,?,?)}";
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        CallableStatement cstmt = connSQLServer.abrir().prepareCall(sql);
        
        cstmt.setString(1,pr.getNombre());
        cstmt.setString(2,pr.getDescripcion());
        cstmt.setFloat(3,pr.getPrecio());
        cstmt.setInt(4,pr.getEdadMinima());
        cstmt.setInt(5,pr.getEdadMaxima());
        cstmt.setString(6,pr.getFotografia());
        cstmt.setInt(7,pr.getMarca().getId());
        cstmt.registerOutParameter(8,java.sql.Types.INTEGER);
         cstmt.executeUpdate();

        pr.setId(cstmt.getInt(8));
        //cstmt.close();
        connSQLServer.cerrar();
               
    }
    public void update(Producto pr) throws Exception
    {
          String sql = "{call dbo.ActualizarProducto(?,?,?,?,?,?,?,?)}";
        
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        CallableStatement cstmt = connSQLServer.abrir().prepareCall(sql);
        
        cstmt.setInt(1,pr.getId());
        cstmt.setString(2,pr.getNombre());
        cstmt.setString(3,pr.getDescripcion());
        cstmt.setFloat(4,pr.getPrecio());
        cstmt.setInt(5,pr.getEdadMinima());
        cstmt.setInt(6,pr.getEdadMaxima());
        cstmt.setString(7,pr.getFotografia());
        cstmt.setInt(8,pr.getMarca().getId());
        cstmt.executeUpdate(); 
        //cstmt.close();
        connSQLServer.cerrar();
    }
    public boolean delete(int idProducto) throws Exception
    {
        try{
          String sql = "{call dbo.pa_EliminarProducto(?)}";
          ConexionSQLServer connSQLServer = new ConexionSQLServer();
        CallableStatement cstmt = connSQLServer.abrir().prepareCall(sql);
        
        cstmt.setInt(1,idProducto);
        
         cstmt.executeUpdate();
         //cstmt.close();
        
        connSQLServer.cerrar();
        return true;
        }catch(Exception ex)
        {return false;
        }
        
    }
    public ObservableList<Producto> getAll() throws Exception
    {
        String sql = "SELECT * FROM V_Productos";
        ObservableList<Producto> productos = FXCollections.observableArrayList();
        Producto pr = null;
        Marca m = null;
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        PreparedStatement pstmt = connSQLServer.abrir().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next())
                {
                    pr= new Producto();
                    pr.setId(rs.getInt("IdProducto"));
                    pr.setNombre(rs.getString("Nombre"));
                    pr.setDescripcion(rs.getString("Descripcion"));
                    pr.setPrecio(rs.getFloat("Precio"));
                    pr.setStock(rs.getInt("Stock"));
                    pr.setEdadMinima(rs.getInt("EdadMinima"));
                    pr.setEdadMaxima(rs.getInt("EdadMaxima"));
                    pr.setFotografia(rs.getString("Fotografia"));
                   
                    pr.setActivo(rs.getInt("Activo"));
                    
                    m= new Marca();
                    m.setId(rs.getInt("IdMarca"));
                    m.setNombre(rs.getString("Marca")); 
                    pr.setMarca(m);
                    
                    productos.add(pr);
                }
                rs.close();
                pstmt.close();
                connSQLServer.cerrar();
                return productos;
    }
    
    
    public ObservableList<Marca> getAllMarcas() throws Exception
    {
        String sql = "SELECT * FROM V_Marcas";
        ObservableList<Marca> marcas = FXCollections.observableArrayList();
        Marca m = null;
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        PreparedStatement pstmt = connSQLServer.abrir().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next())
                {
                    m= new Marca();
                    m.setNombre(rs.getString("Nombre"));
                    
                    marcas.add(m);
                }
                rs.close();
                pstmt.close();
                connSQLServer.cerrar();
                return marcas;
    }
}
