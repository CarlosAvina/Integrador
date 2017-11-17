/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jugueteria.gui.components;

import com.github.sarxos.webcam.Webcam;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;
import org.grios.jwebcam.WebCamAdapter;
import org.grios.jwebcam.WebCamAdapterFX;

/**
 *
 * @author Many
 */
public class WebCams 
{
    WebCamAdapterFX webcamfx;
    public ObservableList<String> consultarWebCams()
    {
        ObservableList<String> lista = FXCollections.observableArrayList();
        Webcam[] cams = WebCamAdapterFX.getSystemCamDevicesAsArray();
        for(Webcam w: cams)
        {
            lista.add(w.getName());
        }
        return lista;
    }
    public void iniciarWebCam(ImageView imgv, String name)
    {
        if(webcamfx==null)
            webcamfx = new WebCamAdapterFX(imgv);
        if(webcamfx.isStarted())
            webcamfx.stop();
       webcamfx.start(name);
    }
    
    public void tomarFoto(ImageView target)
    {
        if(webcamfx!=null && webcamfx.isStarted())
        {
            target.setImage(SwingFXUtils.toFXImage(webcamfx.getBufferedImage(),null));
        }
    }
}
