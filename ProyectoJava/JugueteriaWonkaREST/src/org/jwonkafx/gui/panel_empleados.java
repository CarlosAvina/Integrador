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
import com.jfoenix.controls.JFXTextField;
import static java.lang.String.valueOf;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalQueries.localDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.grios.jwebcam.WebCamAdapterFX;
import org.jugueteria.gui.components.WebCams;
import org.jwonkafx.core.ControladorEmpleado;
import org.jwonkafx.gui.components.FechasAdaptador;
import org.jwonkafx.gui.components.TableAdapterEmpleado;
import org.jwonkafx.model.Empleado;
import org.jwonkafx.model.Persona;
import org.jwonkafx.model.Rol;
import org.jwonkafx.model.Usuario;

/**
 *
 * @author karla
 */
public class panel_empleados {
    @FXML AnchorPane pnlRoot;
    @FXML JFXTextField txtNombre;
    @FXML JFXTextField txtApellidoPaterno;
    @FXML JFXTextField txtApellidoMaterno;
    @FXML JFXTextField txtRfc;
    @FXML JFXTextField txtCurp;
    @FXML JFXTextField txtDomicilio;
    @FXML JFXTextField txtCodigoPostal;
    @FXML JFXTextField txtSalario;
    @FXML JFXTextField txtCodigoEmpleado;
    @FXML JFXTextField txtUsuario;
    @FXML JFXTextField txtContrasenna;
    @FXML JFXComboBox cmbGenero;
    @FXML JFXComboBox cmbRoles;
    @FXML JFXComboBox cmbCamarasWeb;
    @FXML JFXDatePicker dpkFechaNacimiento;
    @FXML JFXCheckBox chbActivo;
    @FXML JFXButton btnTomarFoto;
    @FXML JFXButton btnCrearNuevo;
    @FXML JFXButton btnGuardar;
    @FXML JFXButton btnEliminar;
    @FXML JFXButton btnConsultar;
    @FXML JFXButton btnIniciarCamaraWeb;
    @FXML JFXButton btnBuscarEmpleado;
    @FXML ImageView imgvFoto;
    @FXML TableView<Empleado> tblEmpleados;
    FXMLLoader fxmll;
    
    ControladorEmpleado ce;
    WebCamAdapterFX webcamfx;
    WebCams wc;
    
    public panel_empleados()
    {
        ce = new ControladorEmpleado();
        webcamfx= new WebCamAdapterFX();
        wc=new WebCams();
    }
    public void inicializar()throws Exception
    {
        fxmll = new FXMLLoader(System.class.getResource("/org/jwonkafx/gui/fxml/panel_empleado.fxml"));
        fxmll.setController(this);
        fxmll.load();
        tblEmpleados.setItems(FXCollections.observableArrayList());
        //FechasAdaptador.adaptar(dpkFechaNacimiento, "dd/MM/yyyy");
        //FechasAdaptador.adaptar(dpkIngreso, "dd/MM/yyyy");
        TableAdapterEmpleado.adapt(tblEmpleados);
        btnConsultar.setOnAction((ActionEvent evt)->
        {
            consultar("");
        });
        this.tblEmpleados.setOnMouseClicked(evt-> {
            Empleado empleado=new Empleado();
            empleado= tblEmpleados.getSelectionModel().selectedItemProperty().getValue();
            llenar(empleado);
        });

//        btnGuardar.setOnAction(evt ->
//        {
//            insertar();
//        });
        
//        btnIniciarCamaraWeb.setOnAction(evt-> {
//            wc.iniciarWebCam(this.imgvCamaraWeb, cmbCamarasWeb.getSelectionModel().getSelectedItem().toString());
//        });
//
//        btnTomarFoto.setOnAction(evt-> {wc.tomarFoto(imgvFoto);});
//        cmbCamarasWeb.setItems(wc.consultarWebCams());
    }
    private void llenar(Empleado empleado){
    try{
        if(empleado.getId()== 0 && empleado.getPersona().getId()==0){
            this.dpkFechaNacimiento.setValue(null);
            this.imgvFoto.setImage(null);
        }
    else
    {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
        LocalDate localDate=LocalDate.parse(empleado.getPersona().getFechaNacimiento(),formato);
        this.dpkFechaNacimiento.setValue(localDate);
        this.imgvFoto.setImage(SwingFXUtils.toFXImage(WebCamAdapterFX.decodeImageURLSafe(empleado.getPersona().getFotografia()), null));
    }
    
    this.txtApellidoPaterno.setText(empleado.getPersona().getApellidoPaterno());
    this.txtApellidoMaterno.setText(empleado.getPersona().getApellidoMaterno());
    this.txtCodigoPostal.setText(empleado.getPersona().getCp());
    this.txtCurp.setText(empleado.getPersona().getCurp());
    this.txtDomicilio.setText(empleado.getPersona().getDomicilio());
    
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
    LocalDate localDate = LocalDate.parse(empleado.getPersona().getFechaNacimiento(),formato);  
    
    this.txtRfc.setText(empleado.getPersona().getRfc());
    this.cmbRoles.setValue(empleado.getUsuario().getRol().getRol());
    this.txtSalario.setText(String.valueOf(empleado.getSalario()));
    this.cmbGenero.getSelectionModel().select(empleado.getPersona().getGenero());
    this.txtNombre.setText(empleado.getPersona().getNombre());
    this.txtUsuario.setText(empleado.getUsuario().getUsername());
    this.txtContrasenna.setText(empleado.getUsuario().getPassword());
    }catch(Exception e){
        e.printStackTrace();
    }
   
}
    
    public AnchorPane getPanelRoot()
    {
        return pnlRoot;
    }
    private void insertar()
    {
        Empleado e = new Empleado();
        Persona p= new Persona();
        Rol rol = new Rol();
        Usuario u = new Usuario();
        try{
            e.setActivo(1);
            p.setCp(this.txtCodigoPostal.getText());
            p.setCurp(this.txtCurp.getText());
            p.setDomicilio(this.txtDomicilio.getText());
            p.setFechaNacimiento(this.dpkFechaNacimiento.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
           if(this.imgvFoto.getImage()!=null){
            p.setFotografia(WebCamAdapterFX.encodeImageURLSafe(SwingFXUtils.fromFXImage(imgvFoto.getImage(), null)));
        }
            p.setGenero(this.cmbGenero.getSelectionModel().getSelectedItem().toString());
            p.setApellidoMaterno(this.txtApellidoMaterno.getText());
            p.setNombre(this.txtNombre.getText());
            p.setApellidoPaterno(this.txtApellidoPaterno.getText());
            p.setRfc(this.txtRfc.getText());
            e.setSalario(Float.valueOf(this.txtSalario.getText()));
            e.setCodigo(""+p.getNombre().charAt(0) + p.getApellidoPaterno().charAt(0)+p.getApellidoMaterno().charAt(0)+p.getFechaNacimiento().substring(7)+p.getFechaNacimiento().substring(0,3));
            //this.txtCodigoEmpleado.setText(e.getCodigo());
            
            u.setUsername(this.txtUsuario.getText());
            u.setPassword(this.txtContrasenna.getText());
            rol.setId(((cmbRoles.getSelectionModel().getSelectedIndex())+1));
            
            u.setRol(rol);
            e.setPersona(p);
            e.setUsuario(u);
            
            ce.insert(e);
            vaciarTextos();
            consultar("");
        }catch(Exception ex)
        {
            Alert alert=new Alert(Alert.AlertType.ERROR,"Revise los campos \nERROR:"+ex,ButtonType.OK);
            alert.show();
            ex.printStackTrace();
        }
    }
    private void eliminar ()throws Exception
{
    try
    {
        Empleado em = new Empleado();
        ce.eliminar(em);
        vaciarTextos();
        consultar("");
    }
    catch (Exception ex)
    {
        ex.printStackTrace();
    }
}
    public void consultar(String filtro)
    {
        ObservableList<Empleado> empleados=null;
        try
        {
            empleados=ce.getAll(filtro);
            tblEmpleados.setItems(empleados);
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
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
        dpkFechaNacimiento.setValue(null);
        cmbGenero.setValue(null);
        this.txtUsuario.setText("");
        this.txtContrasenna.setText("");
        this.txtSalario.setText("");
        this.cmbRoles.setValue(null);
        this.imgvFoto.setImage(null);
    }
}
