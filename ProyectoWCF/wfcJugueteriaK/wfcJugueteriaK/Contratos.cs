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
    public interface Contratos
    {
        //[OperationContract]
        //verificador Login(Usuario Usuario);

        //[OperationContract]
        //string IpCliente();

        ////Insert
        //[OperationContract]
        //[WebInvoke()]
        //long RegistrarEmpleado(Empleado empleado);
        
        [OperationContract]
        [WebInvoke(Method ="POST",BodyStyle =WebMessageBodyStyle.Bare,ResponseFormat =WebMessageFormat.Json,RequestFormat =WebMessageFormat.Json)]
        Cliente RegistrarCliente(Cliente cliente);
        //[OperationContract]
        //[WebInvoke()]
        //long RegistrarProducto(Producto producto);
        //[OperationContract]
        //[WebInvoke()]
        //long RegistrarBitacora();
        //[OperationContract]
        //[WebInvoke()]
        //bool RegistrarDetalleBitacora(Bitacora bitacora, Producto procuto, int cantidad, float precioCompra);
        //[OperationContract]
        //[WebInvoke()]
        //long RegistrarVenta(Empleado empleado, Cliente cliente, FormaPago formaPago);
        //[OperationContract]
        //[WebInvoke()]
        //bool RegistrarDetalleVenta(Venta bitacora, Producto producto, int cantidad, float precio);

        //View
        [OperationContract]
        [WebGet(ResponseFormat = WebMessageFormat.Json, BodyStyle = WebMessageBodyStyle.Bare)]
        List<Cliente> ConsultarCliente();
        //[OperationContract]
        //[WebGet()]
        //List<Empleado> ConsultarEmpleado(string filtro);
        //[OperationContract]
        //[WebGet()]
        //List<Producto> ConsultarProducto(string filtro);
        //[OperationContract]
        //[WebGet()]
        //List<Bitacora> ConsultarBitacora();
        //[OperationContract]
        //[WebGet()]
        //List<Venta> ConsultarVenta();
        //[OperationContract]
        //[WebGet()]
        //List<DetalleBitacora> ConsultarDetalleBitacora();
        //[OperationContract]
        //[WebGet()]
        //List<DetalleVenta> ConsultarDetalleVenta();

        ////Delete Logico
        [OperationContract]
        [WebInvoke(Method = "POST", BodyStyle = WebMessageBodyStyle.Bare, ResponseFormat = WebMessageFormat.Json, RequestFormat = WebMessageFormat.Json)]
        void EliminarCliente(Cliente cliente);
        //[OperationContract]
        //[WebInvoke()]
        //bool EliminarEmpleado(int id);
        //[OperationContract]
        //[WebInvoke()]
        //bool EliminarProducto(int id);
        //[OperationContract]
        //[WebInvoke()]
        //bool EliminarBitacora(int id);
        //[OperationContract]
        //[WebInvoke()]
        //bool EliminarVenta(int id);

        //Update
        [OperationContract]
        [WebInvoke(Method = "POST", BodyStyle = WebMessageBodyStyle.Bare, ResponseFormat = WebMessageFormat.Json, RequestFormat = WebMessageFormat.Json)]
        void UpdateCliente(Cliente cliente);
        //[OperationContract]
        //[WebInvoke()]
        //bool ActualizarEmpleado(Empleado empleado);
        //[OperationContract]
        //[WebInvoke()]
        //bool ActualizarProducto(Producto producto);
    }

}
