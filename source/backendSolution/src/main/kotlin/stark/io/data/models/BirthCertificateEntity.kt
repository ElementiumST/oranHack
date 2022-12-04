package stark.io.data.models

import org.jetbrains.exposed.sql.Table
import stark.io.data.models.ParentTable.autoIncrement

data class BirthCertificateEntity(
    val id: Int,
    val isRussian: Boolean,
    val series: Int,
    val number: Int,
    val dateOfGetting: String,
    val issueName: String,
)
object BirthCertificateTable: Table() {
    val id = integer("id").autoIncrement()
    val isRussian = bool("isRussian")
    val series = integer("series")
    val number = integer("number")
    val dateOfGetting = varchar("dateOfGetting", 60)
    val issueName = varchar("issueName", 60)

    override val primaryKey = PrimaryKey(ParentTable.id)
}