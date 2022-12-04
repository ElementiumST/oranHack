package stark.io.view.routes

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import stark.io.view.model.TokenRequest
import stark.io.view.model.TokenResponse
import stark.io.domain.model.UserDomainBean
import stark.io.domain.model.UserAuthSet
import stark.io.data.repos.AuthRepos
import stark.io.data.repos.AuthRepos.registerNewUser
import stark.io.view.model.SignUpRequest
import java.lang.IllegalStateException
import java.util.*
import kotlin.math.log

fun Route.authRouting() {
    val secret = environment!!.config.property("jwt.secret").getString()
    val issuer = environment!!.config.property("jwt.issuer").getString()
    val audience = environment!!.config.property("jwt.audience").getString()

    val generateTokenResponse: (userDomainBean: UserDomainBean) -> TokenResponse = {
        val jwt = JWT.create()
            .withAudience(audience)
            .withIssuer(issuer)
            .withClaim("username", it.username)
            .withExpiresAt(Date(System.currentTimeMillis() + 86_400_000))
            .sign(Algorithm.HMAC256(secret))
        TokenResponse(
            it.refreshToken,
            jwt,
            it.userType.name
        )
    }


    post("signUp") {
        runCatching {
            val signUpRequest = call.receive<SignUpRequest>()
            val user = registerNewUser(signUpRequest)

            call.respond(
                generateTokenResponse(user)
            )
        }.onFailure { throwable ->
            call.application.environment.log.info(throwable.stackTraceToString())
            call.respond(HttpStatusCode.BadRequest)
        }
    }
    post {
       runCatching {
       val tokenRequest = call.receive<TokenRequest>()

           val user = when (tokenRequest.grantType) {
               "refresh" -> {
                   AuthRepos.getUserByRefresh(tokenRequest.refreshToken!!)
               }
               "signin" -> {
                   AuthRepos.getUser(
                       UserAuthSet(
                           tokenRequest.username!!,
                           tokenRequest.password!!
                       )
                   )
               }
               else -> {
                   throw IllegalStateException()
               }
           }
           call.respond(
               generateTokenResponse(user)
           )
       }.onFailure {
           call.application.environment.log.info(it.stackTraceToString())
           call.respond(HttpStatusCode.BadRequest)
       }
   }

}