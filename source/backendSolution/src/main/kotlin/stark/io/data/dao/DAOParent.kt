package stark.io.data.dao

import stark.io.data.models.ParentEntity
import stark.io.data.models.PassportEntity

interface DAOParent {
    suspend fun getParent(parentId: Int): ParentEntity

    suspend fun getParentIdByEmail(email: String): Int
    suspend fun addParent(
        firstName: String,
        secondName: String,
        lastName: String,
        parentStatus: String,
        citizenCountry: String,
        birthday: String,
        passportId: Int,
        address: String,
        snils: String,
        phoneNumber: String,
        email: String
    ): ParentEntity?

    suspend fun editParent(
        id: Int,
        firstName: String,
        secondName: String,
        lastName: String,
        parentStatus: String,
        citizenCountry: String,
        birthday: String,
        passportId: Int,
        address: String,
        snils: String,
        phoneNumber: String,
        email: String
    ): Boolean
}