package stark.io.data.repos

import io.ktor.server.plugins.*
import stark.io.data.dao.DAOSource
import stark.io.data.models.UserEntity
import stark.io.domain.model.UserDomainBean
import stark.io.domain.model.UserAuthSet
import stark.io.domain.model.UserType
import stark.io.view.model.SignUpRequest
import java.util.UUID

object AuthRepos {
    suspend fun getUserByRefresh(refreshToken: String): UserDomainBean {
        val userEntity = DAOSource.userDAO.getUserByRefresh(refreshToken) ?: throw NotFoundException()
        return UserDomainBean(userEntity.username, UserType.fromString(userEntity.userType), userEntity.updateRefreshToken())
    }

    suspend fun getUserIdByEmail(email: String): Int {
        return DAOSource.userDAO.getUserIdByEmail(email)
    }
    suspend fun getTypeByEmail(email: String): UserType {
        return UserType.fromString(DAOSource.userDAO.getTypeByEmail(email))
    }

    suspend fun getUser(userAuthSet: UserAuthSet): UserDomainBean {
        val userEntity = DAOSource.userDAO.getUserByUsername(userAuthSet.username)  ?: throw NotFoundException()
        if (userEntity.password != userAuthSet.password) throw IllegalArgumentException()
        return UserDomainBean(userEntity.username, UserType.fromString(userEntity.userType), userEntity.updateRefreshToken())
    }

    suspend fun registerNewUser(signUpRequest: SignUpRequest): UserDomainBean {
        runCatching { DAOSource.userDAO.getUserByUsername(signUpRequest.email) }.onSuccess { throw IllegalArgumentException() }
        val userEntity = DAOSource.userDAO.addNewUser(
            UUID.randomUUID().toString(),
            signUpRequest.email,
            signUpRequest.password,
            (if (signUpRequest.isOrganization) UserType.Organization else UserType.Parent).name
        ) ?: throw IllegalStateException()
        return UserDomainBean(
            signUpRequest.email,
            UserType.fromString(userEntity.userType),
            userEntity.currentRefresh!!
        )
    }

    private suspend fun UserEntity.updateRefreshToken(): String {
        val newRefresh = UUID.randomUUID().toString()
        if (!DAOSource.userDAO.updateRefreshToken(currentRefresh!!, newRefresh)) throw NotFoundException()
        return newRefresh
    }
}