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
import org.jwonkafx.model.Cliente;

/**
 *
 * @author franc
 */
public class TableAdapterCliente 
{
    public static void adapt(TableView<Cliente> tbl)
    {
        TableColumn<Cliente, Integer> tcIdCliente;
        TableColumn<Cliente, Integer> tcIdPersona;
        TableColumn<Cliente, String> tcNombre;
        TableColumn<Cliente, String> tcApellidoPaterno;
        TableColumn<Cliente, String> tcApellidoMaterno;
        TableColumn<Cliente, String> tcGenero;
        TableColumn<Cliente, String> tcRfc;
        TableColumn<Cliente, String> tcCurp;
        TableColumn<Cliente, String> tcFechaNacimiento;
        TableColumn<Cliente, String> tcCp;
        TableColumn<Cliente, String> tcFotografia;
        TableColumn<Cliente, String> tcDomicilio;
        TableColumn<Cliente, String> tcEmail;
        TableColumn<Cliente, String> tcTelefono;
        TableColumn<Cliente, Integer> tcActivo;
        
        tcIdCliente = new TableColumn("Cve. Cliente");
        tcIdPersona = new TableColumn("Cve. Persona");
        tcNombre = new TableColumn("Nombre");
        tcApellidoPaterno = new TableColumn("Apellido Paterno");
        tcApellidoMaterno = new TableColumn("Apellido Materno");
        tcGenero = new TableColumn("Género");
        tcRfc = new TableColumn("RFC");
        tcCurp = new TableColumn("CURP");
        tcFechaNacimiento = new TableColumn("Fecha de Nacimiento");
        tcCp = new TableColumn("Código Postal");
        tcDomicilio = new TableColumn("Domicilio");
        tcFotografia = new TableColumn("Fotografía");
        tcEmail = new TableColumn("Email");
        tcTelefono = new TableColumn("Teléfono");
        tcActivo = new TableColumn("Activo");
        
        tcIdCliente.setCellFactory(new Callback<TableColumn<Cliente, Integer>, TableCell<Cliente, Integer>>()
        {
            @Override
            public TableCell<Cliente, Integer> call(TableColumn<Cliente, Integer>param)
            {
                return new TableCell<Cliente, Integer>()
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
        
        tcIdPersona.setCellFactory(new Callback<TableColumn<Cliente, Integer>, TableCell<Cliente, Integer>>()
        {
            @Override
            public TableCell<Cliente, Integer> call(TableColumn<Cliente, Integer>param)
            {
                return new TableCell<Cliente, Integer>()
                {
                    @Override
                    protected void updateItem(Integer item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getPersona().getId());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcNombre.setCellFactory(new Callback<TableColumn<Cliente, String>, TableCell<Cliente, String>>()
        {
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, String>param)
            {
                return new TableCell<Cliente, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getPersona().getNombre());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcApellidoPaterno.setCellFactory(new Callback<TableColumn<Cliente, String>, TableCell<Cliente, String>>()
        {
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, String>param)
            {
                return new TableCell<Cliente, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getPersona().getApellidoPaterno());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcApellidoMaterno.setCellFactory(new Callback<TableColumn<Cliente, String>, TableCell<Cliente, String>>()
        {
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, String>param)
            {
                return new TableCell<Cliente, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getPersona().getApellidoMaterno());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcGenero.setCellFactory(new Callback<TableColumn<Cliente, String>, TableCell<Cliente, String>>()
        {
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, String>param)
            {
                return new TableCell<Cliente, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getPersona().getGenero());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcRfc.setCellFactory(new Callback<TableColumn<Cliente, String>, TableCell<Cliente, String>>()
        {
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, String>param)
            {
                return new TableCell<Cliente, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getPersona().getRfc());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcCurp.setCellFactory(new Callback<TableColumn<Cliente, String>, TableCell<Cliente, String>>()
        {
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, String>param)
            {
                return new TableCell<Cliente, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getPersona().getCurp());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcFechaNacimiento.setCellFactory(new Callback<TableColumn<Cliente, String>, TableCell<Cliente, String>>()
        {
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, String>param)
            {
                return new TableCell<Cliente, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getPersona().getFechaNacimiento());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        tcCp.setCellFactory(new Callback<TableColumn<Cliente, String>, TableCell<Cliente, String>>()
        {
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, String>param)
            {
                return new TableCell<Cliente, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getPersona().getCp());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcDomicilio.setCellFactory(new Callback<TableColumn<Cliente, String>, TableCell<Cliente, String>>()
        {
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, String>param)
            {
                return new TableCell<Cliente, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getPersona().getDomicilio());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcEmail.setCellFactory(new Callback<TableColumn<Cliente, String>, TableCell<Cliente, String>>()
        {
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, String>param)
            {
                return new TableCell<Cliente, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getEmail());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcFotografia.setCellFactory(new Callback<TableColumn<Cliente, String>, TableCell<Cliente, String>>()
        {
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, String>param)
            {
                return new TableCell<Cliente, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getPersona().getFotografia());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcTelefono.setCellFactory(new Callback<TableColumn<Cliente, String>, TableCell<Cliente, String>>()
        {
            @Override
            public TableCell<Cliente, String> call(TableColumn<Cliente, String>param)
            {
                return new TableCell<Cliente, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item,empty);
                        if(getIndex()>= 0 && getIndex()< tbl.getItems().size())
                        {
                            textProperty().set(""+tbl.getItems().get(getIndex()).getTelefono());
                        }
                        else
                        setText(null);
                    }
                };
            }
        });
        
        tcActivo.setCellFactory(new Callback<TableColumn<Cliente, Integer>, TableCell<Cliente, Integer>>()
        {
            @Override
            public TableCell<Cliente, Integer> call(TableColumn<Cliente, Integer>param)
            {
                return new TableCell<Cliente, Integer>()
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
        tbl.getColumns().addAll(tcIdCliente, tcIdPersona,tcNombre,tcApellidoPaterno,tcApellidoMaterno,tcGenero,tcRfc,tcCurp,tcFechaNacimiento,tcCp
        ,tcDomicilio,tcFotografia,tcEmail,tcTelefono,tcActivo);
    }
}
