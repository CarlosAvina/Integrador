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
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author franc
 */
public class WindowMain extends javafx.application.Application{
    @FXML JFXDrawer dDrawer;
    @FXML JFXHamburger hamburger;
    @FXML BorderPane pnlPrincipal;
    @FXML StackPane leftSide;
    
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
        fxmll = new FXMLLoader(System.class.getResource("/org/jwonkafx/gui/fxml/MainWindow.fxml"));
        fxmll.setController(this);
    }
    
    
    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        try{
        fxmll.load(); 
        scene = new Scene(fxmll.getRoot()); 
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
        
        VBox vbRoot = FXMLLoader.load(getClass().getResource("/org/jwonkafx/gui/fxml/Navegacion.fxml"));
        dDrawer.setSidePane(vbRoot);
        
        HamburgerBackArrowBasicTransition burgerTask2 = new HamburgerBackArrowBasicTransition(hamburger);
        burgerTask2.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            burgerTask2.setRate(burgerTask2.getRate() * -1);
            burgerTask2.play();
            
            if(dDrawer.isShown())
            {
                dDrawer.close();
            }
            else
            {
                dDrawer.open();
            }
        });
        
        panelClientes = new panel_clientes();
        panelClientes.inicializar();
        
        panelVentas = new panel_ventas();
        panelVentas.inicializar();
        
        panelProductos = new panel_productos();
        panelProductos.inicializar();
        
        panelCompras = new panel_compra();
        panelCompras.inicializar();
        
        panelEmpleados = new panel_empleados();
        panelEmpleados.inicializar();
        
        for(Node node : vbRoot.getChildren())
        {
            if(node.getAccessibleText() != null)
            {
                node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
                    switch(node.getAccessibleText())
                    {
                        case "Clientes":
                            try {
                                pnlPrincipal.setCenter(panelClientes.getPanelRoot());
                            } catch (Exception ex) {
                                Logger.getLogger(WindowMain.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                            
                        case "Empleados":
                            try {
                                pnlPrincipal.setCenter(panelEmpleados.getPanelRoot());
                            } catch (Exception ex) {
                                Logger.getLogger(WindowMain.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                            
                        case "Ventas":
                            try{
                                pnlPrincipal.setCenter(panelVentas.getPanelRoot());
                            } catch (Exception ex) {
                                Logger.getLogger(WindowMain.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                        
                        case "Compras": 
                            try{
                                pnlPrincipal.setCenter(panelCompras.getPanelRoot());
                            } catch (Exception ex) {
                                Logger.getLogger(WindowMain.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                            
                        case "Productos": 
                            try{
                                pnlPrincipal.setCenter(panelProductos.getPanelRoot());
                            } catch (Exception ex) {
                                Logger.getLogger(WindowMain.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                    }
                });
            }
        }
    }   
}