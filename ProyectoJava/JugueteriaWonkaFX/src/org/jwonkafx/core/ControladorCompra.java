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
import org.jwonkafx.model.Compra;

/**
 *
 * @author karla
 */
public class ControladorCompra {
    public void insert(Compra c) throws Exception
    {
        //definimos la consulta SQL que invoca al pa
        String sql = "{call dbo.InsertarBitacora(?)};";
        //instanciamos un objeto de conexion con SQL Server
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        //abrimos la conexion con sql y generamos un objeto invocar al procedimiento
        //invocamos al pa
        CallableStatement cstmt= connSQLServer.abrir().prepareCall(sql);
        //establecemos los valores de los parametros
        
        cstmt.registerOutParameter(1,java.sql.Types.INTEGER);
       
        //ejecutamos la sentencia SQL
        cstmt.executeUpdate();
        //obtenemos los id's generados y los guardamos en el objeto cliente
        c.setIdCompra(cstmt.getInt(1));
        
        //Cerramos los objetos de bd
        cstmt.close();
        connSQLServer.cerrar();
    }
 
    public void delete(int idCompra) throws Exception
    {
        String sql = "{call pa_supBitacora (?)}";
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        CallableStatement cstmt = connSQLServer.abrir().prepareCall(sql);
        cstmt.setInt(1, idCompra);
        cstmt.executeUpdate();
        cstmt.close();
        connSQLServer.cerrar();
    }
    
    
public ObservableList<Compra> getAll(String filtro) throws Exception
    {
        String sql = "SELECT * FROM Bitacora where Activo = 1";
        //busca todos los clientes, los va a devolver y los va a meter en la colección observable
        ObservableList<Compra> col = FXCollections.observableArrayList();
        Compra c = null;
        //Instanciamos un objeto de conexion sqlserver
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        //abrimos la conexion con sql 
        PreparedStatement pstmt = connSQLServer.abrir().prepareCall(sql);
        // generamos un objeto para ejecutar la consulta
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()) {
            c = new Compra();
            c.setIdCompra(rs.getInt("IdBitacora"));
            c.setFechaAbastecimiento(rs.getString("FechaAbastecimiento"));
            c.setTotal(rs.getFloat("Total"));
            col.add(c);
        }
         //prepare statement para comandos dierectos como select, insert y asi
         //prepare call para traer funciones y procedimientos de la bd
        rs.close();
        pstmt.close();
        connSQLServer.cerrar();
        return col;
    }
}
