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
import org.jwonkafx.model.Venta;

/**
 *
 * @author Carlos Aviña
 */
public class TableAdapterVenta {
    public static void adapt(TableView<Venta> tbl){
        TableColumn<Venta, Integer> tcIdVenta;
        TableColumn<Venta, String> tcFecha;
        TableColumn<Venta, Integer> tcIdEmpleado;
        TableColumn<Venta, String> tcNombreEmpleado;
        TableColumn<Venta, Integer> tcIdCliente;
        TableColumn<Venta, String> tcNombreCliente;
        TableColumn<Venta, Float> tcTotal;
        TableColumn<Venta, String> tcFormaPago;
        
        tcIdVenta = new TableColumn("Cve. Venta");
        tcFecha = new TableColumn("Fecha");
        tcIdEmpleado = new TableColumn("Id Empleado");
        tcNombreEmpleado = new TableColumn("Empleado");
        tcIdCliente = new TableColumn("Id Cliente");
        tcNombreCliente = new TableColumn("Cliente");
        tcTotal = new TableColumn("Total");
        tcFormaPago = new TableColumn("Forma de pago");
        
        tcIdVenta.setCellFactory(new Callback<TableColumn<Venta, Integer>, TableCell<Venta, Integer>>()
        {
            @Override
            public TableCell<Venta, Integer> call(TableColumn<Venta, Integer>param)
            {
                return new TableCell<Venta, Integer>()
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
        
        tcFecha.setCellFactory(new Callback<TableColumn<Venta, String>, TableCell<Venta, String>>()
        {
            @Override
            public TableCell<Venta, String> call(TableColumn<Venta, String>param)
            {
                return new TableCell<Venta, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getFecha());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcIdEmpleado.setCellFactory(new Callback<TableColumn<Venta, Integer>, TableCell<Venta, Integer>>()
        {
            @Override
            public TableCell<Venta, Integer> call(TableColumn<Venta, Integer>param)
            {
                return new TableCell<Venta, Integer>()
                {
                    @Override
                    protected void updateItem(Integer item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getEmpleado().getPersona().getId());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcNombreEmpleado.setCellFactory(new Callback<TableColumn<Venta, String>, TableCell<Venta, String>>()
        {
            @Override
            public TableCell<Venta, String> call(TableColumn<Venta, String>param)
            {
                return new TableCell<Venta, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getEmpleado().getPersona().getNombre());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcIdCliente.setCellFactory(new Callback<TableColumn<Venta, Integer>, TableCell<Venta, Integer>>()
        {
            @Override
            public TableCell<Venta, Integer> call(TableColumn<Venta, Integer>param)
            {
                return new TableCell<Venta, Integer>()
                {
                    @Override
                    protected void updateItem(Integer item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getCliente().getPersona().getId());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcNombreCliente.setCellFactory(new Callback<TableColumn<Venta, String>, TableCell<Venta, String>>()
        {
            @Override
            public TableCell<Venta, String> call(TableColumn<Venta, String>param)
            {
                return new TableCell<Venta, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getCliente().getPersona().getNombre());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcTotal.setCellFactory(new Callback<TableColumn<Venta, Float>, TableCell<Venta, Float>>()
        {
            @Override
            public TableCell<Venta, Float> call(TableColumn<Venta, Float>param)
            {
                return new TableCell<Venta, Float>()
                {
                    @Override
                    protected void updateItem(Float item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getTotal());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcFormaPago.setCellFactory(new Callback<TableColumn<Venta, String>, TableCell<Venta, String>>()
        {
            @Override
            public TableCell<Venta, String> call(TableColumn<Venta, String>param)
            {
                return new TableCell<Venta, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getFormaPago().getDescripcion());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tbl.getColumns().clear();
        tbl.getColumns().addAll(tcIdVenta, tcFecha,tcIdEmpleado,tcNombreEmpleado,tcIdCliente,tcNombreCliente,tcTotal,tcFormaPago);
    }
}
