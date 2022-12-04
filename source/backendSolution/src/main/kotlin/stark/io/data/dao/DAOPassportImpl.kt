package stark.io.data.dao

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.update
import stark.io.data.DatabaseFactory
import stark.io.data.models.PassportEntity
import stark.io.data.models.PassportTable


class DAOPassportImpl: DAOPassport {

    private fun parseToPassport(row: ResultRow) = PassportEntity(
        row[PassportTable.id],
        row[PassportTable.series],
        row[PassportTable.number],
        row[PassportTable.dateOfGetting],
        row[PassportTable.issueName],
        row[PassportTable.isRussianPassport],
    )
    private fun ResultRow.toPassport() = parseToPassport(this)

    override suspend fun getPassport(passportId: Int): PassportEntity = DatabaseFactory.dbQuery {
        PassportTable.select {
            PassportTable.id.eq(passportId)
        }.first().toPassport()
    }

    override suspend fun addPassport(
        series: String,
        number: String,
        dateOfGetting: String,
        issueName: String,
        isRussianPassport: Boolean
    ) : PassportEntity? = DatabaseFactory.dbQuery {
        val insertState = PassportTable.insert {
            it[PassportTable.series] = series
            it[PassportTable.number] = number
            it[PassportTable.dateOfGetting] = dateOfGetting
            it[PassportTable.issueName] = issueName
            it[PassportTable.isRussianPassport] = isRussianPassport
        }
        insertState.resultedValues?.singleOrNull()?.toPassport()
    }

    override suspend fun editPassport(
        id: Int,
        series: String,
        number: String,
        dateOfGetting: String,
        issueName: String,
        isRussianPassport: Boolean
    ): Boolean  = DatabaseFactory.dbQuery  {
        PassportTable.update({PassportTable.id.eq(id)}) {
            it[PassportTable.series] = series
            it[PassportTable.number] = number
            it[PassportTable.dateOfGetting] = dateOfGetting
            it[PassportTable.issueName] = issueName
            it[PassportTable.isRussianPassport] = isRussianPassport
        } > 0
    }
}