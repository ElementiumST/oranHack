package stark.io.data.repos

import stark.io.data.dao.DAOSource
import stark.io.data.models.CampEntity
import stark.io.view.model.CampRequest

object CampRepos {
    suspend fun getCampById(campId: Int): CampRequest {
        return DAOSource.campDAO.getCampById(campId).toCampRequest()
    }
    suspend fun getAcceptedCampList(): List<CampRequest> {
        return DAOSource.campDAO.getAcceptedCampList().map { it.toCampRequest() }
    }
    suspend fun getAwaitingCampList(): List<CampRequest> {
        return DAOSource.campDAO.getAwaitingCampList().map { it.toCampRequest() }
    }
    suspend fun getCampBySeason(season: Int): List<CampRequest> {
        return DAOSource.campDAO.getCampsBySeason(season).map { it.toCampRequest() }
    }
    suspend fun addCamp(campRequest: CampRequest, ownerId: Int) {
        DAOSource.campDAO.addCamp(
            campRequest.name,
            campRequest.description,
            campRequest.season,
            campRequest.type,
            campRequest.phone,
            campRequest.address,
            campRequest.space,
            campRequest.corpuses,
            campRequest.dayOfStart,
            campRequest.dayOfEnd,
            ownerId
        )
    }
    suspend fun updateCamp(campRequest: CampRequest, ownerId: Int) {
        if (campRequest.status !in 0..2) throw IllegalArgumentException()
        DAOSource.campDAO.updateCamp(
            campRequest.id!!,
            campRequest.name,
            campRequest.description,
            campRequest.season,
            campRequest.type,
            campRequest.phone,
            campRequest.address,
            campRequest.space,
            campRequest.corpuses,
            campRequest.dayOfStart,
            campRequest.dayOfEnd,
            ownerId,
            campRequest.status!!
        )
    }

    private fun CampEntity.toCampRequest(): CampRequest {
        return CampRequest(
            id,
            name,
            description,
            season,
            type,
            phone,
            address,
            space,
            corpuses,
            dayOfStart,
            dayOfEnd,
            status
        )
    }
}