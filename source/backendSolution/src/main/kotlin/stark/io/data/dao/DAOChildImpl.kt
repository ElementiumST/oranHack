package stark.io.data.dao

import kotlinx.coroutines.selects.select
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.update
import stark.io.data.DatabaseFactory
import stark.io.data.models.ChildEntity
import stark.io.data.models.ChildTable
import stark.io.data.models.ParentEntity
import stark.io.data.models.ParentTable

class DAOChildImpl : DAOChild {
    private fun parseToChild(row: ResultRow) = ChildEntity(
        row[ChildTable.id],
        row[ChildTable.firstName],
        row[ChildTable.secondName],
        row[ChildTable.lastName],
        row[ChildTable.citizenCountry],
        row[ChildTable.birthday],
        row[ChildTable.passportId],
        row[ChildTable.birthCertificateId],
        row[ChildTable.address],
        row[ChildTable.snils],
        row[ChildTable.phoneNumber],
        row[ChildTable.parentId],
    )
    private fun ResultRow.toChild() = parseToChild(this)

    override suspend fun getChild(childId: Int): ChildEntity = DatabaseFactory.dbQuery{
        ChildTable.select {
            ChildTable.id.eq(childId)
        }.first().toChild()
    }

    override suspend fun getChildByParentId(parentId: Int): List<ChildEntity> = DatabaseFactory.dbQuery {
        ChildTable.select { ChildTable.parentId.eq(parentId) }.map(::parseToChild)
    }

    override suspend fun addChild(
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
    ): ChildEntity? = DatabaseFactory.dbQuery {
        val insertState = ChildTable.insert {
            it[ChildTable.firstName] = firstName
            it[ChildTable.secondName] = secondName
            it[ChildTable.lastName] = lastName
            it[ChildTable.citizenCountry] = citizenCountry
            it[ChildTable.birthday] = birthday
            it[ChildTable.passportId] = passportId
            it[ChildTable.birthCertificateId] = birthCertificateId
            it[ChildTable.address] = address
            it[ChildTable.snils] = snils
            it[ChildTable.phoneNumber] = phoneNumber
            it[ChildTable.parentId] = parentId
        }
        insertState.resultedValues?.singleOrNull()?.toChild()

    }

    override suspend fun editChild(
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
    ): Boolean = DatabaseFactory.dbQuery {
        ChildTable.update ({ChildTable.id.eq(id)}) {
            it[ChildTable.firstName] = firstName
            it[ChildTable.secondName] = secondName
            it[ChildTable.lastName] = lastName
            it[ChildTable.citizenCountry] = citizenCountry
            it[ChildTable.birthday] = birthday
            it[ChildTable.passportId] = passportId
            it[ChildTable.birthCertificateId] = birthCertificateId
            it[ChildTable.address] = address
            it[ChildTable.snils] = snils
            it[ChildTable.phoneNumber] = phoneNumber
            it[ChildTable.parentId] = parentId
        } > 0
    }
}