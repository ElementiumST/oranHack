package stark.io.data.dao

import stark.io.data.models.UserEntity

interface DAOUser {

    suspend fun getUserByUsername(username: String): UserEntity?
    suspend fun getUserByRefresh(refreshToken: String): UserEntity?
    suspend fun getTypeByEmail(email: String): String
    suspend fun getUserIdByEmail(email: String): Int

    suspend fun updateRefreshToken(oldRefresh: String, newRefreshToken: String): Boolean
    suspend fun addNewUser(
        currentRefresh: String,
        username: String,
        password: String,
        userType: String
    ): UserEntity?

    suspend fun editUser(
        currentRefresh: String,
        username: String,
        password: String,
        userType: String
    ): Boolean
}