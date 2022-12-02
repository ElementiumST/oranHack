using Data.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Database.Provider.Models
{
    public class Passport : IPassport
    {
        public Guid Id { get; set; }

        public int Series { get; set; }

        public int Number { get; set; }

        public DateTime DateOfGetting { get; set; }

        public string IssueName { get; set; }

        public bool IsRussianPasport { get; set; }

        public DateTime DateOfEnding { get; set; }
    }
}
