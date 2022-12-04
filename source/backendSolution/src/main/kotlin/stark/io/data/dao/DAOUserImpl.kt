package stark.io.data.dao

import org.jetbrains.exposed.sql.*
import stark.io.data.DatabaseFactory
import stark.io.data.models.UserEntity
import stark.io.data.models.UserTable

class DAOUserImpl: DAOUser {
    private fun parseToUser(row: ResultRow) = UserEntity(
        row[UserTable.id],
        row[UserTable.currentRefresh],
        row[UserTable.username],
        row[UserTable.password],
        row[UserTable.userType],
    )
    private fun ResultRow.toUser() = parseToUser(this)


//    override suspend fun allUsers(): List<UserEntity> = DatabaseFactory.dbQuery {
//        UserTable.selectAll().map(::parseToUser)
//    }

    override suspend fun getUserByUsername(username: String): UserEntity?  = DatabaseFactory.dbQuery {
        UserTable.select { UserTable.username.eq(username) }.first().toUser()
    }

    override suspend fun getUserByRefresh(refreshToken: String): UserEntity? = DatabaseFactory.dbQuery {
        UserTable.select { UserTable.currentRefresh.eq(refreshToken) }.first().toUser()
    }

    override suspend fun getTypeByEmail(email: String): String = DatabaseFactory.dbQuery{
        UserTable.select { UserTable.username.eq(email) }.first().toUser().userType
    }

    override suspend fun getUserIdByEmail(email: String): Int = DatabaseFactory.dbQuery{
        UserTable.select { UserTable.username.eq(email) }.first().toUser().id
    }

    override suspend fun updateRefreshToken(oldRefresh: String, newRefreshToken: String,): Boolean = DatabaseFactory.dbQuery {
        UserTable.update({ UserTable.currentRefresh.eq(oldRefresh) }) {
            it[currentRefresh] = newRefreshToken
        } > 0
    }

    override suspend fun addNewUser(currentRefresh: String, username: String, password: String, userType: String): UserEntity? = DatabaseFactory.dbQuery {
        val insertState = UserTable.insert {
            it[UserTable.currentRefresh] = currentRefresh
            it[UserTable.username] = username
            it[UserTable.password] = password
            it[UserTable.userType] = userType
        }
        insertState.resultedValues?.singleOrNull()?.toUser()
    }

    override suspend fun editUser(
        currentRefresh: String,
        username: String,
        password: String,
        userType: String
    ): Boolean = TODO()

}