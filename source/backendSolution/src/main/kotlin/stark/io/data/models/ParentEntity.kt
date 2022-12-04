package stark.io.data.models

import org.jetbrains.exposed.sql.Table


data class ParentEntity(
    val id: Int,
    val firstName: String,
    val secondName: String,
    val lastName: String,
    val parentStatus: String,
    val citizenCountry: String,
    val birthday: String,
    val passportId: Int,
    val address: String,
    val snils: String,
    val phoneNumber: String,
    val email: String
)
object ParentTable: Table() {
    val id = integer("id").autoIncrement()
    val firstName = varchar("firstName", 60)
    val secondName = varchar("secondName", 60)
    val lastName = varchar("lastName", 60)
    val parentStatus = varchar("parentStatus", 60)
    val citizenCountry = varchar("citizenCountry", 60)
    val birthday = varchar("birthday", 20)
    val passportId = integer("passportId")
    val address = varchar("address", 240)
    val snils = varchar("snils", 20)
    val phoneNumber = varchar("phoneNumber", 20)
    val email = varchar("email", 60)

    override val primaryKey = PrimaryKey(ParentTable.id)
}
