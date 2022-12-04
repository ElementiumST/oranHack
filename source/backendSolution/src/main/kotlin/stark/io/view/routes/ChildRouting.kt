package stark.io.view.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import stark.io.data.repos.ChildRepos
import stark.io.view.model.ChildIdResponse
import stark.io.view.model.ChildRequest
import stark.io.view.plugins.AuthJWT
import stark.io.view.plugins.getParentId

fun Route.childRouting() {
    authenticate(AuthJWT) {
        put {
            runCatching {
                val childId = call.getParentId()
                call.respond(ChildIdResponse(childId))
            }.onFailure {
                call.application.environment.log.info(it.stackTraceToString())
            }
        }
    }
    patch {
        runCatching {
            val child = call.receive<ChildRequest>()
            ChildRepos.updateChild(child)
            call.respond(HttpStatusCode.NoContent)
        }.onFailure {
            call.application.environment.log.info(it.stackTraceToString())
        }
    }
    get("/{childId}") {
        runCatching {
            val childId = call.parameters["childId"]!!.toInt()
            val childRequest = ChildRepos.getChild(childId)
            call.respond(childRequest)
        }.onFailure {
            call.application.environment.log.info(it.stackTraceToString())
        }
    }
    authenticate(AuthJWT) {
        get("/byParent") {
            runCatching {
                val parentId = call.getParentId()
                val childList = ChildRepos.getChildsByParent(parentId)
                call.respond(childList)
            }.onFailure {
                call.application.environment.log.info(it.stackTraceToString())
            }
        }
    }
}