using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using DreamJobNet.DBContexts;
using DreamJobNet.Models;
using Microsoft.EntityFrameworkCore;

namespace DreamJobNet.Repository
{
    public class CompanyRepository : ICompanyRepository
    {
        private readonly CompanyContext _dbContext;

        public CompanyRepository(CompanyContext dbContext)
        {
            _dbContext = dbContext;
        }
        public void DeleteCompany(int companyId)
        {
            var company = _dbContext.Companies.Find(companyId);
            _dbContext.Companies.Remove(company);
            Save();
        }

        public Company GetCompanyByID(int companyId)
        {
            return _dbContext.Companies.Find(companyId);
        }

        public IEnumerable<Company> GetCompanies()
        {
            return _dbContext.Companies.ToList();
        }

        public void InsertCompany(Company company)
        {
            _dbContext.Add(company);
            Save();
        }

        public void Save()
        {
            _dbContext.SaveChanges();
        }

        public void UpdateCompany(Company company)
        {
            _dbContext.Entry(company).State = EntityState.Modified;
            Save();
        }
    }
}


