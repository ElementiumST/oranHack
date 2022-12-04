package stark.io.view.plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import stark.io.view.routes.authRouting
import stark.io.view.routes.campRouting
import stark.io.view.routes.childRouting
import stark.io.view.routes.parentRouting

fun Application.configureRouting() {

    routing {
        get { call.respond("recieved") }
        route("auth") {
            authRouting()
        }
        route("profile") {
            route("parent") {
                parentRouting()
            }
            route("child") {
                childRouting()
            }
        }
        route("camp") {
            campRouting()
        }
    }
}
