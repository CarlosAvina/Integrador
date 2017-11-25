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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import org.grios.jwebcam.WebCamAdapterFX;
import org.jwonkafx.core.ControladorProducto;
import org.jwonkafx.gui.components.TableAdapterProducto;
import org.jwonkafx.model.Producto;
import org.jwonkafx.model.Marca;

/**
 *
 * @author danie
 */
public class panel_productos {
    
    @FXML AnchorPane pnlRoot;
    @FXML JFXTextField txtNombre;
    @FXML JFXTextField txtPrecio;
    @FXML JFXTextField txtDescripcion;
    @FXML JFXTextField txtEdadMinima;
    @FXML JFXTextField txtEdadMaxima;
    @FXML JFXComboBox cmbMarca;
    @FXML JFXButton btnGuardar;
    @FXML JFXButton btnConsultar;
    @FXML JFXButton btnLoad;
    @FXML TableView<Producto> tblProductos;
    @FXML ImageView imgvFoto;
    
    FXMLLoader fxmll;
    ControladorProducto cpr;
    
    public panel_productos() 
    {        
        cpr = new ControladorProducto();
    }
    
    public void inicializar() throws Exception
    {
        fxmll = new FXMLLoader(System.class.getResource("/org/jwonkafx/gui/fxml/panel_producto.fxml"));
        fxmll.setController(this);
        fxmll.load();
        
        tblProductos.setItems(FXCollections.observableArrayList());
        TableAdapterProducto.adapt(tblProductos);
        
        btnConsultar.setOnAction(evt ->{ consultar();});
        btnGuardar.setOnAction(evt -> {guardarProducto();});
//        btnEliminar.setOnAction(evt->{try {
//            eliminarProducto();
//            } catch (Exception ex) {
//                Logger.getLogger(panel_productos.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
        btnLoad.setOnAction(evt->{cargarImagen();});
        tblProductos.setOnMouseClicked(evt->{try {
            agarrarProducto(tblProductos.getSelectionModel().selectedItemProperty().getValue());
            } catch (Exception ex) {
                Logger.getLogger(panel_productos.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        cargarMarcas();
    }
    public void vaciarControles()
    {
        txtNombre.setText("");
        txtEdadMinima.setText("");
        txtEdadMaxima.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
        this.imgvFoto.setImage(null);
    }
    public AnchorPane getPanelRoot()
    {
        return pnlRoot;
    }
    
   public void cargarMarcas()
   {
        ObservableList<Marca> marcas = null;
        
        try
        {
            marcas = cpr.getAllMarcas();
            ObservableList<String> nombreMarcas = FXCollections.observableArrayList();
            for(int i=0; i<marcas.size();i++)
            {
                nombreMarcas.add(marcas.get(i).getNombre());
            }
            cmbMarca.setItems(nombreMarcas);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
   }
    
    public void consultar ()
    {
        ObservableList<Producto> productos = null;
        
        try
        {
            productos = cpr.getAll();
            tblProductos.setItems(productos);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void guardarProducto()
    {
        Producto pr = new Producto();
        Marca m = new Marca();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Guardar producto");
        
        try{
            pr.setNombre(txtNombre.getText());
            pr.setDescripcion(txtDescripcion.getText());
            pr.setPrecio(Float.valueOf(txtPrecio.getText()));
            pr.setEdadMinima(Integer.valueOf(txtEdadMinima.getText()));
            pr.setEdadMaxima(Integer.valueOf(txtEdadMaxima.getText()));
            
            if(imgvFoto.getImage() != null)
                pr.setFotografia(WebCamAdapterFX.encodeImageURLSafe(SwingFXUtils.fromFXImage(imgvFoto.getImage(), null)));
            else
                pr.setFotografia("");

            m.setId(Integer.valueOf(cmbMarca.getSelectionModel().getSelectedIndex())+1);
            pr.setMarca(m);
            
            if(pr.getId()>0&&pr.getMarca().getId()>0){
                cpr.update(pr);
                consultar();
            }
            else{
                cpr.insert(pr); 
            
                vaciarControles();
                consultar();
                consultar();            
            }
        
            alert.setContentText("Producto Registrado registrado");
            alert.show();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            alert.setContentText("Error");
            alert.show();
        }
    }

   private void agarrarProducto(Producto pr) throws Exception
   {
       txtNombre.setText(pr.getNombre());
       txtDescripcion.setText(pr.getDescripcion());
       txtPrecio.setText(String.valueOf(pr.getPrecio()));
       txtEdadMinima.setText(String.valueOf(pr.getEdadMinima()));
       txtEdadMaxima.setText(String.valueOf(pr.getEdadMaxima()));
       Integer activo = pr.getActivo();

       cmbMarca.setValue(String.valueOf(pr.getMarca().getNombre()));
             
       imgvFoto.setImage(SwingFXUtils.toFXImage(WebCamAdapterFX.decodeImageURLSafe(pr.getFotografia()),null));
   }
    
private void eliminarProducto() throws Exception
{
    Producto pr = new Producto();
     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Eliminar producto");
    if(cpr.delete(1)==true)//1 representa el id del producto
    {
        alert.setContentText("Producto Eliminado");
        alert.show();
        vaciarControles();
        consultar();
    }
    else
    {
        alert.setContentText("No se pudo eliminar");
        alert.show();
    }
}

 private void cargarImagen() {
         FileChooser fileChooser = new FileChooser();
             
            //Set extension filter
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
              
            //Show open file dialog
            File file = fileChooser.showOpenDialog(null);
                       
            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                imgvFoto.setImage(image);   //<--------- un control de imageview
            } catch (IOException ex) {
                Logger.getLogger(panel_productos.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
