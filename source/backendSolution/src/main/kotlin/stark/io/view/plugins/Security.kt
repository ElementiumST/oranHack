package stark.io.view.plugins

import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import stark.io.data.repos.AuthRepos
import stark.io.data.repos.ParentRepos


fun Application.configureSecurity() {

    val secret = environment.config.property("jwt.secret").getString()
    val issuer = environment.config.property("jwt.issuer").getString()
    val audience = environment.config.property("jwt.audience").getString()
    val realm = environment.config.property("jwt.realm").getString()
    install(Authentication) {
        jwt("auth-jwt") {
            this.realm = realm
            verifier(
                JWT
                    .require(Algorithm.HMAC256(secret))
                    .withAudience(audience)
                    .withIssuer(issuer)
                    .build()
            )
            validate { credential ->
                if (!credential.payload.getClaim("username").asString().isNullOrEmpty()) {
                    JWTPrincipal(credential.payload)
                } else {
                    null
                }
            }
            challenge { defaultScheme, realm ->
                call.respond(HttpStatusCode.Unauthorized, "Token is not valid or has expired")
            }
        }
    }
}
fun ApplicationCall.getUsername(): String {
    return principal<JWTPrincipal>()!!.payload.getClaim("username").asString()
}
suspend fun ApplicationCall.getUserId(): Int {
    val userEmail = getUsername()
    return AuthRepos.getUserIdByEmail(userEmail)
}
suspend fun ApplicationCall.getParentId(): Int {
    val userEmail = getUsername()
    return ParentRepos.getParentIdByUsername(userEmail)
}
const val AuthJWT = "auth-jwt"
