package stark.io.data.dao

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.update
import stark.io.data.DatabaseFactory
import stark.io.data.models.BirthCertificateEntity
import stark.io.data.models.BirthCertificateTable
import stark.io.data.models.ParentTable

class DAOBirthCertificateImpl : DAOBirthCertificate {
    private fun parseToBirthCertificate(row: ResultRow) = BirthCertificateEntity(
        row[BirthCertificateTable.id],
        row[BirthCertificateTable.isRussian],
        row[BirthCertificateTable.series],
        row[BirthCertificateTable.number],
        row[BirthCertificateTable.dateOfGetting],
        row[BirthCertificateTable.issueName],
    )
    private fun ResultRow.toBirthdayCertificate() = parseToBirthCertificate(this)

    override suspend fun getBirthCertificate(birthdayCertificateId: Int): BirthCertificateEntity = DatabaseFactory.dbQuery {
        BirthCertificateTable.select {
            BirthCertificateTable.id.eq(birthdayCertificateId)
        }.first().toBirthdayCertificate()
    }

    override suspend fun addBirthCertificate(
        isRussian: Boolean,
        series: String,
        number: String,
        dateOfGetting: String,
        issueName: String
    ): BirthCertificateEntity? = DatabaseFactory.dbQuery {
        val insertState = BirthCertificateTable.insert {
            it[BirthCertificateTable.isRussian] = isRussian
            it[BirthCertificateTable.series] = series
            it[BirthCertificateTable.number] = number
            it[BirthCertificateTable.dateOfGetting] = dateOfGetting
            it[BirthCertificateTable.issueName] = issueName
        }
        insertState.resultedValues?.singleOrNull()?.toBirthdayCertificate()
    }

    override suspend fun editBirthCertificate(
        id: Int,
        isRussian: Boolean,
        series: String,
        number: String,
        dateOfGetting: String,
        issueName: String
    ): Boolean = DatabaseFactory.dbQuery{
        BirthCertificateTable.update({BirthCertificateTable.id.eq(id)}) {
            it[BirthCertificateTable.id] = id
            it[BirthCertificateTable.isRussian] = isRussian
            it[BirthCertificateTable.series] = series
            it[BirthCertificateTable.number] = number
            it[BirthCertificateTable.dateOfGetting] = dateOfGetting
            it[BirthCertificateTable.issueName] = issueName
        } > 0
    }
}