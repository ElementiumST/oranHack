package stark.io

import io.ktor.client.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import io.ktor.util.pipeline.*
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import stark.io.data.DatabaseFactory
import stark.io.data.models.*
import stark.io.view.plugins.configureHTTP
import stark.io.view.plugins.configureRouting
import stark.io.view.plugins.configureSecurity
import stark.io.view.plugins.configureSerialization

fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
    DatabaseFactory.init()
    initTables()
    configureSecurity()

    configureHTTP()
    configureSerialization()
    configureRouting()
}
fun initTables() {
    transaction {
        SchemaUtils.create(
            UserTable,
            PassportTable,
            ParentTable,
            BirthCertificateTable,
            ChildTable,
            CampTable,
        )
    }
}