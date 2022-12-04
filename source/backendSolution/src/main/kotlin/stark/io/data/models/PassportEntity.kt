package stark.io.data.models

import org.jetbrains.exposed.sql.Table


data class PassportEntity(
    val id: Int,
    val series: String,
    val number: String,
    val dateOfGetting: String,
    val issueName: String,
    val isRussianPassport: Boolean
)
object PassportTable: Table() {
    val id = integer("id").autoIncrement()
    val series = varchar("series", 60)
    val number = varchar("number", 60)
    val dateOfGetting = varchar("dateOfGetting", 20)
    val issueName = varchar("issueName", 120)
    val isRussianPassport = bool("isRussianPassport")

    override val primaryKey = PrimaryKey(UserTable.id)
}