package stark.io.data.dao

import stark.io.data.models.PassportEntity

interface DAOPassport {
    suspend fun getPassport(passportId: Int): PassportEntity

    suspend fun addPassport(
        series: String,
        number: String,
        dateOfGetting: String,
        issueName: String,
        isRussianPassport: Boolean
    ): PassportEntity?

    suspend fun editPassport(
        id: Int,
        series: String,
        number: String,
        dateOfGetting: String,
        issueName: String,
        isRussianPassport: Boolean
    ): Boolean
}