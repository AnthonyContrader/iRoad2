using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using DreamJobNet.Models;
using Microsoft.EntityFrameworkCore;



namespace DreamJobNet.DBContexts
{
    public class CompanyContext : DbContext   //i due punti indicano l'estensione, cioè CompanyContext estende DbContext
    {
        public CompanyContext(DbContextOptions<CompanyContext> options) : base(options)
        {
        }
        public DbSet<Company> Companies { get; set; }
        public DbSet<Candidato> Candidatos { get; set; }
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Candidato>().HasData(
                new Candidato
                {
                    Id = 1,
                    Name = "Luca",
                    Surname = "Pepe",
                    Age = 34,
                },

                 new Candidato
                 {
                     Id = 2,
                     Name = "Anna",
                     Surname = "Tele",
                     Age = 28,
                 },

                  new Candidato
                  {
                      Id = 3,
                      Name = "Pino",
                      Surname = "Sele",
                      Age = 51,
                  }

                  );
        }

    }

}

