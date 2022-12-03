﻿// <auto-generated />
using System;
using Database.Provider.Context;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;

#nullable disable

namespace OnlineHackathon.Migrations
{
    [DbContext(typeof(FirstHackathonDbContext))]
    partial class FirstHackathonDbContextModelSnapshot : ModelSnapshot
    {
        protected override void BuildModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("ProductVersion", "7.0.0")
                .HasAnnotation("Relational:MaxIdentifierLength", 128);

            SqlServerModelBuilderExtensions.UseIdentityColumns(modelBuilder);

            modelBuilder.Entity("Database.Provider.Models.BirhSertificate", b =>
                {
                    b.Property<Guid>("Id")
                        .HasColumnType("uniqueidentifier");

                    b.Property<DateTime>("DateOfGetting")
                        .HasColumnType("datetime2");

                    b.Property<string>("IssueName")
                        .IsRequired()
                        .HasColumnType("nvarchar(max)");

                    b.Property<int>("Number")
                        .HasColumnType("int");

                    b.Property<int>("Series")
                        .HasColumnType("int");

                    b.HasKey("Id");

                    b.ToTable("BirhSertificates", (string)null);
                });

            modelBuilder.Entity("Database.Provider.Models.ParentStatus", b =>
                {
                    b.Property<Guid>("Id")
                        .HasColumnType("uniqueidentifier");

                    b.Property<string>("Name")
                        .IsRequired()
                        .HasColumnType("nvarchar(max)");

                    b.HasKey("Id");

                    b.ToTable("ParentStatuses", (string)null);
                });

            modelBuilder.Entity("Database.Provider.Models.ParentsChildren", b =>
                {
                    b.Property<Guid>("Id")
                        .HasColumnType("uniqueidentifier");

                    b.Property<Guid>("ChildId")
                        .HasColumnType("uniqueidentifier");

                    b.Property<Guid>("ParentId")
                        .HasColumnType("uniqueidentifier");

                    b.HasKey("Id");

                    b.ToTable("ParentsChildren", (string)null);
                });

            modelBuilder.Entity("Database.Provider.Models.Passport", b =>
                {
                    b.Property<Guid>("Id")
                        .HasColumnType("uniqueidentifier");

                    b.Property<DateTime>("DateOfEnding")
                        .HasColumnType("datetime2");

                    b.Property<DateTime>("DateOfGetting")
                        .HasColumnType("datetime2");

                    b.Property<bool>("IsRussianPasport")
                        .HasColumnType("bit");

                    b.Property<string>("IssueName")
                        .HasColumnType("nvarchar(max)");

                    b.Property<int>("Number")
                        .HasColumnType("int");

                    b.Property<int>("Series")
                        .HasColumnType("int");

                    b.HasKey("Id");

                    b.ToTable("Pasports", (string)null);
                });

            modelBuilder.Entity("Database.Provider.Models.Person", b =>
                {
                    b.Property<Guid>("Id")
                        .HasColumnType("uniqueidentifier");

                    b.Property<string>("Address")
                        .IsRequired()
                        .HasColumnType("nvarchar(max)");

                    b.Property<string>("CitizenCountry")
                        .IsRequired()
                        .HasColumnType("nvarchar(max)");

                    b.Property<string>("Email")
                        .HasColumnType("nvarchar(max)");

                    b.Property<string>("FirstName")
                        .IsRequired()
                        .HasColumnType("nvarchar(max)");

                    b.Property<string>("LastName")
                        .IsRequired()
                        .HasColumnType("nvarchar(max)");

                    b.Property<string>("Login")
                        .IsRequired()
                        .HasColumnType("nvarchar(max)");

                    b.Property<string>("MiddleName")
                        .IsRequired()
                        .HasColumnType("nvarchar(max)");

                    b.Property<Guid>("ParentStatusId")
                        .HasColumnType("uniqueidentifier");

                    b.Property<string>("Password")
                        .IsRequired()
                        .HasColumnType("nvarchar(max)");

                    b.Property<string>("PhoneNumber")
                        .IsRequired()
                        .HasColumnType("nvarchar(max)");

                    b.Property<string>("Snils")
                        .IsRequired()
                        .HasColumnType("nvarchar(max)");

                    b.Property<DateTime>("birthday")
                        .HasColumnType("datetime2");

                    b.HasKey("Id");

                    b.HasIndex("ParentStatusId");

                    b.ToTable("Parents", (string)null);
                });

            modelBuilder.Entity("Database.Provider.Models.BirhSertificate", b =>
                {
                    b.HasOne("Database.Provider.Models.Person", "Child")
                        .WithOne("BirthSertificate")
                        .HasForeignKey("Database.Provider.Models.BirhSertificate", "Id")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.Navigation("Child");
                });

            modelBuilder.Entity("Database.Provider.Models.Person", b =>
                {
                    b.HasOne("Database.Provider.Models.Passport", "Passport")
                        .WithOne("Person")
                        .HasForeignKey("Database.Provider.Models.Person", "Id")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.HasOne("Database.Provider.Models.ParentStatus", "ParentStatus")
                        .WithMany("Parents")
                        .HasForeignKey("ParentStatusId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.Navigation("ParentStatus");

                    b.Navigation("Passport");
                });

            modelBuilder.Entity("Database.Provider.Models.ParentStatus", b =>
                {
                    b.Navigation("Parents");
                });

            modelBuilder.Entity("Database.Provider.Models.Passport", b =>
                {
                    b.Navigation("Person");
                });

            modelBuilder.Entity("Database.Provider.Models.Person", b =>
                {
                    b.Navigation("BirthSertificate");
                });
#pragma warning restore 612, 618
        }
    }
}
