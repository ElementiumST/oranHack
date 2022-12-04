package stark.io.data.repos

import stark.io.data.dao.DAOSource
import stark.io.view.model.ParentRequest
import stark.io.view.model.PassportRequest
import java.lang.IllegalStateException

object ParentRepos {
    suspend fun createParent(parentRequest: ParentRequest): Int {
        runCatching { DAOSource.parentDAO.getParentIdByEmail(parentRequest.email) }
            .onSuccess {
                changeParent(it, parentRequest)
                return it;
            }
        val passportEntity = DAOSource.passportDAO.addPassport(
            parentRequest.passport.series.toString(),
            parentRequest.passport.number.toString(),
            parentRequest.passport.dateOfGetting,
            parentRequest.passport.issueName,
            parentRequest.passport.isRussianPassport,
        ) ?: throw IllegalStateException()
        val fio = parentRequest.fio.split(" ")
        val parentEntity = DAOSource.parentDAO.addParent(
            fio[0],
            fio[1],
            fio[2],
            parentRequest.parentStatus,
            parentRequest.citizenCountry,
            parentRequest.birthday,
            passportEntity.id,
            parentRequest.address,
            parentRequest.snils,
            parentRequest.phoneNumber,
            parentRequest.email,
        )
        return parentEntity!!.id
    }
    suspend fun getParentIdByUsername(username: String): Int {
        return DAOSource.parentDAO.getParentIdByEmail(username)
    }
    suspend fun changeParent(parentId: Int, parentRequest: ParentRequest) {
        val oldParent = DAOSource.parentDAO.getParent(parentId)
        val oldPassport = DAOSource.passportDAO.getPassport(oldParent.id)
        val fio = parentRequest.fio.split(" ")
        DAOSource.parentDAO.editParent(
            parentId,
            fio[0],
            fio[1],
            fio[2],
            parentRequest.parentStatus,
            parentRequest.citizenCountry,
            parentRequest.birthday ,
            oldParent.passportId,
            parentRequest.address,
            parentRequest.snils,
            parentRequest.phoneNumber,
            parentRequest.email,
        )
        DAOSource.passportDAO.editPassport(
            oldPassport.id,
            parentRequest.passport.series.toString(),
            parentRequest.passport.number.toString(),
            parentRequest.passport.dateOfGetting,
            parentRequest.passport.issueName,
            parentRequest.passport.isRussianPassport,
        )
    }
    suspend fun getParent(parentId: Int): ParentRequest {
        val parentEntity = DAOSource.parentDAO.getParent(parentId)
        val passportEntity = DAOSource.passportDAO.getPassport(parentEntity.passportId)
        return ParentRequest(
            parentId,
            "${parentEntity.firstName} ${parentEntity.secondName} ${parentEntity.lastName}",
            parentEntity.parentStatus,
            parentEntity.citizenCountry,
            parentEntity.birthday,
            PassportRequest(
                passportEntity.series.toInt(),
                passportEntity.number.toInt(),
                passportEntity.dateOfGetting,
                passportEntity.issueName,
                passportEntity.isRussianPassport,
            ),
            parentEntity.address,
            parentEntity.snils,
            parentEntity.phoneNumber,
            parentEntity.email,
        )
    }
}