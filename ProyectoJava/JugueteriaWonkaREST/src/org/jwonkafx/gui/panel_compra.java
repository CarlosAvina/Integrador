/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jwonkafx.gui;

import com.github.sarxos.webcam.Webcam;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
//import org.grios.jwebcam.WebCamAdapter;
import org.grios.jwebcam.WebCamAdapterFX;
import org.jwonkafx.core.ControladorCliente;
import org.jwonkafx.core.ControladorCompra;
import org.jwonkafx.core.ControladorDetalleCompra;
import org.jwonkafx.gui.components.FechasAdaptador;
import org.jwonkafx.gui.components.TableAdapterCliente;
import org.jwonkafx.gui.components.TableAdapterCompra;
import org.jwonkafx.gui.components.TableAdapterCompraDetalle;
import org.jwonkafx.model.Cliente;
import org.jwonkafx.model.Compra;
import org.jwonkafx.model.DetalleCompra;
import org.jwonkafx.model.Persona;
import org.jwonkafx.model.Producto;

/**
 *
 * @author karla
 */
public class panel_compra {
    @FXML AnchorPane pnlRoot;
    @FXML JFXComboBox cmbProducto;
    @FXML JFXTextField txtCompraPrecio;
    @FXML JFXTextField txtCantidadProducto;
    @FXML JFXButton btnMenos;
    @FXML JFXButton btnMas;
    @FXML JFXButton btnAgregar;
    @FXML JFXButton btnGuardar;
    @FXML JFXButton btnconsultarCompras;
    @FXML TableView<DetalleCompra> tblProductos;
    @FXML TableView<Compra> tblVerCompra;
    @FXML TableView<DetalleCompra> tblVerDetalleCompra;
    
    WebCamAdapterFX webcamfx;
    FXMLLoader fxmll;
    
    ControladorCompra cc;
    ControladorDetalleCompra cdc;
    ArrayList<DetalleCompra> dcL;


    public panel_compra()
    {
        cc = new ControladorCompra();
        cdc = new ControladorDetalleCompra();
        dcL = new ArrayList<DetalleCompra>();
    }
    
    public void inicializar() throws Exception
    {
        fxmll= new FXMLLoader(System.class.getResource("/org/jwonkafx/gui/fxml/panel_compra.fxml"));
        fxmll.setController(this);
        fxmll.load();

        tblProductos.setItems(FXCollections.observableArrayList());
        TableAdapterCompraDetalle.adapt(tblProductos);

        tblVerDetalleCompra.setItems(FXCollections.observableArrayList());
        TableAdapterCompraDetalle.adapt(tblVerDetalleCompra);

        tblVerCompra.setItems(FXCollections.observableArrayList());
        TableAdapterCompra.adapt(tblVerCompra);

        //btnEliminarCompra.setOnAction(evt->{eliminarCompra();});
        btnGuardar.setOnAction(evt->{
            insertar();
            nuevo();
        });

        this.tblProductos.setOnMouseClicked(evt-> {
            if(evt.getClickCount() == 2){
               dcL.remove(tblProductos.getSelectionModel().selectedItemProperty().getValue());
               consultar("");
            }
         });

        this.btnconsultarCompras.setOnMouseClicked(evt-> {
             cargarCompras("");
         });

        this.tblVerCompra.setOnMouseClicked(evt-> {
                Compra c = new Compra();
                c = tblVerCompra.getSelectionModel().selectedItemProperty().getValue();
                //this.txtID.setText(""+c.getIdCompra());

                ObservableList<DetalleCompra> oList = FXCollections.observableArrayList(dcL);
                try{
                   oList = cdc.getAll("", c.getIdCompra());
                   tblVerDetalleCompra.setItems(oList);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
        });
    }

    public AnchorPane getPanelRoot()
    {
        return pnlRoot;
    }
    
    private void insertar()
    {
        float total = 0;
        Compra c = new Compra();
        try{
            c.setListaProductos(dcL);
            
            for(int i = 0;i < dcL.size();i++)
                total += dcL.get(i).getPrecioCompra();
            c.setTotal(total);
            
            cc.insert(c);
            for (int i = 0; i < c.getListaProductos().size() ; i++) {
                cdc.insert(c.getListaProductos().get(i), c.getIdCompra());
            }
            limpiar();
            Alert alert=new Alert(AlertType.INFORMATION,"Se agrego correctamente");
            alert.show();    
        }catch(Exception e)
        {
            e.printStackTrace();
            Alert alert=new Alert(AlertType.ERROR,"Revise los campos \nERROR:"+e,ButtonType.OK);
            alert.show();    
        }
    }
    
    private void eliminarCompra(){
        try
        {
            int idCompra;
            idCompra = 1; //Obtener el id de la compra
            cc.delete(idCompra);
            ObservableList<DetalleCompra> dcompras =FXCollections.observableArrayList();
            tblVerDetalleCompra.setItems(dcompras);
           cargarCompras("");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    private void nuevo()
    {
        DetalleCompra dc = new DetalleCompra();
        Producto p = new Producto();
        try{
            //p.setId(Integer.valueOf(txtIdProducto.getText()));
            dc.setCantidad(Integer.valueOf(txtCantidadProducto.getText()));
            dc.setPrecioCompra(Float.valueOf(txtCompraPrecio.getText()));
            dc.setTotal((Float.valueOf(txtCompraPrecio.getText())) *  (Integer.valueOf(txtCantidadProducto.getText())));
            dc.setProducto(p);
            dcL.add(dc);
            consultar("");
            
        }catch(Exception e)
        {
            Alert alert=new Alert(AlertType.ERROR,"Revise los campos \nERROR:"+e,ButtonType.OK);
            alert.show();    
        }
    }
    
    private void consultar(String filtro)
    {
        ObservableList<DetalleCompra> oList = FXCollections.observableArrayList(dcL);
        try{
            tblProductos.setItems(oList);

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    
    private void limpiar(){
        txtCantidadProducto.setText("");
        txtCompraPrecio.setText("");
        dcL.clear();
        consultar("");
    }
    
    private void cargarCompras(String filtro){
        ObservableList<Compra> compras= null;
        try{
            compras = cc.getAll(filtro);
            tblVerCompra.setItems(compras);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}