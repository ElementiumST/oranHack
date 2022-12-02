using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data.Models
{
    public interface IBirthSertificate
    {
        /// <summary>
        /// 
        /// </summary>
        Guid Id { get; }

        /// <summary>
        /// 
        /// </summary>
        int Series { get; }

        /// <summary>
        /// 
        /// </summary>
        int Number { get; }

        /// <summary>
        /// 
        /// </summary>
        DateTime DateOfGetting { get; }

        /// <summary>
        /// 
        /// </summary>
        string IssueName { get; }

        /// <summary>
        /// 
        /// </summary>
        bool IsRussianPasport { get; }
    }
}
