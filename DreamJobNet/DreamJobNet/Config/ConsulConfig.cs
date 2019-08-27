using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;


// CAMPI NECESSARI PER LA CONFIGURAZIONE DEL REGISTRO CONSUL

namespace DreamJobNet.Config
{
    public class ConsulConfig
    {
        public string Address { get; set; }
        public string ServiceName { get; set; }
        public string ServiceID { get; set; }
    }
}
