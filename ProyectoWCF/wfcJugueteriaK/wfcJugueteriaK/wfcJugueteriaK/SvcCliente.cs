using RNConnection.DataAbstractionLayer;
using RNConnection.DataStorageLayer;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Linq;
using System.ServiceModel;
using System.ServiceModel.Activation;
using System.ServiceModel.Channels;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace wfcJugueteriaK
{


    public class ImplementacionJS : ISvcCliente
    {
        //    public verificador Login(Usuario Usuario)
        //    {
        //        verificador respuesta = null;
        //        respuesta.Sesion = null;
        //        DSL conexion = new DSL();
        //        long id = 0;
        //        try
        //        {
        //            conexion.Open("Data Source = DESKTOP-3N20GVT;" + "Initial Catalog =DBUsuario_practica1.1.3;" + "User id=sa;Password=sa", RNConnection.DataAbstractionLayer.Proveedor.SQLServer);
        //            conexion.InitialSQLStatement("dbo.pa_sel_AutenticarUsuario", System.Data.CommandType.StoredProcedure);
        //            conexion.SetParameterProcedure("@Nick", System.Data.ParameterDirection.Input, eTypes.Cadena, Usuario.Username);
        //            conexion.SetParameterProcedure("@Password", System.Data.ParameterDirection.Input, eTypes.Cadena, Usuario.Password);
        //            conexion.SetParameterProcedure("@Ipcliente", System.Data.ParameterDirection.Input, eTypes.Cadena, IpCliente());
        //            DataTable dt = conexion.ReturnTable();
        //            XDocument _xdoc = (XDocument)(dt.Rows[0]["Respuesta"]); 
        //            respuesta.Sesion.Token = _xdoc.Element("sesi_token").ToString();
        //            if (_xdoc.Element("Valido").Value.Equals("1"))
        //            {
        //                string estado = _xdoc.Element("sesi_status").ToString();
        //                respuesta.Sesion.Estado = EstadoSesion.Valido;
        //            }
        //            else
        //                respuesta.Sesion.Estado = EstadoSesion.NoValido;
        //        }
        //        catch (Exception ex)
        //        {
        //            return new verificador();
        //        }
        //        finally
        //        {
        //            conexion = null;
        //        }

        //        return new verificador();
        //    }

        //    public string IpCliente()
        //    {
        //        OperationContext context = OperationContext.Current;
        //        MessageProperties messprop = context.IncomingMessageProperties;
        //        RemoteEndpointMessageProperty endpointProperty = messprop[RemoteEndpointMessageProperty.Name] as RemoteEndpointMessageProperty;
        //        string x = endpointProperty.Address;
        //        return x;
        //    }

        //    public long RegistrarEmpleado(Empleado empleado)
        //    {
        //        DSL conexion = new DSL();
        //        long id = 0;
        //        try
        //        {
        //            //persona
        //            conexion.Open("Data Source = DESKTOP-3N20GVT;" + "Initial Catalog =JugueteriaWonka;" + "User id=sa;Password=sa", RNConnection.DataAbstractionLayer.Proveedor.SQLServer);
        //            conexion.InitialSQLStatement("dbo.pa_InsertarEmpleado", System.Data.CommandType.StoredProcedure);
        //            conexion.SetParameterProcedure("@Nombre", System.Data.ParameterDirection.Input, eTypes.Cadena, empleado.persona.Name);
        //            conexion.SetParameterProcedure("@ApellidoPaterno", System.Data.ParameterDirection.Input, eTypes.Cadena, empleado.persona.ApellidoPaterno);
        //            conexion.SetParameterProcedure("@ApellidoMaterno", System.Data.ParameterDirection.Input, eTypes.Cadena, empleado.persona.ApellidoMaterno);
        //            conexion.SetParameterProcedure("@Curp", System.Data.ParameterDirection.Input, eTypes.Cadena, empleado.persona.Curp);
        //            conexion.SetParameterProcedure("@Rfc", System.Data.ParameterDirection.Input, eTypes.Cadena, empleado.persona.Rfc);
        //            conexion.SetParameterProcedure("@Fotogracia", System.Data.ParameterDirection.Input, eTypes.Cadena, empleado.persona.Fotografia);
        //            conexion.SetParameterProcedure("@Rfc", System.Data.ParameterDirection.Input, eTypes.Cadena, empleado.persona.Rfc);
        //            conexion.SetParameterProcedure("@Genero", System.Data.ParameterDirection.Input, eTypes.Cadena, empleado.persona.Genero);
        //            conexion.SetParameterProcedure("@FechaNacimiento", System.Data.ParameterDirection.Input, eTypes.Date, empleado.persona.FechaNacimiento);
        //            conexion.SetParameterProcedure("@Cp", System.Data.ParameterDirection.Input, eTypes.Cadena, empleado.persona.Cp);
        //            conexion.SetParameterProcedure("@Domicilio", System.Data.ParameterDirection.Input, eTypes.Cadena, empleado.persona.Domicilio);
        //            //empleado
        //            conexion.SetParameterProcedure("@Codigo", System.Data.ParameterDirection.Input, eTypes.Cadena, empleado.Codigo);
        //            conexion.SetParameterProcedure("@Salario", System.Data.ParameterDirection.Input, eTypes.Entero, empleado.Salario);
        //            //usuario
        //            conexion.SetParameterProcedure("@Password", System.Data.ParameterDirection.Input, eTypes.Cadena, empleado.usuario.Password);
        //            conexion.SetParameterProcedure("@Rfc", System.Data.ParameterDirection.Input, eTypes.Cadena, empleado.usuario.Username);
        //            //rol
        //            conexion.SetParameterProcedure("@Rfc", System.Data.ParameterDirection.Input, eTypes.Cadena, empleado.usuario.rol.Descripcion);
        //            //id out
        //            conexion.SetParameterProcedure("@id", System.Data.ParameterDirection.Output, eTypes.Entero, null);
        //            empleado.IdEmpleado = long.Parse(conexion.ExecuteStoredOutPut().ToString());
        //            id = empleado.IdEmpleado;
        //        }
        //        catch (Exception ex)
        //        {
        //            id = 0;
        //        }
        //        finally
        //        {
        //            conexion = null;
        //        }
        //        return id;
        //    }

        public Cliente Registrar(Cliente cliente)
        {
            DSL conexion = new DSL();
            Cliente tempC = new Cliente();
            Persona tempP = new Persona();
            try
            {
                //persona
                conexion.Open(ConfigurationManager.ConnectionStrings["micadenaconexion"].ToString(), RNConnection.DataAbstractionLayer.Proveedor.SQLServer);
                conexion.InitialSQLStatement("dbo.InsertarCliente", System.Data.CommandType.StoredProcedure);
                conexion.SetParameterProcedure("@Nombre", System.Data.ParameterDirection.Input, eTypes.Cadena, cliente.persona.nombre);
                conexion.SetParameterProcedure("@ApellidoPaterno", System.Data.ParameterDirection.Input, eTypes.Cadena, cliente.persona.apellidoPaterno);
                conexion.SetParameterProcedure("@ApellidoMaterno", System.Data.ParameterDirection.Input, eTypes.Cadena, cliente.persona.apellidoMaterno);
                conexion.SetParameterProcedure("@Curp", System.Data.ParameterDirection.Input, eTypes.Cadena, cliente.persona.curp);
                conexion.SetParameterProcedure("@Rfc", System.Data.ParameterDirection.Input, eTypes.Cadena, cliente.persona.rfc);
                if (cliente.persona.fotografia != null)
                    conexion.SetParameterProcedure("@Fotografia", System.Data.ParameterDirection.Input, eTypes.Cadena, cliente.persona.fotografia);
                else
                    conexion.SetParameterProcedure("@Fotografia", System.Data.ParameterDirection.Input, eTypes.Cadena, " ");
                conexion.SetParameterProcedure("@Genero", System.Data.ParameterDirection.Input, eTypes.Cadena, cliente.persona.genero);
                conexion.SetParameterProcedure("@FechaNacimiento", System.Data.ParameterDirection.Input, eTypes.Date, cliente.persona.fechaNacimiento);
                conexion.SetParameterProcedure("@Cp", System.Data.ParameterDirection.Input, eTypes.Cadena, cliente.persona.cp);
                conexion.SetParameterProcedure("@Domicilio", System.Data.ParameterDirection.Input, eTypes.Cadena, cliente.persona.domicilio);
                //cliente
                conexion.SetParameterProcedure("@Email", System.Data.ParameterDirection.Input, eTypes.Cadena, cliente.email);
                conexion.SetParameterProcedure("@Telefono", System.Data.ParameterDirection.Input, eTypes.Cadena, cliente.telefono);

                //id out
                conexion.SetParameterProcedure("@IdPersonaGenerado", System.Data.ParameterDirection.Output, eTypes.Entero, null);

                conexion.SetParameterProcedure("@IdClienteGenerado", System.Data.ParameterDirection.Output, eTypes.Entero, null);
                //conexion.ExecuteNonQuery();

                //cliente.persona.id = int.Parse(conexion.ExecuteStoredOutPut().ToString());
                //cliente.id = int.Parse(conexion.ExecuteStoredOutPut().ToString());
                DataTableReader dtr = conexion.ExecuteTableReader();
                while (dtr.Read())
                {
                    tempC = new Cliente();
                    tempP = new Persona();
                    tempP.id = dtr.GetInt32(dtr.GetOrdinal("IdPersona"));
                    tempC.persona = tempP;
                    tempC.id = dtr.GetInt32(dtr.GetOrdinal("IdCliente"));
                }

                return tempC;
            }
            catch (Exception ex)
            {
                return tempC;
            }
            finally
            {
                conexion = null;
            }
        }


        //    public long RegistrarProducto(Producto producto)
        //    {
        //        DSL conexion = new DSL();
        //        long id = 0;
        //        try
        //        {
        //            //producto
        //            conexion.Open("Data Source = DESKTOP-3N20GVT;" + "Initial Catalog =JugueteriaWonka;" + "User id=sa;Password=sa", RNConnection.DataAbstractionLayer.Proveedor.SQLServer);
        //            conexion.InitialSQLStatement("dbo.pa_InsertarProducto", System.Data.CommandType.StoredProcedure);
        //            conexion.SetParameterProcedure("@Nombre", System.Data.ParameterDirection.Input, eTypes.Cadena, producto.Nombre);
        //            conexion.SetParameterProcedure("@Descripcion", System.Data.ParameterDirection.Input, eTypes.Cadena, producto.Descripcion);
        //            conexion.SetParameterProcedure("@Precio", System.Data.ParameterDirection.Input, eTypes.Entero, producto.Precio);
        //            conexion.SetParameterProcedure("@Stock", System.Data.ParameterDirection.Input, eTypes.Cadena, producto.Stock);
        //            conexion.SetParameterProcedure("@Marca", System.Data.ParameterDirection.Input, eTypes.Cadena, producto.marca.Nombre);
        //            conexion.SetParameterProcedure("@EdadMaxima", System.Data.ParameterDirection.Input, eTypes.Entero, producto.EdadMaxima);
        //            conexion.SetParameterProcedure("@EdadMinima", System.Data.ParameterDirection.Input, eTypes.Entero, producto.EdadMinima);
        //            conexion.SetParameterProcedure("@Fotografia", System.Data.ParameterDirection.Input, eTypes.Cadena, producto.Fotografia);
        //            //id out
        //            conexion.SetParameterProcedure("@id", System.Data.ParameterDirection.Output, eTypes.Entero, null);
        //            producto.IdProducto = long.Parse(conexion.ExecuteStoredOutPut().ToString());
        //            id = producto.IdProducto;
        //        }
        //        catch (Exception ex)
        //        {
        //            id = 0;
        //        }
        //        finally
        //        {
        //            conexion = null;
        //        }
        //        return id;
        //    }


        //    public long RegistrarBitacora()
        //    {
        //        Bitacora bitacora = new Bitacora();
        //        DSL conexion = new DSL();
        //        long id = 0;
        //        try
        //        {
        //            //bitacora
        //            conexion.Open("Data Source = DESKTOP-3N20GVT;" + "Initial Catalog =JugueteriaWonka;" + "User id=sa;Password=sa", RNConnection.DataAbstractionLayer.Proveedor.SQLServer);
        //            conexion.InitialSQLStatement("dbo.pa_InsertarBitacora", System.Data.CommandType.StoredProcedure);
        //            conexion.SetParameterProcedure("@id", System.Data.ParameterDirection.Output, eTypes.Entero, null);
        //            bitacora.IdBitacora = long.Parse(conexion.ExecuteStoredOutPut().ToString());
        //            id = bitacora.IdBitacora;
        //        }
        //        catch (Exception ex)
        //        {
        //            id = 0;
        //        }
        //        finally
        //        {
        //            conexion = null;
        //        }
        //        return id;
        //    }

        //    public bool RegistrarDetalleBitacora(Bitacora bitacora, Producto producto, int cantidad, float precioCompra)
        //    {
        //        DSL conexion = new DSL();
        //        try
        //        {
        //            //bitacora
        //            conexion.Open("Data Source = DESKTOP-3N20GVT;" + "Initial Catalog =JugueteriaWonka;" + "User id=sa;Password=sa", RNConnection.DataAbstractionLayer.Proveedor.SQLServer);
        //            conexion.InitialSQLStatement("dbo.pa_InsertarDetalleBitacora", System.Data.CommandType.StoredProcedure);
        //            conexion.SetParameterProcedure("@IdBitacora", System.Data.ParameterDirection.Input, eTypes.Entero, bitacora.IdBitacora);
        //            conexion.SetParameterProcedure("@IdProducto", System.Data.ParameterDirection.Input, eTypes.Entero, producto.IdProducto);
        //            conexion.SetParameterProcedure("@cantidad", System.Data.ParameterDirection.Input, eTypes.Entero, cantidad);
        //            conexion.SetParameterProcedure("@PrecioCompra", System.Data.ParameterDirection.Input, eTypes.Entero, precioCompra);
        //            return true;
        //        }
        //        catch (Exception ex)
        //        {
        //            return false;
        //        }
        //        finally
        //        {
        //            conexion = null;
        //        }
        //    }

        //    public long RegistrarVenta(Empleado empleado, Cliente cliente, FormaPago formaPago)
        //    {
        //        Venta venta = new Venta();
        //        DSL conexion = new DSL();
        //        long id = 0;
        //        try
        //        {
        //            //bitacora
        //            conexion.Open("Data Source = DESKTOP-3N20GVT;" + "Initial Catalog =JugueteriaWonka;" + "User id=sa;Password=sa", RNConnection.DataAbstractionLayer.Proveedor.SQLServer);
        //            conexion.InitialSQLStatement("dbo.pa_InsertarVenta", System.Data.CommandType.StoredProcedure);
        //            conexion.SetParameterProcedure("@IdEmpleado", System.Data.ParameterDirection.Input, eTypes.Entero, empleado.IdEmpleado);
        //            conexion.SetParameterProcedure("@IdCliente", System.Data.ParameterDirection.Input, eTypes.Entero, cliente.IdCliente);
        //            conexion.SetParameterProcedure("@IdFormaPago", System.Data.ParameterDirection.Input, eTypes.Entero, formaPago.IdFormaPago);
        //            conexion.SetParameterProcedure("@id", System.Data.ParameterDirection.Output, eTypes.Entero, null);
        //            venta.IdVenta = long.Parse(conexion.ExecuteStoredOutPut().ToString());
        //            id = venta.IdVenta;
        //        }
        //        catch (Exception ex)
        //        {
        //            id = 0;
        //        }
        //        finally
        //        {
        //            conexion = null;
        //        }
        //        return id;
        //    }

        //    public bool RegistrarDetalleVenta(Venta venta, Producto producto, int cantidad, float precio)
        //    {
        //        DSL conexion = new DSL();
        //        try
        //        {
        //            //bitacora
        //            conexion.Open("Data Source = DESKTOP-3N20GVT;" + "Initial Catalog =JugueteriaWonka;" + "User id=sa;Password=sa", RNConnection.DataAbstractionLayer.Proveedor.SQLServer);
        //            conexion.InitialSQLStatement("dbo.pa_InsertarDetalleBitacora", System.Data.CommandType.StoredProcedure);
        //            conexion.SetParameterProcedure("@IdVenta", System.Data.ParameterDirection.Input, eTypes.Entero, venta.IdVenta);
        //            conexion.SetParameterProcedure("@IdProducto", System.Data.ParameterDirection.Input, eTypes.Entero, producto.IdProducto);
        //            conexion.SetParameterProcedure("@cantidad", System.Data.ParameterDirection.Input, eTypes.Entero, cantidad);
        //            conexion.SetParameterProcedure("@Precio", System.Data.ParameterDirection.Input, eTypes.Entero, precio);
        //            return true;
        //        }
        //        catch (Exception ex)
        //        {
        //            return false;
        //        }
        //        finally
        //        {
        //            conexion = null;
        //        }
        //    }

        public List<Cliente> Consultar()
        {
            List<Cliente> listC = new List<Cliente>();
            DSL conexion = new DSL();
            try
            {
                //bitacora
                conexion.Open(ConfigurationManager.ConnectionStrings["micadenaconexion"].ToString(), RNConnection.DataAbstractionLayer.Proveedor.SQLServer);
                conexion.InitialSQLStatement("SELECT * FROM V_Clientes", System.Data.CommandType.Text);
                DataTableReader dtr = conexion.ExecuteTableReader();
                while (dtr.Read())
                {
                    Cliente tempC = new Cliente();
                    Persona tempP = new Persona();
                    tempP.id = dtr.GetInt32(dtr.GetOrdinal("IdPersona"));
                    tempP.nombre = dtr.GetString(dtr.GetOrdinal("Nombre"));
                    tempP.apellidoPaterno = dtr.GetString(dtr.GetOrdinal("ApellidoPaterno"));
                    tempP.apellidoMaterno = dtr.GetString(dtr.GetOrdinal("ApellidoMaterno"));
                    tempP.fotografia = dtr.GetString(dtr.GetOrdinal("Fotografia"));
                    tempP.genero = dtr.GetString(dtr.GetOrdinal("Genero"));
                    tempP.rfc = dtr.GetString(dtr.GetOrdinal("Rfc"));
                    tempP.curp = dtr.GetString(dtr.GetOrdinal("Curp"));
                    tempP.cp = dtr.GetString(dtr.GetOrdinal("Cp"));
                    tempP.domicilio = dtr.GetString(dtr.GetOrdinal("Domicilio"));
                    tempP.fechaNacimiento = dtr.GetString(dtr.GetOrdinal("FechaNacimiento"));

                    tempC.persona = tempP;
                    tempC.id = dtr.GetInt32(dtr.GetOrdinal("IdCliente"));
                    tempC.email = dtr.GetString(dtr.GetOrdinal("Email"));
                    tempC.telefono = dtr.GetString(dtr.GetOrdinal("Telefono"));
                    listC.Add(tempC);
                }
                return listC;
            }
            catch (Exception ex)
            {
                return listC = null;
            }
            finally
            {
                conexion = null;
            }
        }

        //public List<Empleado> ConsultarEmpleado(string filtro)
        //{
        //    List<Empleado> listE = new List<Empleado>();
        //    DSL conexion = new DSL();
        //    try
        //    {
        //        //bitacora
        //        conexion.Open("Data Source = DESKTOP-3N20GVT;" + "Initial Catalog =JugueteriaWonka;" + "User id=sa;Password=sa", RNConnection.DataAbstractionLayer.Proveedor.SQLServer);
        //        conexion.InitialSQLStatement("SELECT * FROM V_Empleados", System.Data.CommandType.Text);
        //        DataTableReader dtr = conexion.ExecuteTableReader();
        //        while (dtr.Read())
        //        {
        //            Empleado tempE = new Empleado();
        //            Persona tempP = new Persona();
        //            Rol tempR = new Rol();
        //            Usuario tempU = new Usuario();
        //            //persona
        //            tempP.Name = dtr.GetString(dtr.GetOrdinal("Nombre"));
        //            tempP.ApellidoPaterno = dtr.GetString(dtr.GetOrdinal("ApelllidPaterno"));
        //            tempP.ApellidoMaterno = dtr.GetString(dtr.GetOrdinal("ApellidoMaterno"));
        //            tempP.Fotografia = dtr.GetString(dtr.GetOrdinal("Fotografia"));
        //            tempP.Genero = dtr.GetString(dtr.GetOrdinal("Genero"));
        //            tempP.Rfc = dtr.GetString(dtr.GetOrdinal("Rfc"));
        //            tempP.Curp = dtr.GetString(dtr.GetOrdinal("Curp"));
        //            tempP.Cp = dtr.GetString(dtr.GetOrdinal("Cp"));
        //            tempP.Domicilio = dtr.GetString(dtr.GetOrdinal("Domicilio"));
        //            tempP.FechaNacimiento = dtr.GetDateTime(dtr.GetOrdinal("FechaNacimiento")).ToString();
        //            //rol
        //            tempR.Descripcion = dtr.GetString(dtr.GetOrdinal("Descripcion"));
        //            //usuario
        //            tempU.Password = dtr.GetString(dtr.GetOrdinal("Password"));
        //            tempU.Username = dtr.GetString(dtr.GetOrdinal("Username"));
        //            //empleado
        //            tempU.rol = tempR;
        //            tempE.usuario = tempU;
        //            tempE.persona = tempP;
        //            tempE.IdEmpleado = dtr.GetInt32(dtr.GetOrdinal("IdEmpleado"));
        //            tempE.FechaIngreso = dtr.GetDateTime(dtr.GetOrdinal("FechaIngreso"));
        //            tempE.Salario = dtr.GetFloat(dtr.GetOrdinal("SalarioBruto"));

        //            listE.Add(tempE);
        //        }
        //        return listE;
        //    }
        //    catch (Exception ex)
        //    {
        //        return listE = null;
        //    }
        //    finally
        //    {
        //        conexion = null;
        //    }
        //}

        //public List<Producto> ConsultarProducto(string filtro)
        //{
        //    List<Producto> listPr = new List<Producto>();
        //    DSL conexion = new DSL();
        //    try
        //    {
        //        conexion.Open("Data Source = DESKTOP-3N20GVT;" + "Initial Catalog =JugueteriaWonka;" + "User id=sa;Password=sa", RNConnection.DataAbstractionLayer.Proveedor.SQLServer);
        //        conexion.InitialSQLStatement("SELECT * FROM V_Productos", System.Data.CommandType.Text);
        //        DataTableReader dtr = conexion.ExecuteTableReader();
        //        while (dtr.Read())
        //        {
        //            Producto tempPr = new Producto();
        //            tempPr.IdProducto = dtr.GetInt32(dtr.GetOrdinal("IdProducto"));
        //            tempPr.Nombre = dtr.GetString(dtr.GetOrdinal("Nombre"));
        //            tempPr.Precio = dtr.GetFloat(dtr.GetOrdinal("Precio"));
        //            tempPr.marca.Nombre = dtr.GetString(dtr.GetOrdinal("marca"));
        //            tempPr.Fotografia = dtr.GetString(dtr.GetOrdinal("Fotografia"));
        //            tempPr.Stock = dtr.GetInt32(dtr.GetOrdinal("Stock"));
        //            tempPr.Descripcion = dtr.GetString(dtr.GetOrdinal("Descripcion"));
        //            tempPr.EdadMaxima = dtr.GetInt32(dtr.GetOrdinal("EdadMaxima"));
        //            tempPr.EdadMinima = dtr.GetInt32(dtr.GetOrdinal("EdadMinima"));

        //            listPr.Add(tempPr);
        //        }
        //        return listPr;
        //    }
        //    catch (Exception ex)
        //    {
        //        return listPr = null;
        //    }
        //    finally
        //    {
        //        conexion = null;
        //    }
        //}

        //public List<DetalleBitacora> ConsultarDetalleBitacora()
        //{
        //    List<DetalleBitacora> listDB = new List<DetalleBitacora>();
        //    DSL conexion = new DSL();
        //    try
        //    {
        //        conexion.Open("Data Source = DESKTOP-3N20GVT;" + "Initial Catalog =JugueteriaWonka;" + "User id=sa;Password=sa", RNConnection.DataAbstractionLayer.Proveedor.SQLServer);
        //        conexion.InitialSQLStatement("SELECT * FROM V_DetalleBitacoras", System.Data.CommandType.Text);
        //        DataTableReader dtr = conexion.ExecuteTableReader();
        //        while (dtr.Read())
        //        {
        //            DetalleBitacora tempDB = new DetalleBitacora();
        //            tempDB.Cantidad = dtr.GetInt32(dtr.GetOrdinal("Cantidad"));
        //            tempDB.PrecioCompra = dtr.GetInt32(dtr.GetOrdinal("PrecioCompra"));
        //            tempDB.bitacora.IdBitacora = dtr.GetInt32(dtr.GetOrdinal("IdBitacora"));
        //            tempDB.producto.IdProducto = dtr.GetInt32(dtr.GetOrdinal("IdProducto"));
        //            listDB.Add(tempDB);
        //        }
        //        return listDB;
        //    }
        //    catch (Exception ex)
        //    {
        //        return listDB = null;
        //    }
        //    finally
        //    {
        //        conexion = null;
        //    }
        //}

        //public List<Bitacora> ConsultarBitacora()
        //{
        //    List<Bitacora> listB = new List<Bitacora>();
        //    DSL conexion = new DSL();
        //    try
        //    {
        //        conexion.Open("Data Source = DESKTOP-3N20GVT;" + "Initial Catalog =JugueteriaWonka;" + "User id=sa;Password=sa", RNConnection.DataAbstractionLayer.Proveedor.SQLServer);
        //        conexion.InitialSQLStatement("SELECT * FROM V_Bitacoras", System.Data.CommandType.Text);
        //        DataTableReader dtr = conexion.ExecuteTableReader();
        //        while (dtr.Read())
        //        {
        //            Bitacora tempB = new Bitacora();
        //            tempB.IdBitacora = dtr.GetInt32(dtr.GetOrdinal("IdBitacora"));
        //            tempB.FechaAbastecimiento = dtr.GetDateTime(dtr.GetOrdinal("FechaAbastecimiento"));
        //            listB.Add(tempB);
        //        }
        //        return listB;
        //    }
        //    catch (Exception ex)
        //    {
        //        return listB = null;
        //    }
        //    finally
        //    {
        //        conexion = null;
        //    }
        //}

        //public List<DetalleVenta> ConsultarDetalleVenta()
        //{
        //    List<DetalleVenta> listDV = new List<DetalleVenta>();
        //    DSL conexion = new DSL();
        //    try
        //    {
        //        conexion.Open("Data Source = DESKTOP-3N20GVT;" + "Initial Catalog =JugueteriaWonka;" + "User id=sa;Password=sa", RNConnection.DataAbstractionLayer.Proveedor.SQLServer);
        //        conexion.InitialSQLStatement("SELECT * FROM V_DetalleVentas", System.Data.CommandType.Text);
        //        DataTableReader dtr = conexion.ExecuteTableReader();
        //        while (dtr.Read())
        //        {
        //            DetalleVenta tempDV = new DetalleVenta();
        //            tempDV.CantidadProducto = dtr.GetInt32(dtr.GetOrdinal("CantidadProducto"));
        //            tempDV.Precio = dtr.GetFloat(dtr.GetOrdinal("Precio"));
        //            tempDV.venta.IdVenta = dtr.GetInt32(dtr.GetOrdinal("IdVenta"));
        //            tempDV.producto.IdProducto = dtr.GetInt32(dtr.GetOrdinal("IdProducto"));
        //            listDV.Add(tempDV);
        //        }
        //        return listDV;
        //    }
        //    catch (Exception ex)
        //    {
        //        return listDV = null;
        //    }
        //    finally
        //    {
        //        conexion = null;
        //    }
        //}

        //public List<Venta> ConsultarVenta()
        //{
        //    List<Venta> listV = new List<Venta>();
        //    DSL conexion = new DSL();
        //    try
        //    {
        //        conexion.Open("Data Source = DESKTOP-3N20GVT;" + "Initial Catalog =JugueteriaWonka;" + "User id=sa;Password=sa", RNConnection.DataAbstractionLayer.Proveedor.SQLServer);
        //        conexion.InitialSQLStatement("SELECT * FROM V_Ventas", System.Data.CommandType.Text);
        //        DataTableReader dtr = conexion.ExecuteTableReader();
        //        while (dtr.Read())
        //        {
        //            Venta tempV = new Venta();
        //            tempV.IdVenta = dtr.GetInt32(dtr.GetOrdinal("IdVenta"));
        //            tempV.Fecha = dtr.GetDateTime(dtr.GetOrdinal("Fecha"));
        //            tempV.cliente.IdCliente = dtr.GetInt32(dtr.GetOrdinal("IdCliente"));
        //            tempV.empleado.IdEmpleado = dtr.GetInt32(dtr.GetOrdinal("IdEmpleado"));
        //            tempV.formaPago.IdFormaPago = dtr.GetInt32(dtr.GetOrdinal("IdFormaPago"));
        //            listV.Add(tempV);
        //        }
        //        return listV;
        //    }
        //    catch (Exception ex)
        //    {
        //        return listV = null;
        //    }
        //    finally
        //    {
        //        conexion = null;
        //    }
        //}

        //public bool EliminarCliente(int id)
        //{
        //    DSL conexion = new DSL();
        //    try
        //    {
        //        //bitacora
        //        conexion.Open("Data Source = DESKTOP-3N20GVT;" + "Initial Catalog =JugueteriaWonka;" + "User id=sa;Password=sa", RNConnection.DataAbstractionLayer.Proveedor.SQLServer);
        //        conexion.InitialSQLStatement("dbo.pa_EliminarCliente", System.Data.CommandType.StoredProcedure);
        //        conexion.SetParameterProcedure("@IdCliente", System.Data.ParameterDirection.Input, eTypes.Entero, id);
        //        return true;
        //    }
        //    catch (Exception ex)
        //    {
        //        return false;
        //    }
        //    finally
        //    {
        //        conexion = null;
        //    }
        //}

        //public bool EliminarEmpleado(int id)
        //{
        //    DSL conexion = new DSL();
        //    try
        //    {
        //        //bitacora
        //        conexion.Open("Data Source = DESKTOP-3N20GVT;" + "Initial Catalog =JugueteriaWonka;" + "User id=sa;Password=sa", RNConnection.DataAbstractionLayer.Proveedor.SQLServer);
        //        conexion.InitialSQLStatement("dbo.pa_EliminarEmpleado", System.Data.CommandType.StoredProcedure);
        //        conexion.SetParameterProcedure("@IdEmpleado", System.Data.ParameterDirection.Input, eTypes.Entero, id);
        //        return true;
        //    }
        //    catch (Exception ex)
        //    {
        //        return false;
        //    }
        //    finally
        //    {
        //        conexion = null;
        //    }
        //}

        //public bool EliminarProducto(int id)
        //{
        //    DSL conexion = new DSL();
        //    try
        //    {
        //        //bitacora
        //        conexion.Open("Data Source = DESKTOP-3N20GVT;" + "Initial Catalog =JugueteriaWonka;" + "User id=sa;Password=sa", RNConnection.DataAbstractionLayer.Proveedor.SQLServer);
        //        conexion.InitialSQLStatement("dbo.pa_EliminarProducto", System.Data.CommandType.StoredProcedure);
        //        conexion.SetParameterProcedure("@IdProducto", System.Data.ParameterDirection.Input, eTypes.Entero, id);
        //        return true;
        //    }
        //    catch (Exception ex)
        //    {
        //        return false;
        //    }
        //    finally
        //    {
        //        conexion = null;
        //    }
        //}

        //public bool EliminarVenta(int id)
        //{
        //    DSL conexion = new DSL();
        //    try
        //    {
        //        //bitacora
        //        conexion.Open("Data Source = DESKTOP-3N20GVT;" + "Initial Catalog =JugueteriaWonka;" + "User id=sa;Password=sa", RNConnection.DataAbstractionLayer.Proveedor.SQLServer);
        //        conexion.InitialSQLStatement("dbo.pa_EliminarCliente", System.Data.CommandType.StoredProcedure);
        //        conexion.SetParameterProcedure("@IdVenta", System.Data.ParameterDirection.Input, eTypes.Entero, id);
        //        return true;
        //    }
        //    catch (Exception ex)
        //    {
        //        return false;
        //    }
        //    finally
        //    {
        //        conexion = null;
        //    }
        //}

        //public bool EliminarBitacora(int id)
        //{
        //    DSL conexion = new DSL();
        //    try
        //    {
        //        //bitacora
        //        conexion.Open("Data Source = DESKTOP-3N20GVT;" + "Initial Catalog =JugueteriaWonka;" + "User id=sa;Password=sa", RNConnection.DataAbstractionLayer.Proveedor.SQLServer);
        //        conexion.InitialSQLStatement("dbo.pa_EliminarBitacoras", System.Data.CommandType.StoredProcedure);
        //        conexion.SetParameterProcedure("@IdBitacora", System.Data.ParameterDirection.Input, eTypes.Entero, id);
        //        return true;
        //    }
        //    catch (Exception ex)
        //    {
        //        return false;
        //    }
        //    finally
        //    {
        //        conexion = null;
        //    }
        //}

        //public bool ActualizarEmpleado(Empleado empleado)
        //{
        //    DSL conexion = new DSL();
        //    try
        //    {
        //        //persona
        //        conexion.Open("Data Source = DESKTOP-3N20GVT;" + "Initial Catalog =JugueteriaWonka;" + "User id=sa;Password=sa", RNConnection.DataAbstractionLayer.Proveedor.SQLServer);
        //        conexion.InitialSQLStatement("dbo.pa_ActualizarEmpleado", System.Data.CommandType.StoredProcedure);
        //        conexion.SetParameterProcedure("@IdEmpleado", System.Data.ParameterDirection.Input, eTypes.Entero, empleado.IdEmpleado);
        //        conexion.SetParameterProcedure("@Nombre", System.Data.ParameterDirection.Input, eTypes.Cadena, empleado.persona.Name);
        //        conexion.SetParameterProcedure("@ApellidoPaterno", System.Data.ParameterDirection.Input, eTypes.Cadena, empleado.persona.ApellidoPaterno);
        //        conexion.SetParameterProcedure("@ApellidoMaterno", System.Data.ParameterDirection.Input, eTypes.Cadena, empleado.persona.ApellidoMaterno);
        //        conexion.SetParameterProcedure("@Curp", System.Data.ParameterDirection.Input, eTypes.Cadena, empleado.persona.Curp);
        //        conexion.SetParameterProcedure("@Rfc", System.Data.ParameterDirection.Input, eTypes.Cadena, empleado.persona.Rfc);
        //        conexion.SetParameterProcedure("@Fotogracia", System.Data.ParameterDirection.Input, eTypes.Cadena, empleado.persona.Fotografia);
        //        conexion.SetParameterProcedure("@Rfc", System.Data.ParameterDirection.Input, eTypes.Cadena, empleado.persona.Rfc);
        //        conexion.SetParameterProcedure("@Genero", System.Data.ParameterDirection.Input, eTypes.Cadena, empleado.persona.Genero);
        //        conexion.SetParameterProcedure("@FechaNacimiento", System.Data.ParameterDirection.Input, eTypes.Date, empleado.persona.FechaNacimiento);
        //        conexion.SetParameterProcedure("@Cp", System.Data.ParameterDirection.Input, eTypes.Cadena, empleado.persona.Cp);
        //        conexion.SetParameterProcedure("@Domicilio", System.Data.ParameterDirection.Input, eTypes.Cadena, empleado.persona.Domicilio);
        //        //empleado
        //        conexion.SetParameterProcedure("@Codigo", System.Data.ParameterDirection.Input, eTypes.Cadena, empleado.Codigo);
        //        conexion.SetParameterProcedure("@Salario", System.Data.ParameterDirection.Input, eTypes.Entero, empleado.Salario);
        //        //usuario
        //        conexion.SetParameterProcedure("@Password", System.Data.ParameterDirection.Input, eTypes.Cadena, empleado.usuario.Password);
        //        conexion.SetParameterProcedure("@Rfc", System.Data.ParameterDirection.Input, eTypes.Cadena, empleado.usuario.Username);
        //        //rol
        //        conexion.SetParameterProcedure("@Rfc", System.Data.ParameterDirection.Input, eTypes.Cadena, empleado.usuario.rol.Descripcion);
        //        return true;
        //    }
        //    catch (Exception ex)
        //    {
        //        return false;
        //    }
        //    finally
        //    {
        //        conexion = null;
        //    }
        //}

        //public bool ActualizarCliente(Cliente cliente)
        //{
        //    DSL conexion = new DSL();
        //    try
        //    {
        //        //persona
        //        conexion.Open("Data Source = DESKTOP-3N20GVT;" + "Initial Catalog =JugueteriaWonka;" + "User id=sa;Password=sa", RNConnection.DataAbstractionLayer.Proveedor.SQLServer);
        //        conexion.InitialSQLStatement("dbo.pa_ActualizarCliente", System.Data.CommandType.StoredProcedure);
        //        conexion.SetParameterProcedure("@IdCliente", System.Data.ParameterDirection.Input, eTypes.Entero, cliente.IdCliente);
        //        conexion.SetParameterProcedure("@Nombre", System.Data.ParameterDirection.Input, eTypes.Cadena, cliente.persona.Name);
        //        conexion.SetParameterProcedure("@ApellidoPaterno", System.Data.ParameterDirection.Input, eTypes.Cadena, cliente.persona.ApellidoPaterno);
        //        conexion.SetParameterProcedure("@ApellidoMaterno", System.Data.ParameterDirection.Input, eTypes.Cadena, cliente.persona.ApellidoMaterno);
        //        conexion.SetParameterProcedure("@Curp", System.Data.ParameterDirection.Input, eTypes.Cadena, cliente.persona.Curp);
        //        conexion.SetParameterProcedure("@Rfc", System.Data.ParameterDirection.Input, eTypes.Cadena, cliente.persona.Rfc);
        //        conexion.SetParameterProcedure("@Fotogracia", System.Data.ParameterDirection.Input, eTypes.Cadena, cliente.persona.Fotografia);
        //        conexion.SetParameterProcedure("@Rfc", System.Data.ParameterDirection.Input, eTypes.Cadena, cliente.persona.Rfc);
        //        conexion.SetParameterProcedure("@Genero", System.Data.ParameterDirection.Input, eTypes.Cadena, cliente.persona.Genero);
        //        conexion.SetParameterProcedure("@FechaNacimiento", System.Data.ParameterDirection.Input, eTypes.Date, cliente.persona.FechaNacimiento);
        //        conexion.SetParameterProcedure("@Cp", System.Data.ParameterDirection.Input, eTypes.Cadena, cliente.persona.Cp);
        //        conexion.SetParameterProcedure("@Domicilio", System.Data.ParameterDirection.Input, eTypes.Cadena, cliente.persona.Domicilio);
        //        //cliente
        //        conexion.SetParameterProcedure("@Email", System.Data.ParameterDirection.Input, eTypes.Cadena, cliente.Email);
        //        conexion.SetParameterProcedure("@Telefono", System.Data.ParameterDirection.Input, eTypes.Cadena, cliente.Telefono);
        //        return true;
        //    }
        //    catch (Exception ex)
        //    {
        //        return false;
        //    }
        //    finally
        //    {
        //        conexion = null;
        //    }
        //}

        //public bool ActualizarProducto(Producto producto)
        //{
        //    DSL conexion = new DSL();
        //    try
        //    {
        //        //producto
        //        conexion.Open("Data Source = DESKTOP-3N20GVT;" + "Initial Catalog =JugueteriaWonka;" + "User id=sa;Password=sa", RNConnection.DataAbstractionLayer.Proveedor.SQLServer);
        //        conexion.InitialSQLStatement("dbo.pa_ActualizarProducto", System.Data.CommandType.StoredProcedure);
        //        conexion.SetParameterProcedure("@IdProducto", System.Data.ParameterDirection.Input, eTypes.Entero, producto.IdProducto);
        //        conexion.SetParameterProcedure("@Nombre", System.Data.ParameterDirection.Input, eTypes.Cadena, producto.Nombre);
        //        conexion.SetParameterProcedure("@Descripcion", System.Data.ParameterDirection.Input, eTypes.Cadena, producto.Descripcion);
        //        conexion.SetParameterProcedure("@Precio", System.Data.ParameterDirection.Input, eTypes.Entero, producto.Precio);
        //        conexion.SetParameterProcedure("@Stock", System.Data.ParameterDirection.Input, eTypes.Cadena, producto.Stock);
        //        conexion.SetParameterProcedure("@Marca", System.Data.ParameterDirection.Input, eTypes.Cadena, producto.marca.Nombre);
        //        conexion.SetParameterProcedure("@EdadMaxima", System.Data.ParameterDirection.Input, eTypes.Entero, producto.EdadMaxima);
        //        conexion.SetParameterProcedure("@EdadMinima", System.Data.ParameterDirection.Input, eTypes.Entero, producto.EdadMinima);
        //        conexion.SetParameterProcedure("@Fotografia", System.Data.ParameterDirection.Input, eTypes.Cadena, producto.Fotografia);
        //        return true;
        //    }
        //    catch (Exception ex)
        //    {
        //        return false;
        //    }
        //    finally
        //    {
        //        conexion = null;
        //    }
        //}
    }
}


