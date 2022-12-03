using Database.Provider.Models;
using System.Threading.Tasks;
using System.Threading;

namespace OnlineHackathon.Models.Authentication
{
    public interface IJwtAccessTokenFactory
    {
        Task<AccessToken> Create(Person person, CancellationToken cancellationToken);
    }
}
