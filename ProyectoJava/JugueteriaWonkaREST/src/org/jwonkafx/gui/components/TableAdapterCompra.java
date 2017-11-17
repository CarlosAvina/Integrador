/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jwonkafx.gui.components;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import org.jwonkafx.model.Compra;


/**
 *
 * @author Checo
 */
public class TableAdapterCompra {
    public static void adapt(TableView<Compra> tbl)
    {
        TableColumn<Compra, Integer> tcIdCompra;
        TableColumn<Compra, String> tcFecha;
        TableColumn<Compra, Float> tcTotal;
        
        tcIdCompra = new TableColumn("Clave Bitacora");
        tcFecha = new TableColumn("Fecha");
        tcTotal = new TableColumn("Total");
        
        tcIdCompra.setCellFactory(new Callback<TableColumn<Compra, Integer>, TableCell<Compra, Integer>>(){
            @Override
            public TableCell<Compra, Integer> call(TableColumn<Compra, Integer> param){
                return new TableCell<Compra, Integer>(){
                    @Override
                    protected void updateItem(Integer item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex()>=0 && getIndex()<tbl.getItems().size()){
                            textProperty().set(""+ tbl.getItems().get(getIndex()).getIdCompra());
                            
                        }else
                            setText(null);
                    }
                };
          }
        });
        
        tcFecha.setCellFactory(new Callback<TableColumn<Compra, String>, TableCell<Compra, String>>(){
            @Override
            public TableCell<Compra, String> call(TableColumn<Compra, String> param){
                return new TableCell<Compra, String>(){
                    @Override
                    protected void updateItem(String item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex()>=0 && getIndex()<tbl.getItems().size()){
                            textProperty().set(""+ tbl.getItems().get(getIndex()).getFechaAbastecimiento());
                            
                        }else
                            setText(null);
                    }
                };
          }
        });
        
        tcTotal.setCellFactory(new Callback<TableColumn<Compra, Float>, TableCell<Compra, Float>>(){
            @Override
            public TableCell<Compra, Float> call(TableColumn<Compra, Float> param){
                return new TableCell<Compra, Float>(){
                    @Override
                    protected void updateItem(Float item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex()>=0 && getIndex()<tbl.getItems().size()){
                            textProperty().set(""+ tbl.getItems().get(getIndex()).getTotal());
                            
                        }else
                            setText(null);
                    }
                };
          }
        });

         tbl.getColumns().clear();
         tbl.getColumns().addAll(tcIdCompra, tcFecha, tcTotal); 
    }    
}
