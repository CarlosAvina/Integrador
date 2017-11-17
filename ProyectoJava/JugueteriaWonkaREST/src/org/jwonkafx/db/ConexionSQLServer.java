/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jwonkafx.db;

import java.sql.*;

public class ConexionSQLServer {
    String url;
    String userName;
    String password;
    
    
    //Este objeto nos sirve para gestionar la conexion con SQLServer;
    Connection conn;
    
    //Abrir una conexion con SQL Server
    public Connection abrir() throws Exception
    {
        userName="sa";
        password="sa";
        url="jdbc:sqlserver://127.0.0.1:1434;databaseName=JugueteriaWonka";
        
        //Registramos el driver JDBC de Microsoft SQL Server
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
        //Creamos una conexión a través del DriverManager
        conn=DriverManager.getConnection(url,userName,password);
       return conn; 
    }
    
    public void cerrar()
    {
        if(conn == null)
            return;
        try 
        {
            conn.close();
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally
        {
            conn=null;
        }
    }
}
