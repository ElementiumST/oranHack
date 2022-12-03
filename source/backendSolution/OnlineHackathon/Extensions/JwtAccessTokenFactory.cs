using Azure.Core;
using Database.Provider.Models;
using Microsoft.Extensions.Options;
using Microsoft.IdentityModel.Tokens;
using System.Collections.Generic;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;
using System.Threading.Tasks;
using System.Threading;
using System;
using OnlineHackathon.Models.Authentication;

namespace OnlineHackathon.Extensions
{
    public sealed class JwtAccessTokenFactory : IJwtAccessTokenFactory
    {
        private readonly JwtAuthPersonOptions _authPersonOptions;

        public JwtAccessTokenFactory(IOptions<JwtAuthPersonOptions> personOptions)
        {
            _authPersonOptions = personOptions.Value;
        }

        public Task<AccessToken> Create(Person person, CancellationToken cancellationToken)
        {
            var jwtSecurityToken = new JwtSecurityToken(
                _authPersonOptions.Issuer,
                _authPersonOptions.Audience,
                new ClaimsIdentity(new List<Claim>
                {
                    new Claim(ClaimTypes.NameIdentifier, person.Id.ToString()),
                    new Claim(ClaimTypes.Name, person.FirstName),
                    new Claim(ClaimTypes.Surname, person.LastName),
                    new Claim(ClaimTypes.StreetAddress, person.Address),
                    new Claim(ClaimTypes.Email, person.Email),
                    new Claim(ClaimTypes.Role, "person")
                }, "Token", ClaimsIdentity.DefaultNameClaimType, ClaimsIdentity.DefaultRoleClaimType).Claims,
                DateTime.UtcNow,
                DateTime.UtcNow.AddDays(1),
                new SigningCredentials(new SymmetricSecurityKey(Encoding.UTF8.GetBytes(_authPersonOptions.SecretKey)), SecurityAlgorithms.HmacSha256));

            var token = new JwtSecurityTokenHandler().WriteToken(jwtSecurityToken);

            return Task.FromResult(new AccessToken(token, new DateTimeOffset(1,TimeSpan.FromDays(1))));
        }
    }
}
