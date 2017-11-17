using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using System.Threading.Tasks;

namespace wfcJugueteriaK
{

    [ServiceContract]
    public interface ContratoJK
    {

        //Insert
        [OperationContract]
        long RegistrarEmpleado(Empleado empleado);
        [OperationContract]
        long RegistrarCliente(Cliente cliente);
        [OperationContract]
        long RegistrarProducto(Producto producto);
        [OperationContract]
        long RegistrarBitacora();
        [OperationContract]
        bool RegistrarDetalleBitacora(Bitacora bitacora, Producto procuto, int cantidad, float precioCompra);
        [OperationContract]
        long RegistrarVenta(Empleado empleado, Cliente cliente, FormaPago formaPago);
        [OperationContract]
        bool RegistrarDetalleVenta(Venta bitacora, Producto procuto, int cantidad, float precio);

        //View
        [OperationContract]
        List<Cliente> ConsultarCliente();
        [OperationContract]
        List<Empleado> ConsultarEmpleado(string filtro);
        [OperationContract]
        List<Producto> ConsultarProducto(string filtro);
        [OperationContract]
        List<Bitacora> ConsultarBitacora();
        [OperationContract]
        List<Venta> ConsultarVenta();
        [OperationContract]
        List<DetalleBitacora> ConsultarDetalleBitacora();
        [OperationContract]
        List<DetalleVenta> ConsultarDetalleVenta();

        //Delete Logico
        [OperationContract]
        bool EliminarCliente(int id);
        [OperationContract]
        bool EliminarEmpleado(int id);
        [OperationContract]
        bool EliminarProducto(int id);
        [OperationContract]
        bool EliminarBitacora(int id);
        [OperationContract]
        bool EliminarVenta(int id);

        //Update
        [OperationContract]
        bool ActualizarCliente(Cliente cliente);
        [OperationContract]
        bool ActualizarEmpleado(Empleado empleado);
        [OperationContract]
        bool ActualizarProducto(Producto producto);


        

    }

    [ServiceContract(Namespace = "ISSC311")]
    public interface ContratoJSJK
    {
        [OperationContract]
        verificador Login(Usuario Usuario);

        [OperationContract]
        string IpCliente();

        //Insert
        [OperationContract]
        long RegistrarEmpleado(Empleado empleado);
        [OperationContract]
        long RegistrarCliente(Cliente cliente);
        [OperationContract]
        long RegistrarProducto(Producto producto);
        [OperationContract]
        long RegistrarBitacora();
        [OperationContract]
        bool RegistrarDetalleBitacora(Bitacora bitacora, Producto procuto, int cantidad, float precioCompra);
        [OperationContract]
        long RegistrarVenta(Empleado empleado, Cliente cliente, FormaPago formaPago);
        [OperationContract]
        bool RegistrarDetalleVenta(Venta bitacora, Producto procuto, int cantidad, float precio);

        //View
        [OperationContract]
        [WebGet()]
        List<Cliente> ConsultarCliente();
        [OperationContract]
        [WebGet()]
        List<Empleado> ConsultarEmpleado(string filtro);
        [OperationContract]
        [WebGet()]
        List<Producto> ConsultarProducto(string filtro);
        [OperationContract]
        [WebGet()]
        List<Bitacora> ConsultarBitacora();
        [OperationContract]
        [WebGet()]
        List<Venta> ConsultarVenta();
        [OperationContract]
        [WebGet()]
        List<DetalleBitacora> ConsultarDetalleBitacora();
        [OperationContract]
        [WebGet()]
        List<DetalleVenta> ConsultarDetalleVenta();

        //Delete Logico
        [OperationContract]
        [WebInvoke()]
        bool EliminarCliente(int id);
        [OperationContract]
        [WebInvoke()]
        bool EliminarEmpleado(int id);
        [OperationContract]
        [WebInvoke()]
        bool EliminarProducto(int id);
        [OperationContract]
        [WebInvoke()]
        bool EliminarBitacora(int id);
        [OperationContract]
        [WebInvoke()]
        bool EliminarVenta(int id);

        //Update
        [OperationContract]
        bool ActualizarCliente(Cliente cliente);
        [OperationContract]
        bool ActualizarEmpleado(Empleado empleado);
        [OperationContract]
        bool ActualizarProducto(Producto producto);
    }

}
