package stark.io.data.dao

import stark.io.data.models.CampEntity
import stark.io.data.models.ChildEntity

interface DAOCamp {
    suspend fun getCampById(campId: Int): CampEntity
    suspend fun getAcceptedCampList(): List<CampEntity>
    suspend fun getAwaitingCampList(): List<CampEntity>
    suspend fun getCampsBySeason(season: Int): List<CampEntity>
    suspend fun getCampsByOwner(ownerId: Int): List<CampEntity>

    suspend fun addCamp(
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
    ): CampEntity?

    suspend fun updateCamp(
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
    ): Boolean
}