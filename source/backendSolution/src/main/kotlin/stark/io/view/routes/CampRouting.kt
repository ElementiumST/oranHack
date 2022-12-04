package stark.io.view.routes

import com.auth0.jwt.JWT
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import stark.io.data.repos.CampRepos
import stark.io.data.repos.ChildRepos
import stark.io.view.model.CampRequest
import stark.io.view.model.ChildRequest
import stark.io.view.plugins.AuthJWT
import stark.io.view.plugins.getUserId
import stark.io.view.plugins.getUsername

fun Route.campRouting() {
    get("/{campId}") {
        runCatching {
            val campId = call.parameters["campId"]!!.toInt()
            val child = CampRepos.getCampById(campId)
            call.respond(child)
        }.onFailure {
            call.application.environment.log.info(it.stackTraceToString())
        }
    }
    get("/accepted") {
        runCatching {
            val campList = CampRepos.getAcceptedCampList()
            call.respond(campList)
        }.onFailure {
            call.application.environment.log.info(it.stackTraceToString())
        }
    }
    get("/awaiting") {
        runCatching {
            val campList = CampRepos.getAwaitingCampList()
            call.respond(campList)
        }.onFailure {
            call.application.environment.log.info(it.stackTraceToString())
        }
    }
    get("/season/{id}") {
        runCatching {
            val season = call.parameters["id"]?.toInt()!!
            val campList = CampRepos.getCampBySeason(season)
            call.respond(campList)
        }.onFailure {
            call.application.environment.log.info(it.stackTraceToString())
        }
    }
    authenticate(AuthJWT) {
        put() {
            runCatching {
                val camp = call.receive<CampRequest>()
                val userId = call.getUserId()
                CampRepos.addCamp(camp, userId)
                call.respond(HttpStatusCode.OK)
            }.onFailure {
                call.application.environment.log.info(it.stackTraceToString())
            }
        }
    }
    authenticate(AuthJWT) {
        patch() {
            runCatching {
                val camp = call.receive<CampRequest>()
                val userId = call.getUserId()
                CampRepos.updateCamp(camp, userId)
                call.respond(HttpStatusCode.OK)
            }.onFailure {
                call.application.environment.log.info(it.stackTraceToString())
            }
        }
    }
}