using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Database.Provider.Models
{
    public class ParentsChildren
    {
        public Guid Id { get; set; }

        public Guid ParentId { get; set; }

        public Guid ChildId { get;set; }
    }
}
