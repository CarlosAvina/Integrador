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
import org.jwonkafx.model.Empleado;
import org.jwonkafx.model.Persona;
import org.jwonkafx.model.Rol;
import org.jwonkafx.model.Usuario;

/**
 *
 * @author karla
 */
public class ControladorEmpleado {
    public void insert(Empleado emp) throws Exception
    {
    String query="{CALL uspInsertarEmpleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        ConexionSQLServer conex = new ConexionSQLServer();
        CallableStatement cmd = conex.abrir().prepareCall(query);
        cmd.setString(1, emp.getPersona().getNombre());
        cmd.setString(2, emp.getPersona().getApellidoPaterno());
        cmd.setString(3, emp.getPersona().getApellidoMaterno());
        cmd.setString(4, emp.getPersona().getGenero());
        cmd.setString(5, emp.getPersona().getRfc());
        cmd.setString(6, emp.getPersona().getCurp());
        cmd.setString(7, emp.getPersona().getFechaNacimiento());
        cmd.setString(8, emp.getPersona().getCp());
        cmd.setString(9, emp.getPersona().getFotografia());
        cmd.setString(10,emp.getPersona().getDomicilio());
        
        cmd.setString(11,emp.getUsuario().getPassword());
        cmd.setInt(12,emp.getUsuario().getRol().getId());
       
        cmd.setFloat(13,emp.getSalario());
        
        cmd.registerOutParameter(14, java.sql.Types.INTEGER);
        cmd.registerOutParameter(15, java.sql.Types.INTEGER);
        cmd.registerOutParameter(16, java.sql.Types.INTEGER);
        
        cmd.executeUpdate();
        
        emp.setId(cmd.getInt(14));
        emp.getPersona().setId(cmd.getInt(15));
        emp.getUsuario().setId(cmd.getInt(16));
        cmd.close();
        conex.cerrar();
    }
     public void eliminar(Empleado emp) throws Exception
    {
        String query="{CALL uspEliminarEmpleado(?)}";
        ConexionSQLServer conex = new ConexionSQLServer();
        CallableStatement cmd = conex.abrir().prepareCall(query);
        cmd.setInt(1, emp.getId());
        cmd.executeUpdate();
        cmd.close();
        conex.cerrar();
    }
      public void update(Empleado emp) throws Exception
    {
        String query="{CALL uspActualizarEmpleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        ConexionSQLServer conex = new ConexionSQLServer();
        CallableStatement cmd = conex.abrir().prepareCall(query);
        cmd.setInt(1, emp.getId());
        cmd.setInt(2, emp.getPersona().getId());
        cmd.setString(3, emp.getPersona().getNombre());
        cmd.setString(4, emp.getPersona().getApellidoPaterno());
        cmd.setString(5, emp.getPersona().getApellidoMaterno());
        cmd.setString(6, emp.getPersona().getGenero());
        cmd.setString(7, emp.getPersona().getRfc());
        cmd.setString(8, emp.getPersona().getCurp());
        cmd.setString(9, emp.getPersona().getFechaNacimiento());
        cmd.setString(10, emp.getPersona().getCp());
        cmd.setString(11, emp.getPersona().getFotografia());
        cmd.setString(12,emp.getPersona().getDomicilio());
        cmd.setFloat(13,emp.getSalario());
        cmd.setString(14, emp.getUsuario().getUsername());
        cmd.setString(15, emp.getUsuario().getPassword());
        cmd.setInt(16, emp.getUsuario().getRol().getId());
        cmd.setInt(17, emp.getUsuario().getId());
        
        cmd.executeUpdate();
       //rs.close();
        cmd.close();
        conex.cerrar();
    }
      

    public ObservableList<Empleado> getAll(String filtro) throws Exception
    {
        String query ="SELECT * FROM V_Empleados";
       ObservableList<Empleado> empleados = FXCollections.observableArrayList();
       ConexionSQLServer connSQLServer = new ConexionSQLServer();
        PreparedStatement pstmt = connSQLServer.abrir().prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
       
       Empleado emp;
       Persona p;
       Usuario u;
       Rol r;
       while(rs.next())
       {
           emp = new Empleado();
           p =new Persona();
           u = new Usuario();
           r = new Rol();
           emp.setActivo(rs.getInt("Activo"));
           p.setCp(rs.getString("Cp"));
           p.setCurp(rs.getString("Curp"));
           p.setDomicilio(rs.getString("Domicilio"));
           p.setFechaNacimiento(rs.getString("FechaNacimiento"));
           p.setFotografia(rs.getString("Fotografia"));
           p.setGenero(rs.getString("Genero"));
           emp.setId(rs.getInt("IdEmpleado"));
           p.setId(rs.getInt("IdPersona"));
           p.setApellidoMaterno(rs.getString("ApellidoMaterno"));
           p.setApellidoPaterno(rs.getString("ApellidoPaterno"));
           p.setNombre(rs.getString("Nombre"));
           p.setRfc(rs.getString("Rfc"));
           emp.setSalario(rs.getFloat("Salario"));
           emp.setFechaIngreso(rs.getString("FechaIngreso"));
           //u.setActivo(rs.getInt("ActivoUs"));
           u.setId(rs.getInt("IdUsuario"));
           u.setPassword(rs.getString("Password"));
           u.setUsername(rs.getString("Username"));
           r.setRol(rs.getString("Descripcion"));
           //emp.setCodigo(rs.getString("Codigo"));
           //r.setId(rs.getInt("IdRol"));
           u.setRol(r);
           emp.setUsuario(u);
           emp.setPersona(p);
           empleados.add(emp);
       }
        rs.close();
        pstmt.close();
        connSQLServer.cerrar();
        return empleados;
    }
}
