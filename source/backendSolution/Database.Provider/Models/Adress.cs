using Data.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Database.Provider.Models
{
    public class Adress : IAdress
    {
        /// <summary>
        /// Идентификатор адреса
        /// </summary>
        public Guid Id { get; set; }

        /// <summary>
        /// Индекс 
        /// </summary>
        public string Index { get; set; }

        /// <summary>
        /// Страна
        /// </summary>
        public string Country { get; set; }

        /// <summary>
        /// Регион
        /// </summary>
        public string Region { get; set; }

        /// <summary>
        /// Область
        /// </summary>
        public string District { get; set; }

        /// <summary>
        /// Город
        /// </summary>
        public string City { get; set; }

        /// <summary>
        /// Улица
        /// </summary>
        public string Street { get; set; }

        /// <summary>
        /// Номер дома
        /// </summary>
        public string NumberOfHouse { get; set; }

        /// <summary>
        /// Корпус
        /// </summary>
        public string Corpus { get; set; }

        /// <summary>
        /// Квартира
        /// </summary>
        public string Apartment { get; set; }
    }
}
