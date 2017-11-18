using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using System.Threading.Tasks;

namespace wfcJugueteriaK
{

    [DataContract]
    public class Persona
    {
        [DataMember]
        public long id { get; set; }
        [DataMember]
        public string nombre { get; set; }
        [DataMember]
        public string apellidoPaterno { get; set; }
        [DataMember]
        public string apellidoMaterno { get; set; }
        [DataMember]
        public string genero { get; set; }
        [DataMember]
        public string rfc { get; set; }
        [DataMember]
        public string curp { get; set; }
        [DataMember]
        public string fechaNacimiento { get; set; }
        [DataMember]
        public string cp { get; set; }
        [DataMember]
        public string fotografia { get; set; }
        [DataMember]
        public string domicilio { get; set; }
    }
    [DataContract]
    public class Rol
    {
        [DataMember]
        public long IdRol { get; set; }
        [DataMember]
        public string Descripcion { get; set; }

    }
    [DataContract]
    public class Usuario
    {
        [DataMember]
        public long IdUsuario { get; set; }
        [DataMember]
        public string Username { get; set; }
        [DataMember]
        public string Password { get; set; }
        [DataMember]
        public int Activo { get; set; }
        [DataMember]
        public Rol rol { get; set; }
    }
    [DataContract]
    public class Empleado
    {
        [DataMember]
        public long IdEmpleado { get; set; }
        [DataMember]
        public float Salario { get; set; }
        [DataMember]
        public string Codigo { get; set; }
        [DataMember]
        public DateTime FechaIngreso { get; set; }
        [DataMember]
        public int Activo { get; set; }
        [DataMember]
        public Persona persona { get; set; }
        [DataMember]
        public Usuario usuario { get; set; }
    }
    [DataContract]
    public class Cliente
    {
        [DataMember]
        public long id { get; set; }
        [DataMember]
        public string email { get; set; }
        [DataMember]
        public string telefono { get; set; }
        [DataMember]
        public int activo { get; set; }
        [DataMember]
        public Persona persona { get; set; }
    }
    [DataContract]
    public class Producto
    {
        [DataMember]
        public long IdProducto { get; set; }
        [DataMember]
        public string Nombre { get; set; }
        [DataMember]
        public int EdadMinima { get; set; }
        [DataMember]
        public int EdadMaxima { get; set; }
        [DataMember]
        public string Descripcion { get; set; }
        [DataMember]
        public float Precio { get; set; }
        [DataMember]
        public int Stock { get; set; }
        [DataMember]
        public string Fotografia { get; set; }
        [DataMember]
        public int Activo { get; set; }
        [DataMember]
        public Marca marca { get; set; }

    }
    [DataContract]
    public class Marca
    {
        [DataMember]
        public long IdMarca { get; set; }
        [DataMember]
        public string Nombre { get; set; }

    }
    [DataContract]
    public class FormaPago
    {
        [DataMember]
        public long IdFormaPago { get; set; }
        [DataMember]
        public string Descripcion { get; set; }

    }
    [DataContract]
    public class Venta
    {
        [DataMember]
        public long IdVenta { get; set; }
        [DataMember]
        public DateTime Fecha { get; set; }
        [DataMember]
        public Empleado empleado { get; set; }
        [DataMember]
        public Cliente cliente { get; set; }
        [DataMember]
        public FormaPago formaPago { get; set; }

    }
    [DataContract]
    public class DetalleVenta
    {
        [DataMember]
        public long IdDetalleVenta { get; set; }
        [DataMember]
        public int CantidadProducto { get; set; }
        [DataMember]
        public float Precio { get; set; }
        [DataMember]
        public Venta venta { get; set; }
        [DataMember]
        public Producto producto { get; set; }

    }
    [DataContract]
    public class Bitacora
    {
        [DataMember]
        public long IdBitacora { get; set; }
        [DataMember]
        public DateTime FechaAbastecimiento { get; set; }

    }
    [DataContract]
    public class DetalleBitacora
    {
        [DataMember]
        public long IdDetalleBitacora { get; set; }
        [DataMember]
        public int Cantidad { get; set; }
        [DataMember]
        public float PrecioCompra { get; set; }
        [DataMember]
        public Bitacora bitacora { get; set; }
        [DataMember]
        public Producto producto { get; set; }

    }
    [DataContract]
    public class Sesion
    {
        [DataMember]
        public EstadoSesion Estado { get; set; }

        [DataMember]
        public string Token { get; set; }
    }

    [DataContract]
    public enum EstadoSesion : int
    {
        [EnumMember]
        NoValido = 0,
        [EnumMember]
        Valido = 1,
    }

    [DataContract]
    public class verificador
    {
        [DataMember]
        public Sesion Sesion { get; set; }

        [DataMember]
        public Usuario Usuario { get; set; }
    }
}
