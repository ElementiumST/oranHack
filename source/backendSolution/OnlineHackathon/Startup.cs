using Database.Provider.Context;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Http;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using Microsoft.IdentityModel.Tokens;
using OnlineHackathon.Extensions;
using OnlineHackathon.Models.Authentication;
using System.Text;

namespace OnlineHackathon
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }
        // This method gets called by the runtime. Use this method to add services to the container.
        // For more information on how to configure your application, visit https://go.microsoft.com/fwlink/?LinkID=398940
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddAuthentication().AddJwtBearer("person", options =>
            {
                options.RequireHttpsMetadata = false;
                options.TokenValidationParameters = new TokenValidationParameters
                {
                    ValidateIssuer = true,
                    ValidIssuer = Configuration["Auth:PersonJwt:Issuer"],
                    ValidateAudience = true,
                    ValidAudience = Configuration["Auth:PersonJwt:Audience"],
                    ValidateLifetime = false,
                    IssuerSigningKey =
                        new SymmetricSecurityKey(Encoding.UTF8.GetBytes(Configuration["Auth:PersonJwt:SecretKey"])),
                    ValidateIssuerSigningKey = true,
                };
            }).AddJwtBearer("admin", options =>
            {
                options.RequireHttpsMetadata = false;
                options.TokenValidationParameters = new TokenValidationParameters
                {
                    ValidateIssuer = true,
                    ValidIssuer = Configuration["Auth:AdminJwt:Issuer"],
                    ValidateAudience = true,
                    ValidAudience = Configuration["Auth:AdminJwt:Audience"],
                    ValidateLifetime = false,
                    IssuerSigningKey = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(Configuration["Auth:AdminJwt:SecretKey"])),
                    ValidateIssuerSigningKey = true,
                };
            });

            services.AddAuthorization(o =>
            {
                var minerPolicy = new AuthorizationPolicyBuilder("person").RequireAuthenticatedUser();
                o.AddPolicy("person", minerPolicy.Build());
            });

            services.AddScoped<IJwtAccessTokenFactory, JwtAccessTokenFactory>();
            services.Configure<JwtAuthPersonOptions>(Configuration.GetSection("Auth:PersonJwt"));

            services.AddDbContext<FirstHackathonDbContext>(options =>
                options.UseSqlServer(Configuration.GetConnectionString("Hackhathon"), b => b.MigrationsAssembly("OnlineHackathon")));
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }

            app.UseRouting();

            app.UseEndpoints(endpoints =>
            {
                endpoints.MapGet("/", async context =>
                {
                    await context.Response.WriteAsync("Hello World!");
                });
            });
        }
    }
}
