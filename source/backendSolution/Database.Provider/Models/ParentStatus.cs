using Data.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Database.Provider.Models
{
    public class ParentStatus : IParentStatus
    {
        /// <summary>
        /// Идентифаикатор статуса родителя
        /// </summary>
        public Guid Id { get; set; }

        /// <summary>
        /// Наименование статуса родителя
        /// </summary>
        public string Name { get; set; }
    }
}
