using Data.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Database.Provider.Models
{
    public class Parent
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
        public ParentStatus ParentStatus { get; set;  }

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
        public Adress Adress { get; set;  }

        /// <summary>
        /// 
        /// </summary>
        public string Snils { get; set;  }

        /// <summary>
        /// 
        /// </summary>
        public string PhoneNumber { get; set;  }

        /// <summary>
        /// 
        /// </summary>
        public string Email { get; set;  }

        /// <summary>
        /// 
        /// </summary>
        public List<IChild> Children { get; set;  }
    }
}
