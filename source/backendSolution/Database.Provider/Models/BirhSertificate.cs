using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Database.Provider.Models
{
    public class BirhSertificate
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

        public Person Child { get; set; }
    }
}
