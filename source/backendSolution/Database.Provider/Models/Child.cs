using Data.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Database.Provider.Models
{
    public class Child : IChild
    {
        /// <summary>
        /// 
        /// </summary>
        public Guid Id { get; set; }

        /// <summary>
        /// 
        /// </summary>
        public string FirstName { get; set; }

        /// <summary>
        /// 
        /// </summary>
        public string MiddleName { get; set;  }

        /// <summary>
        /// 
        /// </summary>
        public string LastName { get; set;  }

        /// <summary>
        /// 
        /// </summary>
        public string CitizenCountry { get; set;  }

        /// <summary>
        /// 
        /// </summary>
        public DateTime birthday { get; set;  }

        /// <summary>
        /// 
        /// </summary>
        public Passport Passport { get; set;  }

        /// <summary>
        /// 
        /// </summary>
        public BirhSertificate BirthSertificate { get; set;  }

        /// <summary>
        /// 
        /// </summary>
        public IAdress Adress { get; set;  }

        /// <summary>
        /// 
        /// </summary>
        public string Snils { get; set;  }

        /// <summary>
        /// 
        /// </summary>
        public string PhoneNumber { get; set; }
    }
}
