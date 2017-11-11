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
import org.jwonkafx.model.Persona;

/**
 *
 * @author franc
 */
public class ControladorCliente 
{
    public void insert(Cliente c) throws Exception
    {
        String sql = "{call dbo.InsertarCliente(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        CallableStatement cstmt = connSQLServer.abrir().prepareCall(sql);
        
        cstmt.setString(1,c.getPersona().getNombre());
        cstmt.setString(2,c.getPersona().getApellidoPaterno());
        cstmt.setString(3,c.getPersona().getApellidoMaterno());
        cstmt.setString(4,c.getPersona().getGenero());
        cstmt.setString(5,c.getPersona().getRfc());
        cstmt.setString(6,c.getPersona().getFechaNacimiento());
        cstmt.setString(7,c.getPersona().getCp());
        cstmt.setString(8,c.getPersona().getDomicilio());
        cstmt.setString(9,c.getPersona().getFotografia());
        cstmt.setString(10,c.getEmail());
        cstmt.setString(11,c.getTelefono());
        cstmt.setString(12,c.getPersona().getCurp());
        cstmt.registerOutParameter(13,java.sql.Types.INTEGER);
        cstmt.registerOutParameter(14, java.sql.Types.INTEGER);
        
        cstmt.executeUpdate();
        
        c.getPersona().setId(cstmt.getInt(13));
        c.setId(cstmt.getInt(14));
        //cstmt.close();
        connSQLServer.cerrar();
               
    }
    
    public void update(Cliente c) throws Exception
    {
        String sql = "{call dbo.UpdateCliente(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        CallableStatement cstmt = connSQLServer.abrir().prepareCall(sql);
        
        cstmt.setInt(1,c.getId());
        cstmt.setInt(2,c.getPersona().getId());
        cstmt.setString(3,c.getPersona().getNombre());
        cstmt.setString(4,c.getPersona().getApellidoPaterno());
        cstmt.setString(5,c.getPersona().getApellidoMaterno());
        cstmt.setString(6,c.getPersona().getGenero());
        cstmt.setString(7,c.getPersona().getRfc());
        cstmt.setString(8,c.getPersona().getCurp());
        cstmt.setString(9,c.getPersona().getFechaNacimiento());
        cstmt.setString(10,c.getPersona().getCp());
        cstmt.setString(11,c.getPersona().getFotografia());
        cstmt.setString(12,c.getPersona().getDomicilio());
        cstmt.setString(13,c.getEmail());
        cstmt.setString(14,c.getTelefono());
        
        cstmt.close();
        connSQLServer.cerrar();
    }
    public void delete(int idCliente) throws Exception
    {
        
    }
    public ObservableList<Cliente> getAll(String filtro) throws Exception
    {
        String sql = "SELECT * FROM V_Clientes";
        ObservableList<Cliente> clientes = FXCollections.observableArrayList();
        Cliente c = null;
        Persona p = null;
        ConexionSQLServer connSQLServer = new ConexionSQLServer();
        PreparedStatement pstmt = connSQLServer.abrir().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next())
        {
                    p = new Persona();
                    p.setApellidoMaterno(rs.getString("ApellidoMaterno"));
                    p.setApellidoPaterno(rs.getString("ApellidoPaterno"));
                    p.setCp(rs.getString("Cp"));
                    p.setCurp(rs.getString("Curp"));
                    p.setFechaNacimiento(rs.getString("FechaNacimiento"));
                    p.setFotografia(rs.getString("Fotografia"));
                    p.setGenero(rs.getString("Genero"));
                    p.setId(rs.getInt("IdPersona"));
                    p.setNombre(rs.getString("Nombre"));
                    p.setRfc(rs.getString("Rfc")); 
                    p.setDomicilio(rs.getString("Domicilio"));
                    
                    c = new Cliente();
                    c.setActivo(rs.getInt("Activo"));
                    c.setEmail(rs.getString("Email"));
                    c.setId(rs.getInt("IdCliente"));
                    c.setPersona(p);
                    c.setTelefono(rs.getString("Telefono"));
                    
                    clientes.add(c);
        }
        rs.close();
        pstmt.close();
        connSQLServer.cerrar();
        
        return clientes;
    }
}
