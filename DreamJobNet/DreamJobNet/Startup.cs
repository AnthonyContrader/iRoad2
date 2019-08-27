using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Consul;
using DreamJobNet.Config;
using DreamJobNet.DBContexts;
using DreamJobNet.Repository;
using DreamJobNet.Services;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.HttpsPolicy;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using Microsoft.Extensions.Logging;
using Microsoft.Extensions.Options;
using Microsoft.Owin.BuilderProperties;

namespace DreamJobNet
{
    public class Startup
    {

        public IConfiguration Configuration { get; }
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        

        // This method gets called by the runtime. Use this method to add services to the container.

        public void ConfigureServices(IServiceCollection services)
        {
            services.AddMvc().SetCompatibilityVersion(CompatibilityVersion.Version_2_1);
            services.AddDbContext<DBContexts.CompanyContext>(o => o.UseSqlServer(Configuration.GetConnectionString("CompanyDB")));
             services.AddTransient<ICompanyRepository, CompanyRepository>();
        
        services.AddSingleton <IHostedService, ConsulHostedService >();
            services.Configure<ConsulConfig>(Configuration.GetSection("ConsulConfig"));
            services.AddSingleton <IConsulClient, ConsulClient > (p => 
            new ConsulClient(consulConfig =>
            
            {
        var address = Configuration["ConsulConfig:Address"];
            consulConfig.Address = new Uri(address);
        }));
            services.AddSingleton<Func<IConsulClient>>(p => 
            () => new ConsulClient(consulConfig =>
            {
                var address = Configuration["ConsulConfig:Address"];
                consulConfig.Address = new Uri(address);
            }));


        }



    

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, Microsoft.AspNetCore.Hosting.IHostingEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }
            else
            {
                app.UseHsts();
            }

            app.UseHttpsRedirection();
            app.UseMvc();
        }








    }


}


