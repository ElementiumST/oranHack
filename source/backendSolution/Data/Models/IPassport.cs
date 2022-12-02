using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data.Models
{
    public interface IPassport
    {
        Guid Id { get; }

        int Series { get; }

        int Number { get; }

        DateTime DateOfGetting { get; }

        string IssueName { get; }

        bool IsRussianPasport { get; }

        DateTime DateOfEnding { get; }
    }
}
