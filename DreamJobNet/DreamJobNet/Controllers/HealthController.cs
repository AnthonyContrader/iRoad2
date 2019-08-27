using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

// HEALTH CONTROLLER UTILIZZATO PER IL CONTROLLO DI INTEGRITA', PER MONITORARE LO STATO DEI SERVIZI IN CONSUL

namespace DreamJobNet.Controllers
{
    [Route("api/[controller]")]
    public class HealthController : Controller
    {
        [HttpGet("status")]
        public IActionResult Status() => Ok();
    }
}

