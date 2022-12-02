using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data.Models
{
    public interface IAdress
    {
        /// <summary>
        /// Идентификатор адреса
        /// </summary>
        Guid Id { get; }

        /// <summary>
        /// Индекс 
        /// </summary>
        string Index { get; }

        /// <summary>
        /// Страна
        /// </summary>
        string Country { get; }

        /// <summary>
        /// Регион
        /// </summary>
        string Region { get; }

        /// <summary>
        /// Область
        /// </summary>
        string District { get; }

        /// <summary>
        /// Город
        /// </summary>
        string City { get; }

        /// <summary>
        /// Улица
        /// </summary>
        string Street { get; }

        /// <summary>
        /// Номер дома
        /// </summary>
        string NumberOfHouse { get; }

        /// <summary>
        /// Корпус
        /// </summary>
        string Corpus { get; }

        /// <summary>
        /// Квартира
        /// </summary>
        string Apartment { get; }
    }
}
