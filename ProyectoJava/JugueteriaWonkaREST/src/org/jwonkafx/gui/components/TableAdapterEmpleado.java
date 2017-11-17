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
import org.jwonkafx.model.Empleado;

/**
 *
 * @author karla
 */
public class TableAdapterEmpleado {
    public static void adapt(TableView<Empleado> tbl)
   {
       
        TableColumn<Empleado,Integer> tcIdUsuario = new TableColumn("Cve. Usuario");
        TableColumn<Empleado,Integer> tcIdEmpleado = new TableColumn("Cve. Empleado");
        TableColumn<Empleado,Integer> tcIdPersona = new TableColumn("Cve. Persona");
        TableColumn<Empleado,String> tcNombre = new TableColumn("Nombre");
        TableColumn<Empleado,String> tcPaterno = new TableColumn("Apellido Paterno");
        TableColumn<Empleado,String> tcMaterno = new TableColumn("Apellido Materno");
        TableColumn<Empleado,String> tcGenero = new TableColumn("Genero");
        TableColumn<Empleado,String> tcRfc = new TableColumn("RFC");
        TableColumn<Empleado,String> tcCurp = new TableColumn("CURP");
        TableColumn<Empleado,String> tcFechaNacimiento = new TableColumn("Fecha de Nacimiento");
        TableColumn<Empleado,String> tcCp = new TableColumn("Codigo Postal");
        TableColumn<Empleado,String> tcDomicilio = new TableColumn("Domicilio");
        TableColumn<Empleado,Integer> tcActivoEm = new TableColumn("Empleado Activo");
        
        TableColumn<Empleado,Float> tcSalario = new TableColumn("Salario");
        TableColumn<Empleado,String> tcCodigo = new TableColumn("Codigo");
        TableColumn<Empleado,String> tcFechaIngreso = new TableColumn("Fecha de Ingreso");
    
        TableColumn<Empleado,String> tcUsername = new TableColumn("Username");
        TableColumn<Empleado,String> tcPassword = new TableColumn("Password");
        TableColumn<Empleado,Integer> tcActivoUs = new TableColumn("Usuario Activo");
        
        
        TableColumn<Empleado,Integer> tcIdRol = new TableColumn("IdRol");
        TableColumn<Empleado,String> tcDescripcion = new TableColumn("Descripcion");
    
        tcIdEmpleado.setCellFactory(new Callback<TableColumn<Empleado, Integer>, TableCell<Empleado, Integer>>() 
        {
            @Override
            public TableCell<Empleado, Integer> call(TableColumn<Empleado, Integer> param) 
            {          
                return new TableCell<Empleado, Integer>()
                {
                    @Override
                    protected void updateItem(Integer item, boolean empty)
                    {
                        super.updateItem(item, empty);
                        if (getIndex() >= 0 && getIndex() < tbl.getItems().size())
                        {
                            textProperty().set("" +tbl.getItems().get(getIndex()).getId());
                        }
                        else
                        {
                            setText(null);
                        }
                    }
                };
            }
        });
       tcIdPersona.setCellFactory(new Callback<TableColumn<Empleado, Integer>, TableCell<Empleado, Integer>>() 
        {
            @Override
            public TableCell<Empleado, Integer> call(TableColumn<Empleado, Integer> param) 
            {          
                return new TableCell<Empleado, Integer>()
                {
                    @Override
                    protected void updateItem(Integer item, boolean empty)
                    {
                        super.updateItem(item, empty);
                        if (getIndex() >= 0 && getIndex() < tbl.getItems().size())
                        {
                            textProperty().set("" +tbl.getItems().get(getIndex()).getPersona().getId());
                        }
                        else
                        {
                            setText(null);
                        }
                    }
                };
            }
        });

        tcNombre.setCellFactory(new Callback<TableColumn<Empleado, String>, TableCell<Empleado, String>>() 
        {
            @Override
            public TableCell<Empleado, String> call(TableColumn<Empleado, String> param) 
            {          
                return new TableCell<Empleado, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item, empty);
                        if (getIndex() >= 0 && getIndex() < tbl.getItems().size())
                        {
                            textProperty().set("" +tbl.getItems().get(getIndex()).getPersona().getNombre());
                        }
                        else
                        {
                            setText(null);
                        }
                    }
                };
            }
        });
        
        tcPaterno.setCellFactory(new Callback<TableColumn<Empleado, String>, TableCell<Empleado, String>>() 
        {
            @Override
            public TableCell<Empleado, String> call(TableColumn<Empleado, String> param) 
            {          
                return new TableCell<Empleado, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item, empty);
                        if (getIndex() >= 0 && getIndex() < tbl.getItems().size())
                        {
                            textProperty().set("" +tbl.getItems().get(getIndex()).getPersona().getApellidoPaterno());
                        }
                        else
                        {
                            setText(null);
                        }
                    }
                };
            }
        });

        tcMaterno.setCellFactory(new Callback<TableColumn<Empleado, String>, TableCell<Empleado, String>>() 
        {
            @Override
            public TableCell<Empleado, String> call(TableColumn<Empleado, String> param) 
            {          
                return new TableCell<Empleado, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item, empty);
                        if (getIndex() >= 0 && getIndex() < tbl.getItems().size())
                        {
                            textProperty().set("" +tbl.getItems().get(getIndex()).getPersona().getApellidoMaterno());
                        }
                        else
                        {
                            setText(null);
                        }
                    }
                };
            }
        });

        tcGenero.setCellFactory(new Callback<TableColumn<Empleado, String>, TableCell<Empleado, String>>() 
        {
            @Override
            public TableCell<Empleado, String> call(TableColumn<Empleado, String> param) 
            {          
                return new TableCell<Empleado, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item, empty);
                        if (getIndex() >= 0 && getIndex() < tbl.getItems().size())
                        {
                            textProperty().set("" +tbl.getItems().get(getIndex()).getPersona().getGenero());
                        }
                        else
                        {
                            setText(null);
                        }
                    }
                };
            }
        });
        
        tcRfc.setCellFactory(new Callback<TableColumn<Empleado, String>, TableCell<Empleado, String>>() 
        {
            @Override
            public TableCell<Empleado, String> call(TableColumn<Empleado, String> param) 
            {          
                return new TableCell<Empleado, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item, empty);
                        if (getIndex() >= 0 && getIndex() < tbl.getItems().size())
                        {
                            textProperty().set("" +tbl.getItems().get(getIndex()).getPersona().getRfc());
                        }
                        else
                        {
                            setText(null);
                        }
                    }
                };
            }
        });

        tcCurp.setCellFactory(new Callback<TableColumn<Empleado, String>, TableCell<Empleado, String>>() 
        {
            @Override
            public TableCell<Empleado, String> call(TableColumn<Empleado, String> param) 
            {          
                return new TableCell<Empleado, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item, empty);
                        if (getIndex() >= 0 && getIndex() < tbl.getItems().size())
                        {
                            textProperty().set("" +tbl.getItems().get(getIndex()).getPersona().getCurp());
                        }
                        else
                        {
                            setText(null);
                        }
                    }
                };
            }
        });

        tcFechaNacimiento.setCellFactory(new Callback<TableColumn<Empleado, String>, TableCell<Empleado, String>>() 
        {
            @Override
            public TableCell<Empleado, String> call(TableColumn<Empleado, String> param) 
            {          
                return new TableCell<Empleado, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item, empty);
                        if (getIndex() >= 0 && getIndex() < tbl.getItems().size())
                        {
                            textProperty().set("" +tbl.getItems().get(getIndex()).getPersona().getFechaNacimiento());
                        }
                        else
                        {
                            setText(null);
                        }
                    }
                };
            }
        });

        tcCp.setCellFactory(new Callback<TableColumn<Empleado, String>, TableCell<Empleado, String>>() 
        {
            @Override
            public TableCell<Empleado, String> call(TableColumn<Empleado, String> param) 
            {          
                return new TableCell<Empleado, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item, empty);
                        if (getIndex() >= 0 && getIndex() < tbl.getItems().size())
                        {
                            textProperty().set("" +tbl.getItems().get(getIndex()).getPersona().getCp());
                        }
                        else
                        {
                            setText(null);
                        }
                    }
                };
            }
        });

        tcDomicilio.setCellFactory(new Callback<TableColumn<Empleado, String>, TableCell<Empleado, String>>() 
        {
            @Override
            public TableCell<Empleado, String> call(TableColumn<Empleado, String> param) 
            {          
                return new TableCell<Empleado, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item, empty);
                        if (getIndex() >= 0 && getIndex() < tbl.getItems().size())
                        {
                            textProperty().set("" +tbl.getItems().get(getIndex()).getPersona().getDomicilio());
                        }
                        else
                        {
                            setText(null);
                        }
                    }
                };
            }
        });        

        

        tcActivoEm.setCellFactory(new Callback<TableColumn<Empleado, Integer>, TableCell<Empleado, Integer>>() 
        {
            @Override
            public TableCell<Empleado, Integer> call(TableColumn<Empleado, Integer> param) 
            {          
                return new TableCell<Empleado, Integer>()
                {
                    @Override
                    protected void updateItem(Integer item, boolean empty)
                    {
                        super.updateItem(item, empty);
                        if (getIndex() >= 0 && getIndex() < tbl.getItems().size())
                        {
                            textProperty().set("" +tbl.getItems().get(getIndex()).getActivo());
                        }
                        else
                        {
                            setText(null);
                        }
                    }
                };
            }
        });
        tcActivoUs.setCellFactory(new Callback<TableColumn<Empleado, Integer>, TableCell<Empleado, Integer>>() 
        {
            @Override
            public TableCell<Empleado, Integer> call(TableColumn<Empleado, Integer> param) 
            {          
                return new TableCell<Empleado, Integer>()
                {
                    @Override
                    protected void updateItem(Integer item, boolean empty)
                    {
                        super.updateItem(item, empty);
                        if (getIndex() >= 0 && getIndex() < tbl.getItems().size())
                        {
                            textProperty().set("" +tbl.getItems().get(getIndex()).getUsuario().getActivo());
                        }
                        else
                        {
                            setText(null);
                        }
                    }
                };
            }
        });
        
tcIdRol.setCellFactory(new Callback<TableColumn<Empleado, Integer>, TableCell<Empleado, Integer>>() 
        {
            @Override
            public TableCell<Empleado, Integer> call(TableColumn<Empleado, Integer> param) 
            {          
                return new TableCell<Empleado, Integer>()
                {
                    @Override
                    protected void updateItem(Integer item, boolean empty)
                    {
                        super.updateItem(item, empty);
                        if (getIndex() >= 0 && getIndex() < tbl.getItems().size())
                        {
                            textProperty().set("" +tbl.getItems().get(getIndex()).getUsuario().getRol().getId());
                        }
                        else
                        {
                            setText(null);
                        }
                    }
                };
            }
        });   
tcSalario.setCellFactory(new Callback<TableColumn<Empleado, Float>, TableCell<Empleado, Float>>() 
        {
            @Override
            public TableCell<Empleado, Float> call(TableColumn<Empleado, Float> param) 
            {          
                return new TableCell<Empleado, Float>()
                {
                    @Override
                    protected void updateItem(Float item, boolean empty)
                    {
                        super.updateItem(item, empty);
                        if (getIndex() >= 0 && getIndex() < tbl.getItems().size())
                        {
                            textProperty().set("" +tbl.getItems().get(getIndex()).getSalario());
                        }
                        else
                        {
                            setText(null);
                        }
                    }
                };
            }
        });
 tcCodigo.setCellFactory(new Callback<TableColumn<Empleado, String>, TableCell<Empleado, String>>() 
        {
            @Override
            public TableCell<Empleado, String> call(TableColumn<Empleado, String> param) 
            {          
                return new TableCell<Empleado, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item, empty);
                        if (getIndex() >= 0 && getIndex() < tbl.getItems().size())
                        {
                            textProperty().set("" +tbl.getItems().get(getIndex()).getCodigo());
                        }
                        else
                        {
                            setText(null);
                        }
                    }
                };
            }
        });
 tcFechaIngreso.setCellFactory(new Callback<TableColumn<Empleado, String>, TableCell<Empleado, String>>() 
        {
            @Override
            public TableCell<Empleado, String> call(TableColumn<Empleado, String> param) 
            {          
                return new TableCell<Empleado, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item, empty);
                        if (getIndex() >= 0 && getIndex() < tbl.getItems().size())
                        {
                            textProperty().set("" +tbl.getItems().get(getIndex()).getFechaIngreso());
                        }
                        else
                        {
                            setText(null);
                        }
                    }
                };
            }
        });
 tcUsername.setCellFactory(new Callback<TableColumn<Empleado, String>, TableCell<Empleado, String>>() 
        {
            @Override
            public TableCell<Empleado, String> call(TableColumn<Empleado, String> param) 
            {          
                return new TableCell<Empleado, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item, empty);
                        if (getIndex() >= 0 && getIndex() < tbl.getItems().size())
                        {
                            textProperty().set("" +tbl.getItems().get(getIndex()).getUsuario().getUsername());
                        }
                        else
                        {
                            setText(null);
                        }
                    }
                };
            }
        });
 tcPassword.setCellFactory(new Callback<TableColumn<Empleado, String>, TableCell<Empleado, String>>() 
        {
            @Override
            public TableCell<Empleado, String> call(TableColumn<Empleado, String> param) 
            {          
                return new TableCell<Empleado, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item, empty);
                        if (getIndex() >= 0 && getIndex() < tbl.getItems().size())
                        {
                            textProperty().set("" +tbl.getItems().get(getIndex()).getUsuario().getPassword());
                        }
                        else
                        {
                            setText(null);
                        }
                    }
                };
            }
        });
 tcDescripcion.setCellFactory(new Callback<TableColumn<Empleado, String>, TableCell<Empleado, String>>() 
        {
            @Override
            public TableCell<Empleado, String> call(TableColumn<Empleado, String> param) 
            {          
                return new TableCell<Empleado, String>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty)
                    {
                        super.updateItem(item, empty);
                        if (getIndex() >= 0 && getIndex() < tbl.getItems().size())
                        {
                            textProperty().set("" +tbl.getItems().get(getIndex()).getUsuario().getRol().getRol());
                        }
                        else
                        {
                            setText(null);
                        }
                    }
                };
            }
        });

        tbl.getColumns().clear();
        tbl.getColumns().addAll(tcIdEmpleado,tcIdPersona,tcNombre,tcPaterno,tcMaterno,tcCurp,
                tcRfc,tcCp,tcFechaNacimiento,tcDomicilio,tcSalario,tcActivoEm);
   
}

}
