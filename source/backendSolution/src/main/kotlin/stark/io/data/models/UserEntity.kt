package stark.io.data.models

import org.jetbrains.exposed.sql.Table


data class UserEntity(
    val id: Int,
    val currentRefresh: String?,
    val username: String,
    val password: String,
    val userType: String,
)

object UserTable: Table() {
    val id = integer("id").autoIncrement()
    val currentRefresh = varchar("refreshToken", 256)
    val username = varchar("username", 64)
    val password = varchar("password", 64)
    val userType = varchar("userType", 64)

    override val primaryKey = PrimaryKey(id)
}
