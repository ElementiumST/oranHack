package stark.io.data.dao

import stark.io.data.models.BirthCertificateEntity
import stark.io.data.models.ParentEntity

interface DAOBirthCertificate {
    suspend fun getBirthCertificate(birthdayCertificateId: Int): BirthCertificateEntity

    suspend fun addBirthCertificate(
        isRussian: Boolean,
        series: String,
        number: String,
        dateOfGetting: String,
        issueName: String,
    ): BirthCertificateEntity?

    suspend fun editBirthCertificate(
        id: Int,
        isRussian: Boolean,
        series: String,
        number: String,
        dateOfGetting: String,
        issueName: String,
    ): Boolean
}