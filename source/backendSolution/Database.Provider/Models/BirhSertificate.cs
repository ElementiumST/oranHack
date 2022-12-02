using Data.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Database.Provider.Models
{
    public class BirhSertificate : IBirthSertificate
    {
        /// <summary>
        /// 
        /// </summary>
        public Guid Id { get; set; }

        /// <summary>
        /// 
        /// </summary>
        public int Series { get; set; }

        /// <summary>
        /// 
        /// </summary>
        public int Number { get; set;  }

        /// <summary>
        /// 
        /// </summary>
        public DateTime DateOfGetting { get; set;  }

        /// <summary>
        /// 
        /// </summary>
        public string IssueName { get; set;  }

        /// <summary>
        /// 
        /// </summary>
        public bool IsRussianPasport { get; set; }
    }
}
