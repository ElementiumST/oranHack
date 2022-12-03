using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Database.Provider.Models
{
    public class Person
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
        public string MiddleName { get; set; }

        /// <summary>
        /// 
        /// </summary>
        public string LastName { get; set; }

        public string Login { get; set; }

        public string Password { get; set; }

        /// <summary>
        /// 
        /// </summary>
        public string CitizenCountry { get; set; }

        public string Address { get; set; }

        /// <summary>
        /// 
        /// </summary>
        public DateTime birthday { get; set; }

        /// <summary>
        /// 
        /// </summary>
        public string Snils { get; set; }

        /// <summary>
        /// 
        /// </summary>
        public string PhoneNumber { get; set; }

        /// <summary>
        /// 
        /// </summary>
        public ParentStatus ParentStatus { get; set; }

        /// <summary>
        /// 
        /// </summary>
        public string Email { get; set; }

        /// <summary>
        /// 
        /// </summary>
        public BirhSertificate BirthSertificate { get; set; }

        public Passport Passport { get; set; }  
    }
}
