package stark.io.data.models

import org.jetbrains.exposed.sql.Table

data class CampEntity(
    val id: Int,
    val name: String,
    val description: String,
    val season: Int,
    val type: String,
    val phone: String,
    val address: String,
    val space: String,
    val corpuses: String,
    val dayOfStart: String,
    val dayOfEnd: String,
    val ownerId: Int,
    val status: Int
) {
    companion object {
        const val WINTER = 0
        const val SPRING = 1
        const val SUMMER = 2
        const val AUTUMN = 3

        const val AWAIT = 0
        const val ACCEPTED = 1
        const val REJECTED = 2
    }
}
object CampTable: Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 120)
    val description = varchar("description", 2000)
    val season = integer("season")
    val type = varchar("type", 60)
    val phone = varchar("phone", 40)
    val address = varchar("address", 240)
    val space = varchar("space", 60)
    val corpuses = varchar("corpuses", 60)
    val dayOfStart = varchar("dayOfStart", 20)
    val dayOfEnd = varchar("dayOfEnd", 20)
    val ownerId = integer("ownerId")
    val status = integer("status")
}
