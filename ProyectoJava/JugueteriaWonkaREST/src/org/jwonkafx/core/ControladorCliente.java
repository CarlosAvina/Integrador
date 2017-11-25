/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jwonkafx.core;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.sf.json.JSONObject;
import org.jwonkafx.db.ConexionSQLServer;
import org.jwonkafx.model.Cliente;
import org.jwonkafx.model.Persona;
/**
 *
 * @author franc
 */
public class ControladorCliente 
{
    
    //private static final String URL_REST = "http://192.168.1.102/jwonka/api/RestCliente";
    private static final String URL_REST="http://localhost:83/wcfServiciosJK/Servicio.svc/";
    public int insert(Cliente c) throws Exception
    {
        //Configuramos la URL del Servicio
        String rutaServicio = URL_REST+"RegistrarCliente";
        URL url = new URL(rutaServicio);
        HttpURLConnection connHttp = (HttpURLConnection)url.openConnection();
        
        //Aqui guardamos la respuesta del servidor
        int respuestaServidor = 0; //Revisar los tipos de respuesta que pueda
        
        //Este objeto nos ayudara a enviarle datos al servidor
        BufferedWriter bwriter = null;
        
        //Este objeto nos ayudara a mandarle los datos como parametros al servidor
        OutputStream out = null;
        
        //Este objeto nos ayudara a capturar la respuesta que el servidor nos envia
        BufferedReader br = null;
        String avinatonto;
        //Esta es una variable auxiliar que nos ayudara a ir leyendo la respuesta del servidor
        String lineaActual;
        
        //En esta variable se ira guardando la respuesta del servidor hasta que finalize de responder
        String contenidoRespuesta = "";
        
        //Aqui guardaremos la respresentacion JSON del objeto Cliente que deseamos enviar al servidor
        String strJson = null;
        
        //Este objeto nos permitira convertir el objeto de tipo Cliente en una cadena JSON
         //Le indicamos a felxjson que ignore el atributo "class", ya que no lo necesita el REST hecho en .Net
        JSONSerializer jss = new flexjson.JSONSerializer().exclude("*.class");
        
        //Este objeto nos permitira convertir la respuesta JSON del servidor
        //JSONDeserializer jdss = new JSONDeserializer();
        
        JSONObject jso = null;
        strJson = jss.serialize(c);
        System.out.println(strJson);
        
        //Establecemos el metodo de conexión
        connHttp.setRequestMethod("POST");
        
        //Indicamos que enviaremos los parametros codificador a traves del cuerpo de la peticion BODY
        connHttp.setRequestProperty("Content-Type", "application/json");
        
        //Establecemos que enviaremos los valores por un metodo POST
        connHttp.setDoOutput(true);
        
        //Establecemos que recibiremos respuresta del servidor
        connHttp.setDoInput(true);
        
        //Enviamos los parametros al servidor
        out = new BufferedOutputStream(connHttp.getOutputStream());
        bwriter = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
        bwriter.write(strJson);
        bwriter.flush();
        bwriter.close();
        out.close();
        
        //Mantenemos la conexion con el servidor
        connHttp.connect();
        
        //Le pedimos al servidor que pricese la peticion y esperamos la respuesta
        respuestaServidor = connHttp.getResponseCode();
        
        //Verificamos que nos respinda de forma satisfactoria
        if(respuestaServidor == HttpURLConnection.HTTP_OK)
        {
            br = new BufferedReader(new InputStreamReader(connHttp.getInputStream()));
            
            //Leemos la respuesta del servidor
            while((lineaActual = br.readLine()) != null)
                contenidoRespuesta += lineaActual;
            
            //Imprimimos en consola la respuesta del servidor (Opcional)
            System.out.println(contenidoRespuesta);
            
            //Convertimos la respuesta del servidor en un JSONObject
            jso = JSONObject.fromObject(contenidoRespuesta);
            
            //Cerramos la conexion con el servidor
            connHttp.disconnect();
            
            //Verificamos  que el objeto JSON tiene la propiedad 'result'
            if(!jso.isEmpty())
            {
                c.setId(jso.getInt("id"));
                //c.getPersona().setId(jso.getInt("IdPersonaGenerado"));
                return c.getId();
            }
            else
                return -1;
        }
        else
        {
            throw new Exception("El servidor respondió con codigo " + respuestaServidor);
        }
    }//Fin del metodo
    
    public void update(Cliente c) throws Exception
    {
        String rutaServicio = URL_REST+"UpdateCliente";
        URL url = new URL(rutaServicio);
        HttpURLConnection connHttp = (HttpURLConnection)url.openConnection();
        
        //Aqui guardamos la respuesta del servidor
        int respuestaServidor = 0; //Revisar los tipos de respuesta que pueda
        
        //Este objeto nos ayudara a enviarle datos al servidor
        BufferedWriter bwriter = null;
        
        //Este objeto nos ayudara a mandarle los datos como parametros al servidor
        OutputStream out = null;
        
        //Este objeto nos ayudara a capturar la respuesta que el servidor nos envia
        BufferedReader br = null;
        
        //Esta es una variable auxiliar que nos ayudara a ir leyendo la respuesta del servidor
        String lineaActual;
        
        //En esta variable se ira guardando la respuesta del servidor hasta que finalize de responder
        String contenidoRespuesta = "";
        
        //Aqui guardaremos la respresentacion JSON del objeto Cliente que deseamos enviar al servidor
        String strJson = null;
        
        //Este objeto nos permitira convertir el objeto de tipo Cliente en una cadena JSON
         //Le indicamos a felxjson que ignore el atributo "class", ya que no lo necesita el REST hecho en .Net
        JSONSerializer jss = new flexjson.JSONSerializer().exclude("*.class");
        
        //Este objeto nos permitira convertir la respuesta JSON del servidor
        //JSONDeserializer jdss = new JSONDeserializer();
        
        JSONObject jso = null;
        strJson = jss.serialize(c);
        System.out.println(strJson);
        
        //Establecemos el metodo de conexión
        connHttp.setRequestMethod("POST");
        
        //Indicamos que enviaremos los parametros codificador a traves del cuerpo de la peticion BODY
        connHttp.setRequestProperty("Content-Type", "application/json");
        
        //Establecemos que enviaremos los valores por un metodo POST
        connHttp.setDoOutput(true);
        
        //Establecemos que recibiremos respuresta del servidor
        connHttp.setDoInput(true);
        
        //Enviamos los parametros al servidor
        out = new BufferedOutputStream(connHttp.getOutputStream());
        bwriter = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
        bwriter.write(strJson);
        bwriter.flush();
        bwriter.close();
        out.close();
        
        //Mantenemos la conexion con el servidor
        connHttp.connect();
        
        //Le pedimos al servidor que pricese la peticion y esperamos la respuesta
        respuestaServidor = connHttp.getResponseCode();
        
        //Verificamos que nos respinda de forma satisfactoria
        if(respuestaServidor != HttpURLConnection.HTTP_OK)
        {
          throw new Exception("El servidor respondió con codigo " + respuestaServidor);
        }
    }
    public void delete(Cliente c) throws Exception
    {
        String rutaServicio = URL_REST+"EliminarCliente";
        URL url = new URL(rutaServicio);
        HttpURLConnection connHttp = (HttpURLConnection)url.openConnection();
        
        //Aqui guardamos la respuesta del servidor
        int respuestaServidor = 0; //Revisar los tipos de respuesta que pueda
        
        //Este objeto nos ayudara a enviarle datos al servidor
        BufferedWriter bwriter = null;
        
        //Este objeto nos ayudara a mandarle los datos como parametros al servidor
        OutputStream out = null;
        
        //Este objeto nos ayudara a capturar la respuesta que el servidor nos envia
        BufferedReader br = null;
        
        //Esta es una variable auxiliar que nos ayudara a ir leyendo la respuesta del servidor
        String lineaActual;
        
        //En esta variable se ira guardando la respuesta del servidor hasta que finalize de responder
        String contenidoRespuesta = "";
        
        //Aqui guardaremos la respresentacion JSON del objeto Cliente que deseamos enviar al servidor
        String strJson = null;
        
        //Este objeto nos permitira convertir el objeto de tipo Cliente en una cadena JSON
         //Le indicamos a felxjson que ignore el atributo "class", ya que no lo necesita el REST hecho en .Net
        JSONSerializer jss = new flexjson.JSONSerializer().exclude("*.class");
        
        //Este objeto nos permitira convertir la respuesta JSON del servidor
        //JSONDeserializer jdss = new JSONDeserializer();
        
        JSONObject jso = null;
        strJson = jss.serialize(c);
        System.out.println(strJson);
        
        //Establecemos el metodo de conexión
        connHttp.setRequestMethod("POST");
        
        //Indicamos que enviaremos los parametros codificador a traves del cuerpo de la peticion BODY
        connHttp.setRequestProperty("Content-Type", "application/json");
        
        //Establecemos que enviaremos los valores por un metodo POST
        connHttp.setDoOutput(true);
        
        //Establecemos que recibiremos respuresta del servidor
        connHttp.setDoInput(true);
        
        //Enviamos los parametros al servidor
        out = new BufferedOutputStream(connHttp.getOutputStream());
        bwriter = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
        bwriter.write(strJson);
        bwriter.flush();
        bwriter.close();
        out.close();
        
        //Mantenemos la conexion con el servidor
        connHttp.connect();
        
        //Le pedimos al servidor que pricese la peticion y esperamos la respuesta
        respuestaServidor = connHttp.getResponseCode();
        
        //Verificamos que nos respinda de forma satisfactoria
        if(respuestaServidor != HttpURLConnection.HTTP_OK)
        {
            throw new Exception("El servidor respondió con codigo " + respuestaServidor);
        }
    }
    public ObservableList<Cliente> getAll(String filtro) throws Exception
    {
        ObservableList<Cliente> clientes = FXCollections.observableArrayList();
        
        //Configuramos la URL del Servicio:
        String rutaServicio = URL_REST+"ConsultarCliente";
        URL url = new URL(rutaServicio);
        HttpURLConnection connHttp = (HttpURLConnection)url.openConnection();
        
        //Aquí guardamos la respuesta del servidor:
        int respuestaServidor = 0; //Revisar los tipos de respusta que puede mandar
        
        //Este objeto nos arudara a capturar la respuesta a ir leuendo la respuesta
        BufferedReader br = null;
        
        //Esta es una variable auxiliar que nos ayudara a ir leyendo la respuesta del seridor
        String lineaActual;
        
        //En esta variable se ira guardando la respuesta del servidor hasta que finalice de responder
        String contenidoRespuesta = "";
        
        //Este objeto nos permitira convertir la respuesta JSON del servidor
        //en una lista observable con objetos tipo cliente:
        JSONDeserializer<ObservableList<Cliente>> jdss = new JSONDeserializer<ObservableList<Cliente>>();
        
        //Establecemos el metodo de conexion
        connHttp.setRequestMethod("GET");
        
        //Le pedimos al servidor que precese la pericion y esperamos la respuesta
        respuestaServidor = connHttp.getResponseCode();
        
        //Verificamos que nos responda de forma satisfactoria
        if(respuestaServidor == HttpURLConnection.HTTP_OK)
        {
            br = new BufferedReader(
                new InputStreamReader(connHttp.getInputStream()));
            
            //Leemos la respuesta del servidor
            while((lineaActual = br.readLine()) != null)
                contenidoRespuesta += lineaActual;
            br.close();
            
            //Nos desconectamos del servidor
            connHttp.disconnect();
            
            //Le indicamos el objeto JSONDeserializer que convierta los elementos de la
            //propiedad "values" en objetos de tipo Alumno
            //Esta propiedad se envia asi por default desde el servidor
            jdss.use("values", Cliente.class);
            clientes = FXCollections.observableArrayList(jdss.deserialize(contenidoRespuesta));
        }
        else
        {
            throw new Exception("El servidor respondió con codigo " + respuestaServidor);
        }
        return clientes;
    }//Fin del metodo
}
