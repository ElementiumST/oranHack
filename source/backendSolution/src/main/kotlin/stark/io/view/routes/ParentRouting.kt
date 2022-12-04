package stark.io.view.routes

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import stark.io.data.repos.ParentRepos
import stark.io.view.model.ParentIdResponse
import stark.io.view.model.ParentRequest
import stark.io.view.plugins.AuthJWT
import stark.io.view.plugins.getParentId
import stark.io.view.plugins.getUsername

fun Route.parentRouting() {
    authenticate(AuthJWT) {
        put {
            runCatching {
                val parent = call.receive<ParentRequest>()
                parent.email = call.getUsername()
                val parentId = ParentRepos.createParent(parent)
                call.respond(ParentIdResponse(parentId))
            }.onFailure {
                call.application.environment.log.info(it.stackTraceToString())
            }

        }
    }
    authenticate(AuthJWT) {
        get {
            runCatching {
                val parentId = call.getParentId()
                val parentRequest = ParentRepos.getParent(parentId)
                call.respond(parentRequest)
            }.onFailure {
                call.application.environment.log.info(it.stackTraceToString())
            }
        }
    }

}