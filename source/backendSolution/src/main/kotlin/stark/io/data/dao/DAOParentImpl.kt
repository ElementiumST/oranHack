package stark.io.data.dao

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.update
import stark.io.data.DatabaseFactory
import stark.io.data.models.ParentEntity
import stark.io.data.models.ParentTable
import stark.io.data.models.PassportEntity
import stark.io.data.models.PassportTable

class DAOParentImpl: DAOParent {
    private fun parseToParent(row: ResultRow) = ParentEntity(
        row[ParentTable.id],
        row[ParentTable.firstName],
        row[ParentTable.secondName],
        row[ParentTable.lastName],
        row[ParentTable.parentStatus],
        row[ParentTable.citizenCountry],
        row[ParentTable.birthday],
        row[ParentTable.passportId],
        row[ParentTable.address],
        row[ParentTable.snils],
        row[ParentTable.phoneNumber],
        row[ParentTable.email],
    )
    private fun ResultRow.toParent() = parseToParent(this)

    override suspend fun getParent(parentId: Int): ParentEntity = DatabaseFactory.dbQuery {
        ParentTable.select {
            ParentTable.id.eq(parentId)
        }.first().toParent()
    }

    override suspend fun getParentIdByEmail(email: String): Int = DatabaseFactory.dbQuery  {
        ParentTable.select {
            ParentTable.email.eq(email)
        }.first().toParent().id
    }

    override suspend fun addParent(
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
    ): ParentEntity? = DatabaseFactory.dbQuery{
        val insertState = ParentTable.insert {
            it[ParentTable.firstName] = firstName
            it[ParentTable.secondName] = secondName
            it[ParentTable.lastName] = lastName
            it[ParentTable.parentStatus] = parentStatus
            it[ParentTable.citizenCountry] = citizenCountry
            it[ParentTable.birthday] = birthday
            it[ParentTable.passportId] = passportId
            it[ParentTable.address] = address
            it[ParentTable.snils] = snils
            it[ParentTable.phoneNumber] = phoneNumber
            it[ParentTable.email] = email
        }
        insertState.resultedValues?.singleOrNull()?.toParent()
    }

    override suspend fun editParent(
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
    ): Boolean = DatabaseFactory.dbQuery {
        ParentTable.update ({ ParentTable.id.eq(id) }) {
            it[ParentTable.firstName] = firstName
            it[ParentTable.secondName] = secondName
            it[ParentTable.lastName] = lastName
            it[ParentTable.parentStatus] = parentStatus
            it[ParentTable.citizenCountry] = citizenCountry
            it[ParentTable.birthday] = birthday
            it[ParentTable.passportId] = passportId
            it[ParentTable.address] = address
            it[ParentTable.snils] = snils
            it[ParentTable.phoneNumber] = phoneNumber
            it[ParentTable.email] = email
        } > 0
    }
}