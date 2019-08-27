using DreamJobNet.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace DreamJobNet.Repository
{
    interface ICompanyRepository
    {
        IEnumerable<Company> GetCompanies();
        Company GetCompanyByID(int CompanyId);
        void InsertCompany(Company Company);
        void DeleteCompany(int CompanyId);
        void UpdateCompany(Company Company);
        void Save();

    }
}
