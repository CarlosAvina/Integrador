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
import org.jwonkafx.model.Producto;

/**
 *
 * @author franc
 */
public class TableAdapterProducto
{
    public static void adapt(TableView<Producto> tbl)
    {
        TableColumn<Producto, Integer> tcIdProducto;
        TableColumn<Producto, String> tcNombre;
        TableColumn<Producto, Integer> tcEdadMinima;
        TableColumn<Producto, Integer> tcEdadMaxima;
        TableColumn<Producto, String> tcDescripcion;
        TableColumn<Producto, Float> tcPrecio;
        TableColumn<Producto, Integer> tcStock;
        TableColumn<Producto, String> tcFotografia;
        TableColumn<Producto, Integer> tcIdMarca;
        TableColumn<Producto, String> tcMarca;
        TableColumn<Producto, Integer> tcActivo;
        
        tcIdProducto = new TableColumn("Cve. Producto");
        tcNombre = new TableColumn("Nombre");
        tcDescripcion = new TableColumn("Descripcion");
        tcPrecio = new TableColumn("Precio");
        tcStock = new TableColumn("Stock");
        tcEdadMinima = new TableColumn("EdadMinima");
        tcEdadMaxima = new TableColumn("EdadMaxima");
        tcFotografia = new TableColumn("Fotografia");
        tcIdMarca = new TableColumn("IdMarca");
        tcMarca = new TableColumn("Marca");
        tcActivo = new TableColumn("Activo");
        
        tcIdProducto.setCellFactory(new Callback<TableColumn<Producto, Integer>, TableCell<Producto, Integer>>()
        {
            @Override
            public TableCell<Producto, Integer> call(TableColumn<Producto, Integer>param)
            {
                return new TableCell<Producto, Integer>()
                {
                    @Override
                    protected void updateItem(Integer item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getId());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcNombre.setCellFactory(new Callback<TableColumn<Producto, String>, TableCell<Producto, String>>()
        {
            @Override
            public TableCell<Producto, String> call(TableColumn<Producto, String>param)
            {
                return new TableCell<Producto, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getNombre());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcDescripcion.setCellFactory(new Callback<TableColumn<Producto, String>, TableCell<Producto, String>>()
        {
            @Override
            public TableCell<Producto, String> call(TableColumn<Producto, String>param)
            {
                return new TableCell<Producto, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getDescripcion());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcPrecio.setCellFactory(new Callback<TableColumn<Producto, Float>, TableCell<Producto, Float>>()
        {
            @Override
            public TableCell<Producto, Float> call(TableColumn<Producto, Float>param)
            {
                return new TableCell<Producto, Float>()
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
        
        tcStock.setCellFactory(new Callback<TableColumn<Producto, Integer>, TableCell<Producto, Integer>>()
        {
            @Override
            public TableCell<Producto, Integer> call(TableColumn<Producto, Integer>param)
            {
                return new TableCell<Producto, Integer>()
                {
                    @Override
                    protected void updateItem(Integer item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getStock());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcEdadMinima.setCellFactory(new Callback<TableColumn<Producto, Integer>, TableCell<Producto, Integer>>()
        {
            @Override
            public TableCell<Producto, Integer> call(TableColumn<Producto, Integer>param)
            {
                return new TableCell<Producto, Integer>()
                {
                    @Override
                    protected void updateItem(Integer item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getEdadMinima());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcEdadMaxima.setCellFactory(new Callback<TableColumn<Producto, Integer>, TableCell<Producto, Integer>>()
        {
            @Override
            public TableCell<Producto, Integer> call(TableColumn<Producto, Integer>param)
            {
                return new TableCell<Producto, Integer>()
                {
                    @Override
                    protected void updateItem(Integer item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getEdadMaxima());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcFotografia.setCellFactory(new Callback<TableColumn<Producto, String>, TableCell<Producto, String>>()
        {
            @Override
            public TableCell<Producto, String> call(TableColumn<Producto, String>param)
            {
                return new TableCell<Producto, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getFotografia());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
       
        tcIdMarca.setCellFactory(new Callback<TableColumn<Producto, Integer>, TableCell<Producto, Integer>>()
        {
            @Override
            public TableCell<Producto, Integer> call(TableColumn<Producto, Integer>param)
            {
                return new TableCell<Producto, Integer>()
                {
                    @Override
                    protected void updateItem(Integer item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getMarca().getId());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcMarca.setCellFactory(new Callback<TableColumn<Producto, String>, TableCell<Producto, String>>()
        {
            @Override
            public TableCell<Producto, String> call(TableColumn<Producto, String>param)
            {
                return new TableCell<Producto, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getMarca().getNombre());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcActivo.setCellFactory(new Callback<TableColumn<Producto, Integer>, TableCell<Producto, Integer>>()
        {
            @Override
            public TableCell<Producto, Integer> call(TableColumn<Producto, Integer>param)
            {
                return new TableCell<Producto, Integer>()
                {
                    @Override
                    protected void updateItem(Integer item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getActivo());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tbl.getColumns().clear();
        tbl.getColumns().addAll(tcIdProducto,tcNombre,tcDescripcion ,tcPrecio,tcStock,tcEdadMinima,tcEdadMaxima,tcIdMarca,tcMarca,tcActivo);
    }
}

