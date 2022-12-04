package stark.io.data.dao

import stark.io.data.models.ChildEntity
import stark.io.data.models.ParentEntity

interface DAOChild {
    suspend fun getChild(childId: Int): ChildEntity

    suspend fun getChildByParentId(parentId: Int): List<ChildEntity>
    suspend fun addChild(
        firstName: String,
        secondName: String,
        lastName: String,
        citizenCountry: String,
        birthday: String,
        passportId: Int,
        birthCertificateId: Int,
        address: String,
        snils: String,
        phoneNumber: String,
        parentId: Int
    ): ChildEntity?

    suspend fun editChild(
        id: Int,
        firstName: String,
        secondName: String,
        lastName: String,
        citizenCountry: String,
        birthday: String,
        passportId: Int,
        birthCertificateId: Int,
        address: String,
        snils: String,
        phoneNumber: String,
        parentId: Int
    ): Boolean

}