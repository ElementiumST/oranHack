using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Text;

namespace Database.Provider.Context
{
    public sealed class FirstHackathonDbContext : Microsoft.EntityFrameworkCore.DbContext
    {
        public FirstHackathonDbContext(DbContextOptions options) : base(options)
        {
            if (Database.EnsureCreated())
                LoadTestData();
        }

        private void LoadTestData()
        {
            
        }
    }
}
