using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using OnlineHackathon.Bindings;
using System.Threading.Tasks;
using System.Threading;
using Database.Provider.Context;
using OnlineHackathon.Models.Authentication;
using OnlineHackathon.Views;

namespace OnlineHackathon.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class AuthController : ControllerBase
    {
        private readonly FirstHackathonDbContext _context;
        private readonly IJwtAccessTokenFactory _jwt;
        public AuthController(
           FirstHackathonDbContext context,
           IJwtAccessTokenFactory jwt)
        {
            _context = context;
            _jwt = jwt;
        }
        /// <summary>
        /// Person authentication by login and password
        /// </summary>
        /// <param name="binding">Input model</param>
        /// <response code="200">Successfully</response>
        /// <response code="401">Invalid authorization code</response>
        [AllowAnonymous]
        [HttpPost("person/login")]
        [ProducesResponseType(typeof(TokenView), 200)]
        [ProducesResponseType(401)]
        public async Task<ActionResult<TokenView>> PersonAuthentication(
            CancellationToken cancellationToken,
            [FromBody] AuthenticationBinding binding)
        {
            var person = await _context.Persons
                .SingleOrDefaultAsync(o => o.Login == binding.Login && o.Password == binding.Password, cancellationToken);

            if (person != null)
            {
                var token = await _jwt.Create(person, cancellationToken);
                return new TokenView { AccessToken = token.Value };
            }
            else
            {
                return Unauthorized();
            }
        }
    }
}
