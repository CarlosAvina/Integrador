/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jwonkafx.gui;
import com.github.sarxos.webcam.Webcam;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
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
    @FXML TextField txtNombre;
    @FXML TextField txtApellidoPaterno;
    @FXML TextField txtApellidoMaterno;
    @FXML TextField txtIdCliente;
    @FXML TextField txtIdPersona;
    @FXML TextField txtRfc;
    @FXML TextField txtCurp;
    @FXML TextField txtDomicilio;
    @FXML TextField txtCodigoPostal;
    @FXML TextField txtFiltro;
    @FXML TextField txtEmail;
    @FXML TextField txtTelefono;
    @FXML DatePicker dpkFechaNacimiento;
    @FXML ComboBox cmbGenero;
    @FXML ComboBox cmbCamarasWeb;
    @FXML Button btnCrearNuevo;
    @FXML Button btnGuardar;
    @FXML Button btnEliminar;
    @FXML Button btnConsultar;
    @FXML Button btnTomarFoto;
    @FXML Button btnIniciarCamaraWeb;
    @FXML Button btnBuscarCliente;
    @FXML TableView<Cliente> tblClientes;
    @FXML ImageView imgvCamaraWeb;
    @FXML ImageView imgvFoto;
    @FXML CheckBox chbActivo;
    
    FXMLLoader fxmll;
    WebCamAdapterFX webcamfx;
    ControladorCliente cc;
    
    public panel_clientes() 
    {        
        cc = new ControladorCliente();
    }
    
    public void inicializar() throws Exception
    {
        fxmll = new FXMLLoader(System.class.getResource("/org/jwonkafx/gui/fxml/panel_clientes.fxml"));
        fxmll.setController(this);
        fxmll.load();
        
        tblClientes.setItems(FXCollections.observableArrayList());
        TableAdapterCliente.adapt(tblClientes);
        
        btnCrearNuevo.setOnAction(evt -> { vaciarTextos(); });
        btnConsultar.setOnAction(evt ->{ consultar(""); });
        btnGuardar.setOnAction(evt -> { guardarCliente(); });
        btnIniciarCamaraWeb.setOnAction(evt -> { iniciarCamaraWeb(); });
        btnTomarFoto.setOnAction(evt -> { tomarFoto(); });
        tblClientes.setOnMouseClicked(evt->{try {
            agarraPersona(tblClientes.getSelectionModel().selectedItemProperty().getValue());
            } catch (Exception ex) {
                Logger.getLogger(panel_clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
});
        consultarWebCams();
    }
    
    public AnchorPane getPanelRoot()
    {
        return pnlRoot;
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
            webcamfx = new WebCamAdapterFX(imgvCamaraWeb);
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
        
        if(imgvFoto.getImage() != null)
            p.setFotografia(WebCamAdapterFX.encodeImageURLSafe(SwingFXUtils.fromFXImage(imgvFoto.getImage(), null)));
        else
            p.setFotografia("");
        
        if (!txtIdPersona.getText().trim().isEmpty()){ 
            p.setId(Integer.valueOf(txtIdPersona.getText())); 
        }
            c.setActivo((chbActivo.isSelected()?1:0));
            c.setEmail(txtEmail.getText());
            c.setPersona(p);
            c.setTelefono(txtTelefono.getText());
            
        if(!txtIdCliente.getText().trim().isEmpty()){
            c.setId(Integer.valueOf(txtIdCliente.getText()));
        }
        
        if(c.getId() > 0 && c.getPersona().getId() > 0){
            cc.update(c);
        }
        else{
            cc.insert(c);             
        }
        
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
       txtIdCliente.setText(String.valueOf(c.getId()));
       txtIdPersona.setText(String.valueOf(c.getPersona().getId()));
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
       imgvFoto.setImage(SwingFXUtils.toFXImage(WebCamAdapterFX.decodeImageURLSafe(c.getPersona().getFotografia()),null));
       
       //imgvFoto.setImage(value);
   }
    
    private void vaciarTextos()
    {
        txtNombre.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        txtIdCliente.setText("");
        txtIdPersona.setText("");
        txtRfc.setText("");
        txtCurp.setText("");
        txtDomicilio.setText("");
        txtCodigoPostal.setText("");
        txtFiltro.setText("");
        txtEmail.setText("");
        txtTelefono.setText("");
        dpkFechaNacimiento.setValue(null);
        cmbGenero.setValue(null);
        chbActivo.setSelected(false);
    }
}   

