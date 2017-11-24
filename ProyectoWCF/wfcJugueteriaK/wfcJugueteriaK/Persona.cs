using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace wfcJugueteriaK
{
    [DataContract]
    public class Persona
    {
        [DataMember]
        public int id { get; set; }
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
}
