using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data.Models
{
    public interface IParentStatus
    {
        /// <summary>
        /// Идентифаикатор статуса родителя
        /// </summary>
        Guid Id { get; }

        /// <summary>
        /// Наименование статуса родителя
        /// </summary>
        string Name { get; }
    }
}
