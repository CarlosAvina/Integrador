/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jwonkafx.gui;
import com.github.sarxos.webcam.Webcam;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXTextField;
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
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.grios.jwebcam.WebCamAdapterFX;
import org.jwonkafx.core.ControladorCliente;
import org.jwonkafx.gui.components.TableAdapterCliente;
import org.jwonkafx.model.Cliente;
import org.jwonkafx.model.Persona;

/**
 *
 * @author franc
 */
public class panel_clientes{
    @FXML AnchorPane pnlRoot;
    @FXML JFXTextField txtNombre;
    @FXML JFXTextField txtApellidoPaterno;
    @FXML JFXTextField txtApellidoMaterno;
    @FXML JFXTextField txtRfc;
    @FXML JFXTextField txtCurp;
    @FXML JFXTextField txtDomicilio;
    @FXML JFXTextField txtCodigoPostal;
    @FXML JFXTextField txtFiltro;
    @FXML JFXTextField txtEmail;
    @FXML JFXTextField txtTelefono;
    @FXML JFXDatePicker dpkFechaNacimiento;
    @FXML JFXComboBox cmbGenero;
    @FXML JFXComboBox cmbCamarasWeb;
    @FXML JFXButton btnGuardar;
    @FXML JFXButton btnEliminar;
    @FXML JFXButton btnConsultar;
    @FXML JFXButton btnTomarFoto;
    @FXML JFXButton btnIniciarCamaraWeb;
    @FXML JFXButton btnBuscarCliente;
    @FXML TableView<Cliente> tblClientes;
    @FXML ImageView imgvCamaraWeb;
    @FXML ImageView imgvFoto;
    @FXML JFXCheckBox chbActivo;
    @FXML FlowPane flowpane;
    @FXML JFXDialog popup;
    
    FXMLLoader fxmll;
    WebCamAdapterFX webcamfx;
    ControladorCliente cc;
    
    public int idCliente = 0;
    public int idPersona = 0;
    
    public panel_clientes() 
    {        
        cc = new ControladorCliente();
    }
    
    public void inicializar() throws Exception
    {
        fxmll = new FXMLLoader(System.class.getResource("/org/jwonkafx/gui/fxml/panel_clientes.fxml"));
        fxmll.setController(this);
        fxmll.load();
        
        cmbGenero.getItems().add("Hombre");
        cmbGenero.getItems().add("Mujer");
        cmbGenero.getItems().add("Otro");
        
        tblClientes.setItems(FXCollections.observableArrayList());
        TableAdapterCliente.adapt(tblClientes);
        
        btnConsultar.setOnAction(evt ->{ consultar(""); });
        btnGuardar.setOnAction(evt -> {
            guardarCliente();
            vaciarTextos();
        });
        
        btnIniciarCamaraWeb.setOnAction(evt -> { iniciarCamaraWeb(); });
        btnTomarFoto.setOnAction(evt -> { tomarFoto(); });
        
        tblClientes.setOnMouseClicked(evt->{try {
            agarraPersona(tblClientes.getSelectionModel().selectedItemProperty().getValue());
            } catch (Exception ex) {
                Logger.getLogger(panel_clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        tblClientes.setOnMouseClicked(evt-> {
            if(evt.getClickCount() == 2){
                try {
                    newStage(tblClientes.getSelectionModel().selectedItemProperty().getValue());
                } catch (IOException ex) {
                    Logger.getLogger(panel_clientes.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(panel_clientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        consultarWebCams();
        
        btnEliminar.setOnAction(evt-> {
            try {
                eliminar(idCliente);
            } catch (Exception ex) {
                Logger.getLogger(panel_ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    public AnchorPane getPanelRoot()
    {
        return pnlRoot;
    }
    
    private void eliminar(int idCliente) throws Exception
        {
            try
            {
                Cliente c = new Cliente();
                {
                    c.setId(idCliente);
                    cc.delete(c);
                    
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    
    
    
    private void tomarFoto()
    {
        if(webcamfx != null && webcamfx.isStarted())
            imgvFoto.setImage(SwingFXUtils.toFXImage(webcamfx.getBufferedImage(),null));
    }
    
    public void consultar (String filtro)
    {
        ObservableList<Cliente> clientes = null;
        
        try
        {
            clientes = cc.getAll(filtro);
            tblClientes.setItems(clientes);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void consultarWebCams()
    {
        Webcam[] cams = WebCamAdapterFX.getSystemCamDevicesAsArray();
        cmbCamarasWeb.getItems().clear();
        for (Webcam w : cams) 
            cmbCamarasWeb.getItems().add(w.getName());
        
    }
    
    private void iniciarCamaraWeb()
    {
        if(webcamfx == null)
            webcamfx = new WebCamAdapterFX(imgvFoto);
        if(webcamfx.isStarted())
            webcamfx.stop();
        if(cmbCamarasWeb.getSelectionModel().getSelectedItem()!= null)
            webcamfx.start(cmbCamarasWeb.getSelectionModel().getSelectedItem().toString());
    }
    
    private void guardarCliente()
    {
        Cliente c = new Cliente();
        Persona p = new Persona();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText("Guardar cliente");
        
        try{
        p.setApellidoMaterno(txtApellidoMaterno.getText());
        p.setApellidoPaterno(txtApellidoPaterno.getText());
        p.setCp(txtCodigoPostal.getText());
        p.setCurp(txtCurp.getText());
        p.setDomicilio(txtDomicilio.getText());
        p.setFechaNacimiento(dpkFechaNacimiento.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        p.setGenero(cmbGenero.getSelectionModel().getSelectedItem().toString());
        p.setNombre(txtNombre.getText());
        p.setRfc(txtRfc.getText());
        p.setId(idPersona);
        
        if(imgvFoto.getImage() != null)
            p.setFotografia(WebCamAdapterFX.encodeImageURLSafe(SwingFXUtils.fromFXImage(imgvFoto.getImage(), null)));
        else
            p.setFotografia("");
        
        
        c.setActivo((chbActivo.isSelected()?1:0));
        c.setEmail(txtEmail.getText());
        c.setPersona(p);
        c.setTelefono(txtTelefono.getText());
        c.setId(idCliente);
        
            
        if(c.getId() > 0 && c.getPersona().getId() > 0)
            cc.update(c);
        else
            cc.insert(c);
        
        alert.setContentText("Usuarior registrado");
        alert.show();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            alert.setContentText("Error");
            alert.show();
        }
    }
    
    private void agarraPersona(Cliente c) throws Exception
    {
        idCliente = c.getId();
        idPersona = c.getPersona().getId();
        
        txtNombre.setText(c.getPersona().getNombre());
        txtApellidoPaterno.setText(c.getPersona().getApellidoPaterno());
        txtApellidoMaterno.setText(c.getPersona().getApellidoMaterno());
        txtRfc.setText(c.getPersona().getRfc());

        if(c.getActivo() == 1)
            chbActivo.setSelected(true);
        else
            chbActivo.setSelected(false);

        txtCurp.setText(c.getPersona().getCurp());
        txtCodigoPostal.setText(c.getPersona().getCp());
        txtDomicilio.setText(c.getPersona().getDomicilio());
        txtEmail.setText(c.getEmail());
        txtTelefono.setText(c.getTelefono());

        LocalDate fecha = LocalDate.parse(c.getPersona().getFechaNacimiento(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        dpkFechaNacimiento.setValue(fecha);

        cmbGenero.setValue(c);
        
        if(c.getPersona().getFotografia() != null && c.getPersona().getFotografia() != "")
            imgvFoto.setImage(SwingFXUtils.toFXImage(WebCamAdapterFX.decodeImageURLSafe(c.getPersona().getFotografia()),null));
        else
            imgvFoto.setImage(null);
   }
    
    private void vaciarTextos()
    {
        txtNombre.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        txtRfc.setText("");
        txtCurp.setText("");
        txtDomicilio.setText("");
        txtCodigoPostal.setText("");
        txtEmail.setText("");
        txtTelefono.setText("");
        dpkFechaNacimiento.setValue(null);
        cmbGenero.setValue(null);
        chbActivo.setSelected(false);
    }
    
    public void newStage(Cliente cliente) throws IOException, Exception
    {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Editar cliente");
        
//        fxmll = new FXMLLoader(System.class.getResource("/org/jwonkafx/gui/fxml/panel_clientes.fxml"));
//        fxmll.setController(this);
//        fxmll.load();
        inicializar();
        
        Scene scene = new Scene(new FlowPane(flowpane));
        window.setScene(scene);
        
        btnEliminar.setDisable(false);
        agarraPersona(cliente);
        
        window.showAndWait();
    }
    
    private void initPopup()
    {
        //JFXPopup popup = new JFXPopup();
        JFXButton eliminar = new JFXButton("Eliminar");
        
        eliminar.setPadding(new Insets(10));
        
        VBox vBox = new VBox(eliminar);
        
        popup.setContent(vBox);
        //popup.setSource(vBox);
    }
}   

