using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Transactions;
using DreamJobNet.Models;
using DreamJobNet.Repository;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace DreamJobNet.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class CompanyController : ControllerBase
    {
        private readonly ICompanyRepository _companyRepository;

        public CompanyController(CompanyRepository companyRepository)
        {
            _companyRepository = companyRepository;
        }
        [HttpGet]
        public IActionResult Get(object companies)
        {
            var products = _companyRepository.GetCompanies();
            return new OkObjectResult(companies);
        }

        [HttpGet("{id}", Name = "Get")]
        public IActionResult Get(int id)
        {
            var company = _companyRepository.GetCompanyByID(id);
            return new OkObjectResult(company);
        }

        [HttpPost]
        public IActionResult Post([FromBody] Company company)
        {
            using (var scope = new TransactionScope())
            {
                _companyRepository.InsertCompany(company);
                scope.Complete();
                return CreatedAtAction(nameof(Get), new { id = company.Id }, company);
            }
        }

        [HttpPut]
        public IActionResult Put([FromBody] Company company)
        {
            if (company != null)
            {
                using (var scope = new TransactionScope())
                {
                    _companyRepository.UpdateCompany(company);
                    scope.Complete();
                    return new OkResult();
                }
            }
            return new NoContentResult();
        }

        [HttpDelete("{id}")]
        public IActionResult Delete(int id)
        {
            _companyRepository.DeleteCompany(id);
            return new OkResult();
        }
    }
}
