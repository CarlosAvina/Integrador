/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jwonkafx.core;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.jwonkafx.db.ConexionSQLServer;
import org.jwonkafx.model.DetalleCompra;
import org.jwonkafx.model.Producto;

/**
 *
 * @author karla
 */
public class ControladorDetalleCompra {
        public void insert(DetalleCompra dc, int id) throws Exception
    {
        String sql = "{call dbo.InsertarDetalleBitacora (?,?,?,?,?)}";
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        CallableStatement cstmt = connSQLServer.abrir().prepareCall(sql);
        cstmt.setInt(1, id);
        cstmt.setInt(2, dc.getProducto().getId());
        cstmt.setInt(3, dc.getCantidad());
        cstmt.setFloat(4, dc.getPrecioCompra());
        cstmt.setFloat(5, dc.getTotal());
        cstmt.executeUpdate();
        cstmt.close();
        connSQLServer.cerrar();
    }
    public ArrayList<DetalleCompra> getAllAL(int id) throws Exception
    {
        String sql = "SELECT D.*, P.Nombre FROM  dbo.DetalleBitacora AS D INNER JOIN dbo.Producto AS P ON D.IdProducto = P.IdProducto where IdBitacora =" + id;
        //busca todos los clientes, los va a devolver y los va a meter en la colección observable
        ArrayList<DetalleCompra> dbol = new ArrayList();
        DetalleCompra db = null;
        //Instanciamos un objeto de conexion sqlserver
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        //abrimos la conexion con sql 
        PreparedStatement pstmt = connSQLServer.abrir().prepareCall(sql);
        // generamos un objeto para ejecutar la consulta
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next())
        {
            Producto p = new Producto();
            p.setId(rs.getInt("IdProducto"));
            p.setNombre(rs.getString("Nombre"));
            db = new DetalleCompra();
            db.setProducto(p);
            db.setCantidad(rs.getInt("Cantidad"));
            db.setPrecioCompra(rs.getFloat("PrecioCompra"));
            db.setTotal(rs.getFloat("Total"));
            dbol.add(db);
        }
         //prepare statement para comandos dierectos como select, insert y asi
         //prepare call para traer funciones y procedimientos de la bd
        rs.close();
        pstmt.close();
        connSQLServer.cerrar();
        return dbol;
    }
        
        
        
    public ObservableList<DetalleCompra> getAll(String filtro, int id) throws Exception
    {
        String sql = "SELECT D.*, P.Nombre FROM  dbo.DetalleBitacora AS D INNER JOIN dbo.Producto AS P ON D.IdProducto = P.IdProducto where IdBitacora =" + id;
        //busca todos los clientes, los va a devolver y los va a meter en la colección observable
        ObservableList<DetalleCompra> dbol = FXCollections.observableArrayList();
        DetalleCompra db = null;
        //Instanciamos un objeto de conexion sqlserver
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        //abrimos la conexion con sql 
        PreparedStatement pstmt = connSQLServer.abrir().prepareCall(sql);
        // generamos un objeto para ejecutar la consulta
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next())
        {
           Producto p = new Producto();
            p.setId(rs.getInt("IdProducto"));
            p.setNombre(rs.getString("Nombre"));
            db = new DetalleCompra();
            db.setProducto(p);
            db.setCantidad(rs.getInt("Cantidad"));
            db.setPrecioCompra(rs.getFloat("PrecioCompra"));
            dbol.add(db);
        }
         //prepare statement para comandos dierectos como select, insert y asi
         //prepare call para traer funciones y procedimientos de la bd
        rs.close();
        pstmt.close();
        connSQLServer.cerrar();
        return dbol;
    }
}
