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
import org.jwonkafx.model.DetalleVenta;

/**
 *
 * @author Carlos Aviña
 */
public class TableAdapterDetalleVenta {
    public static void adapt(TableView<DetalleVenta> tbl)
    {
        TableColumn<DetalleVenta, String> tcProducto;
        TableColumn<DetalleVenta, String> tcDescripcion;
        TableColumn<DetalleVenta, Float> tcPrecio;
        TableColumn<DetalleVenta, Integer> tcCantidad;
        TableColumn<DetalleVenta, Float> tcPrecioTotal;
        TableColumn<DetalleVenta, String> tcFotografia;
        TableColumn<DetalleVenta, String> tcMarca;
        
        tcProducto = new TableColumn("Producto");
        tcDescripcion = new TableColumn("Descripción");
        tcPrecio = new TableColumn("Precio");
        tcCantidad = new TableColumn("Cantidad");
        tcPrecioTotal = new TableColumn("Total");
        tcFotografia = new TableColumn("Fotografia");
        tcMarca = new TableColumn("Marca");
        
        tcProducto.setCellFactory(new Callback<TableColumn<DetalleVenta, String>, TableCell<DetalleVenta, String>>()
        {
            @Override
            public TableCell<DetalleVenta, String> call(TableColumn<DetalleVenta, String>param)
            {
                return new TableCell<DetalleVenta, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getProducto().getNombre());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcDescripcion.setCellFactory(new Callback<TableColumn<DetalleVenta, String>, TableCell<DetalleVenta, String>>()
        {
            @Override
            public TableCell<DetalleVenta, String> call(TableColumn<DetalleVenta, String>param)
            {
                return new TableCell<DetalleVenta, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getProducto().getDescripcion());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcPrecio.setCellFactory(new Callback<TableColumn<DetalleVenta, Float>, TableCell<DetalleVenta, Float>>()
        {
            @Override
            public TableCell<DetalleVenta, Float> call(TableColumn<DetalleVenta, Float>param)
            {
                return new TableCell<DetalleVenta, Float>()
                {
                    @Override
                    protected void updateItem(Float item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getProducto().getPrecio());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcCantidad.setCellFactory(new Callback<TableColumn<DetalleVenta, Integer>, TableCell<DetalleVenta, Integer>>()
        {
            @Override
            public TableCell<DetalleVenta, Integer> call(TableColumn<DetalleVenta, Integer>param)
            {
                return new TableCell<DetalleVenta, Integer>()
                {
                    @Override
                    protected void updateItem(Integer item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getCantidadProducto());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcPrecioTotal.setCellFactory(new Callback<TableColumn<DetalleVenta, Float>, TableCell<DetalleVenta, Float>>()
        {
            @Override
            public TableCell<DetalleVenta, Float> call(TableColumn<DetalleVenta, Float>param)
            {
                return new TableCell<DetalleVenta, Float>()
                {
                    @Override
                    protected void updateItem(Float item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getPrecio());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcFotografia.setCellFactory(new Callback<TableColumn<DetalleVenta, String>, TableCell<DetalleVenta, String>>()
        {
            @Override
            public TableCell<DetalleVenta, String> call(TableColumn<DetalleVenta, String>param)
            {
                return new TableCell<DetalleVenta, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getProducto().getFotografia());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcMarca.setCellFactory(new Callback<TableColumn<DetalleVenta, String>, TableCell<DetalleVenta, String>>()
        {
            @Override
            public TableCell<DetalleVenta, String> call(TableColumn<DetalleVenta, String>param)
            {
                return new TableCell<DetalleVenta, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getProducto().getMarca().getNombre());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tbl.getColumns().clear();
        tbl.getColumns().addAll(tcProducto,tcDescripcion,tcPrecio,tcCantidad,tcPrecioTotal
                ,tcFotografia,tcMarca);
    }
}
