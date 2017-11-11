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
import org.jwonkafx.model.DetalleCompra;
/**
 *
 * @author Checo
 */
public class TableAdapterCompraDetalle {
    public static void adapt(TableView<DetalleCompra> tbl)
    {
        TableColumn<DetalleCompra, Integer> tcIdProducto;
        TableColumn <DetalleCompra, Float>tcPrecio;
        TableColumn <DetalleCompra, Integer>tcCantidad;
        TableColumn <DetalleCompra, Float>tcTotal;
         TableColumn<DetalleCompra, String> tcNombre;
        
        tcIdProducto= new TableColumn("IdProducto");
        tcNombre = new TableColumn("Producto");
        tcPrecio= new TableColumn("Precio");
        tcCantidad= new TableColumn("Cantidad");
        tcTotal= new TableColumn("Total");
        
        
        tcNombre.setCellFactory(new Callback<TableColumn<DetalleCompra, String>, TableCell<DetalleCompra, String>>(){
            @Override
            public TableCell<DetalleCompra, String> call(TableColumn<DetalleCompra, String> param){
                return new TableCell<DetalleCompra, String>(){
                    @Override
                    protected void updateItem(String item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex()>=0 && getIndex()<tbl.getItems().size()){
                            textProperty().set(""+ tbl.getItems().get(getIndex()).getProducto().getNombre());
                            
                        }else
                            setText(null);
                    }
                };
          }
        });
        
        tcIdProducto.setCellFactory(new Callback<TableColumn<DetalleCompra, Integer>, TableCell<DetalleCompra, Integer>>(){
            @Override
            public TableCell<DetalleCompra, Integer> call(TableColumn<DetalleCompra, Integer> param){
                return new TableCell<DetalleCompra, Integer>(){
                    @Override
                    protected void updateItem(Integer item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex()>=0 && getIndex()<tbl.getItems().size()){
                            textProperty().set(""+ tbl.getItems().get(getIndex()).getProducto().getId());
                            
                        }else
                            setText(null);
                    }
                };
          }
        });
        tcPrecio.setCellFactory(new Callback<TableColumn<DetalleCompra, Float>, TableCell<DetalleCompra, Float>>(){
            @Override
            public TableCell<DetalleCompra, Float> call(TableColumn<DetalleCompra, Float> param){
                return new TableCell<DetalleCompra, Float>(){
                    @Override
                    protected void updateItem(Float item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex()>=0 && getIndex()<tbl.getItems().size()){
                            textProperty().set(""+ tbl.getItems().get(getIndex()).getPrecioCompra());
                            
                        }else
                            setText(null);
                    }
                };
          }
        });
         tcTotal.setCellFactory(new Callback<TableColumn<DetalleCompra, Float>, TableCell<DetalleCompra, Float>>(){
            @Override
            public TableCell<DetalleCompra, Float> call(TableColumn<DetalleCompra, Float> param){
                return new TableCell<DetalleCompra, Float>(){
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
        tcCantidad.setCellFactory(new Callback<TableColumn<DetalleCompra, Integer>, TableCell<DetalleCompra, Integer>>(){
            @Override
            public TableCell<DetalleCompra, Integer> call(TableColumn<DetalleCompra, Integer> param){
                return new TableCell<DetalleCompra, Integer>(){
                    @Override
                    protected void updateItem(Integer item, boolean empty){
                        super.updateItem(item, empty);
                        if(getIndex()>=0 && getIndex()<tbl.getItems().size()){
                            textProperty().set(""+ tbl.getItems().get(getIndex()).getCantidad());
                            
                        }else
                            setText(null);
                    }
                };
          }
        });
        
         tbl.getColumns().clear();
         tbl.getColumns().addAll(tcIdProducto, tcNombre, tcPrecio,tcCantidad, tcTotal); 
    }         
}
