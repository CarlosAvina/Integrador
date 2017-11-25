/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jwonkafx.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import org.jwonkafx.core.ControladorVentas;
import org.jwonkafx.gui.components.TableAdapterDetalleVenta;
import org.jwonkafx.gui.components.TableAdapterVProducto;
import org.jwonkafx.gui.components.TableAdapterVenta;
import org.jwonkafx.model.Cliente;
import org.jwonkafx.model.DetalleVenta;
import org.jwonkafx.model.Empleado;
import org.jwonkafx.model.FormaPago;
import org.jwonkafx.model.Marca;
import org.jwonkafx.model.Producto;
import org.jwonkafx.model.Venta;

/**
 *
 * @author Carlos Aviña
 */
public class panel_ventas {
    @FXML AnchorPane pnlRoot;
    //@FXML JFXTextField txtIdEmpleado;
    //@FXML JFXTextField txtIdCliente;
    @FXML JFXTextField txtProducto;
    @FXML JFXTextField txtCantidad;
    @FXML JFXComboBox cmbEmpleado;
    @FXML JFXComboBox cmbCliente;
    @FXML JFXComboBox cmbFormaPago;
    @FXML TableView tblProductos;
    @FXML TableView tblDetalleVenta;
    @FXML TableView tblVerVenta;
    @FXML TableView tblVerDetalleVenta;
    @FXML Label lblProducto;
    @FXML Label lblPrecio;
    @FXML JFXButton btnAgregar;
    @FXML JFXButton btnMenos;
    @FXML JFXButton btnMas;
    @FXML JFXButton btnVenta;
    @FXML JFXButton btnActualizar;
    @FXML ImageView imgFoto;
    
    FXMLLoader fxmll;
    ControladorVentas cv;
    
    public int cantidadProducto = 1;
    public Producto prod;
    public DetalleVenta det;
    public ObservableList<DetalleVenta> listDetalleVenta = FXCollections.observableArrayList();;
    
    public void nuevoProducto()
    {
        prod = new Producto();
    }
    
    public panel_ventas() 
    {        
        cv = new ControladorVentas();
    }
    
    public AnchorPane getPanelRoot()
    {
        return pnlRoot;
    }
    
    public void inicializar() throws Exception
    {
        fxmll = new FXMLLoader(System.class.getResource("/org/jwonkafx/gui/fxml/panel_venta.fxml"));
        fxmll.setController(this);
        fxmll.load();
        
        setComboBoxFP();
        tblProductos.setItems(FXCollections.observableArrayList());
        TableAdapterVProducto.adapt(tblProductos);
        tblDetalleVenta.setItems(FXCollections.observableArrayList());
        TableAdapterDetalleVenta.adapt(tblDetalleVenta);
        tblVerVenta.setItems(FXCollections.observableArrayList());
        TableAdapterVenta.adapt(tblVerVenta);
        tblVerDetalleVenta.setItems(FXCollections.observableArrayList());
        TableAdapterDetalleVenta.adapt(tblVerDetalleVenta);
        
        getVenta();
        
        txtProducto.setOnKeyTyped(
            new EventHandler<KeyEvent>() {
                public void handle(KeyEvent ke) {
                    System.out.println("Key Pressed: " + ke.getText());
                    try {
                        traerProductos(txtProducto.getText());
                        //TableAdapterVProducto.adapt(tblProductos);
                    } catch (Exception ex) {
                        Logger.getLogger(panel_ventas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        
        tblProductos.setOnMouseClicked(evt->{try {
            agarraProducto((Producto) tblProductos.getSelectionModel().selectedItemProperty().getValue());
            btnMas.setDisable(false);
            btnMenos.setDisable(false);
            btnAgregar.setDisable(false);
            } catch (Exception ex) {
                Logger.getLogger(panel_clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        tblVerVenta.setOnMouseClicked(evt->{try {
            getDetalleVenta((Venta)tblVerVenta.getSelectionModel().selectedItemProperty().getValue());
            } catch (Exception ex) {
                Logger.getLogger(panel_clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btnMenos.setOnAction(evt -> { try {
            restarSumar(1, prod.getPrecio());
            } catch (Exception ex) {
                Logger.getLogger(panel_ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btnMas.setOnAction(evt -> { try {
            restarSumar(2, prod.getPrecio());
            } catch (Exception ex) {
                Logger.getLogger(panel_ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btnAgregar.setOnAction(evt -> { añadeProducto(); });
        
        btnVenta.setOnAction(evt -> { try {
            insertaVenta();
            } catch (Exception ex) {
                Logger.getLogger(panel_ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
//        btnEliminar.setOnAction(evt -> { try {
//            eliminarVenta(Integer.valueOf(txtIdVenta.getText()));
//            } catch (Exception ex) {
//                Logger.getLogger(panel_ventas.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
        
        tblDetalleVenta.setOnMouseClicked(evt -> { 
            if(evt.getClickCount() == 2)
            {
                listDetalleVenta.remove(tblDetalleVenta.getSelectionModel().selectedItemProperty().getValue());
                tblDetalleVenta.setItems(listDetalleVenta);
            }
        });
        
        btnActualizar.setOnAction(evt -> { getVenta(); });
    }
    
    public void traerProductos(String producto) throws Exception
    {
        ObservableList<Producto> listProductos = null;
        try
        {
            listProductos = cv.getProductos(producto);
            tblProductos.setItems(listProductos);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void restarSumar(int opcion, float precio) throws Exception
    {
        switch(opcion)
        {
            case 1:
                if(cantidadProducto - 1 > 0)
                {
                    cantidadProducto -= 1;
                    txtCantidad.setText(String.valueOf(cantidadProducto));
                    lblPrecio.setText(String.valueOf(cantidadProducto * precio));
                }
                break;
            case 2:
                if(cantidadProducto + 1 <= prod.getStock())
                {
                    cantidadProducto += 1;
                    txtCantidad.setText(String.valueOf(cantidadProducto));
                    lblPrecio.setText(String.valueOf(cantidadProducto * precio));
                }
                break;
        }
    }
    
    private void agarraProducto(Producto p) throws Exception
    {
       nuevoProducto();
       prod = p;
       
       txtCantidad.setText("1");
       cantidadProducto = 1;
       lblProducto.setText(String.valueOf(p.getNombre()) + ":");
       lblPrecio.setText(String.valueOf(p.getPrecio()));
   }
    
    public void setComboBoxFP()
    {
        ObservableList<FormaPago> listPago = null;
        try
        {
            listPago = cv.getFormaPago();
            cmbFormaPago.getItems().add(listPago.get(0).getDescripcion());
            cmbFormaPago.getItems().add(listPago.get(1).getDescripcion());
            cmbFormaPago.getItems().add(listPago.get(2).getDescripcion());
            cmbFormaPago.getItems().add(listPago.get(3).getDescripcion());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void añadeProducto()
    {
        int s = (Integer.valueOf(txtCantidad.getText()));
        if(prod.getStock() <= s)
        {
            det = new DetalleVenta();
            det.setCantidadProducto(s);
            det.setPrecio(prod.getPrecio() * s);
            det.setProducto(prod);

            listDetalleVenta.add(det);
            tblDetalleVenta.setItems(listDetalleVenta);
        }
    }
    
    public void insertaVenta() throws Exception
    {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText("Guardar venta");
        
        Venta v = new Venta();
        Cliente cliente = new Cliente();
        Empleado empleado = new Empleado();
        FormaPago formaPago = new FormaPago();
        
        try
        {
            //cliente.setId(Integer.valueOf(txtIdCliente.getText()));
            //empleado.setId(Integer.valueOf(txtIdEmpleado.getText()));
            formaPago.setId(getIdFormaPago());
        
            v.setCliente(cliente);
            v.setEmpleado(empleado);
            v.setFormaPago(formaPago);
        
            cv.insertar(v, listDetalleVenta);
        
            alert.setContentText("Venta registrada");
            alert.show();
        }catch (Exception ex)
        {
            ex.printStackTrace();
            alert.setContentText("Error");
            alert.show();
        }
    }
    
    public int getIdFormaPago() throws Exception
    {
        int id = 0;
        ObservableList<FormaPago> list = cv.getFormaPago();
        for(int i = 0;i < list.size();i++)
        {
            if(cmbFormaPago.getSelectionModel().getSelectedItem().toString().equals(list.get(i).getDescripcion()))
                id = list.get(i).getId();
        }
        return id;
    }
    
    public void getVenta()
    {
        ObservableList<Venta> listVenta = null;
        try
        {
            listVenta = cv.getVentas();
            tblVerVenta.setItems(listVenta);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void eliminarVenta(int idVenta) throws Exception
    {
        cv.deleteVenta(idVenta);
        getVenta();
    }
    
    public void getDetalleVenta(Venta venta) throws Exception
    {
        ObservableList<DetalleVenta> list;
        list = cv.getDetalleVenta(venta.getId());
        tblVerDetalleVenta.setItems(list);
    }
}
