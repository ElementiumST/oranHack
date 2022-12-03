using Database.Provider.Models;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Text;

namespace Database.Provider.Context
{
    public sealed class FirstHackathonDbContext : Microsoft.EntityFrameworkCore.DbContext
    {
        public FirstHackathonDbContext(DbContextOptions<FirstHackathonDbContext> options) : base(options)
        {
            if (Database.EnsureCreated())
                LoadTestData();
        }

        public DbSet<Person> Persons { get; set; }

        private void LoadTestData()
        {
            
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {

            modelBuilder.Entity<Person>(builder =>
            {
                builder.ToTable("Parents");

                builder.HasKey(o => o.Id);
                builder.Property(o => o.Id)
                    .ValueGeneratedNever()
                    .IsRequired();

                builder.Property(o => o.Login)
                    .IsRequired(true);

                builder.Property(o => o.Password)
                     .IsRequired(true);

                builder.Property(o => o.birthday)
                    .IsRequired(true);

                builder.Property(o => o.Snils)
                     .IsRequired(true);

                builder.Property(o => o.FirstName)
                   .IsRequired(true);

                builder.Property(o => o.MiddleName)
                     .IsRequired(true);

                builder.Property(o => o.LastName)
                     .IsRequired(true);

                builder.Property(o => o.CitizenCountry)
                   .IsRequired(true);

                builder.Property(o => o.Email)
                     .IsRequired(false);

                builder.Property(o => o.PhoneNumber)
                     .IsRequired(true);

                builder.Property(o => o.Address)
                     .IsRequired(true);

                builder.HasOne(o => o.Passport)
                .WithOne(o => o.Person).HasForeignKey<Person>(o => o.Id);

                builder.HasOne(o => o.BirthSertificate)
                .WithOne(o => o.Child);

            });

            modelBuilder.Entity<Passport>(builder =>
            {
                builder.ToTable("Pasports");

                builder.HasKey(o => o.Id);
                builder.Property(o => o.Id)
                    .ValueGeneratedNever()
                    .IsRequired();

                builder.Property(o => o.DateOfEnding)
                    .IsRequired(true);

                builder.Property(o => o.DateOfGetting)
                     .IsRequired(true);

                builder.Property(o => o.Series)
                    .IsRequired(true);

                builder.Property(o => o.Number)
                     .IsRequired(true);

                builder.Property(o => o.IssueName)
                   .IsRequired(false);

                builder.Property(o => o.IsRussianPasport);

            });

            modelBuilder.Entity<BirhSertificate>(builder =>
            {
                builder.ToTable("BirhSertificates");

                builder.HasKey(o => o.Id);
                builder.Property(o => o.Id)
                    .ValueGeneratedNever()
                    .IsRequired();

                builder.Property(o => o.DateOfGetting)
                     .IsRequired(true);

                builder.Property(o => o.Series)
                    .IsRequired(true);

                builder.Property(o => o.Number)
                     .IsRequired(true);

                builder.Property(o => o.IssueName)
                   .IsRequired(true);

                builder.HasOne(o => o.Child)
                .WithOne(o => o.BirthSertificate).HasForeignKey<BirhSertificate>(o => o.Id);
            });

            modelBuilder.Entity<ParentStatus>(builder =>
            {
                builder.ToTable("ParentStatuses");

                builder.HasKey(o => o.Id);
                builder.Property(o => o.Id)
                    .ValueGeneratedNever()
                    .IsRequired();

                builder.Property(o => o.Name)
                    .IsRequired(true);

                builder.HasMany(o => o.Parents)
                .WithOne(o => o.ParentStatus)
                     .IsRequired(true);
            });

            modelBuilder.Entity<ParentsChildren>(builder =>
            {
                builder.ToTable("ParentsChildren");

                builder.HasKey(o => o.Id);
                builder.Property(o => o.Id)
                    .ValueGeneratedNever()
                    .IsRequired();

                builder.Property(o => o.ParentId)
                    .IsRequired(true);

                builder.Property(o => o.ChildId)
                    .IsRequired(true);
            });
        }
    }
}
