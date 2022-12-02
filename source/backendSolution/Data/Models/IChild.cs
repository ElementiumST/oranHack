using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data.Models
{
    public interface IChild
    {
        /// <summary>
        /// 
        /// </summary>
        Guid Id { get; }

        /// <summary>
        /// 
        /// </summary>
        string FirstName { get; }

        /// <summary>
        /// 
        /// </summary>
        string MiddleName { get; }

        /// <summary>
        /// 
        /// </summary>
        string LastName { get; }

        /// <summary>
        /// 
        /// </summary>
        string CitizenCountry { get; }

        /// <summary>
        /// 
        /// </summary>
        DateTime birthday { get; }

        /// <summary>
        /// 
        /// </summary>
        IPassport Passport { get; }

        /// <summary>
        /// 
        /// </summary>
        IBirthSertificate BirthSertificate { get; }

        /// <summary>
        /// 
        /// </summary>
        IAdress Adress { get; }

        /// <summary>
        /// 
        /// </summary>
        string Snils { get; }

        /// <summary>
        /// 
        /// </summary>
        string PhoneNumber { get; }

    }
}
