package stark.io.data.dao

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.update
import stark.io.data.DatabaseFactory
import stark.io.data.models.CampEntity
import stark.io.data.models.CampEntity.Companion.ACCEPTED
import stark.io.data.models.CampEntity.Companion.AWAIT
import stark.io.data.models.CampTable
import stark.io.data.models.ChildEntity
import stark.io.data.models.ChildTable

class DAOCampImpl : DAOCamp {
    private fun parseToCamp(row: ResultRow) = CampEntity(
        row[CampTable.id],
        row[CampTable.name],
        row[CampTable.description],
        row[CampTable.season],
        row[CampTable.type],
        row[CampTable.phone],
        row[CampTable.address],
        row[CampTable.space],
        row[CampTable.corpuses],
        row[CampTable.dayOfStart],
        row[CampTable.dayOfEnd],
        row[CampTable.ownerId],
        row[CampTable.status],
    )
    private fun ResultRow.toCamp() = parseToCamp(this)

    override suspend fun getCampById(campId: Int): CampEntity = DatabaseFactory.dbQuery {
        CampTable.select {
            CampTable.id.eq(campId)
        }.first().toCamp()
    }

    override suspend fun getAcceptedCampList(): List<CampEntity> = DatabaseFactory.dbQuery{
        CampTable.select {
            CampTable.status.eq(ACCEPTED)
        }.map(::parseToCamp)
    }

    override suspend fun getAwaitingCampList(): List<CampEntity> = DatabaseFactory.dbQuery{
        CampTable.select {
            CampTable.status.eq(AWAIT)
        }.map(::parseToCamp)
    }

    override suspend fun getCampsBySeason(season: Int): List<CampEntity> = DatabaseFactory.dbQuery{
        CampTable.select {
            CampTable.season.eq(season)
        }.map(::parseToCamp)
    }

    override suspend fun getCampsByOwner(ownerId: Int): List<CampEntity> = DatabaseFactory.dbQuery{
        CampTable.select {
            CampTable.ownerId.eq(ownerId)
        }.map(::parseToCamp)
    }

    override suspend fun addCamp(
        name: String,
        description: String,
        season: Int,
        type: String,
        phone: String,
        address: String,
        space: String,
        corpuses: String,
        dayOfStart: String,
        dayOfEnd: String,
        ownerId: Int
    ): CampEntity? = DatabaseFactory.dbQuery{
        val insertState = CampTable.insert {
            it[CampTable.name] = name
            it[CampTable.description] = description
            it[CampTable.season] = season
            it[CampTable.type] = type
            it[CampTable.phone] = phone
            it[CampTable.address] = address
            it[CampTable.space] = space
            it[CampTable.corpuses] = corpuses
            it[CampTable.dayOfStart] = dayOfStart
            it[CampTable.dayOfEnd] = dayOfEnd
            it[CampTable.ownerId] = ownerId
            it[status] = AWAIT
        }
        insertState.resultedValues?.singleOrNull()?.toCamp()
    }

    override suspend fun updateCamp(
        id: Int,
        name: String,
        description: String,
        season: Int,
        type: String,
        phone: String,
        address: String,
        space: String,
        corpuses: String,
        dayOfStart: String,
        dayOfEnd: String,
        ownerId: Int,
        status: Int
    ): Boolean = DatabaseFactory.dbQuery{
        CampTable.update({CampTable.id.eq(id)}) {
            it[CampTable.name] = name
            it[CampTable.description] = description
            it[CampTable.season] = season
            it[CampTable.type] = type
            it[CampTable.phone] = phone
            it[CampTable.address] = address
            it[CampTable.space] = space
            it[CampTable.corpuses] = corpuses
            it[CampTable.dayOfStart] = dayOfStart
            it[CampTable.dayOfEnd] = dayOfEnd
            it[CampTable.ownerId] = ownerId
            it[CampTable.status] = CampTable.status
        } > 0
    }
}