/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jwonkafx.gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author franc
 */
public class WindowMain extends javafx.application.Application{
    @FXML Button btnCargarModuloClientes;
    @FXML Button btnCargarModuloEmpleados;
    @FXML Button btnCargarModuloVentas;
    @FXML Button btnCargarModuloCompras;
    @FXML Button btnCargarModuloProductos;
    @FXML BorderPane pnlPrincipal;
    
    FXMLLoader fxmll;
    Scene scene;
    Stage stage;
    
    panel_clientes panelClientes;
    panel_ventas panelVentas;
    panel_productos panelProductos;
    panel_compra panelCompras;
    panel_empleados panelEmpleados;
    
    public WindowMain()
    {
        super();
        fxmll = new FXMLLoader(System.class.getResource("/org/jwonkafx/gui/fxml/window_main.fxml"));
        fxmll.setController(this);
    }
    
    
    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        try{
        fxmll.load(); 
        scene = new Scene(fxmll.getRoot()); 
        scene.getStylesheets().add("bootstrap3.css");
        stage = primaryStage;
        stage.setScene(scene);
        stage.setTitle("Juguetería");
        
        inicializarComponentes();
        stage.show();
        
       
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void inicializarComponentes() throws Exception
    {       
        stage.setOnCloseRequest(evt -> {System.exit(0); });
        
        panelClientes = new panel_clientes();
        panelClientes.inicializar();
        btnCargarModuloClientes.setOnAction(evt -> {pnlPrincipal.setCenter(panelClientes.getPanelRoot());});
        
        panelVentas = new panel_ventas();
        panelVentas.inicializar();
        btnCargarModuloVentas.setOnAction(evt -> {pnlPrincipal.setCenter(panelVentas.getPanelRoot());});
        
        panelProductos = new panel_productos();
        panelProductos.inicializar();
        btnCargarModuloProductos.setOnAction(evt -> {pnlPrincipal.setCenter(panelProductos.getPanelRoot());});
        
        panelCompras = new panel_compra();
        panelCompras.inicializar();
        btnCargarModuloCompras.setOnAction(evt -> {pnlPrincipal.setCenter(panelCompras.getPanelRoot());});
        
        panelEmpleados = new panel_empleados();
        panelEmpleados.inicializar();
        btnCargarModuloEmpleados.setOnAction(evt -> {pnlPrincipal.setCenter(panelEmpleados.getPanelRoot());});
    }   
}
//Este es el segundo