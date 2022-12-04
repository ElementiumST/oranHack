package stark.io.data.repos

import stark.io.data.dao.DAOSource
import stark.io.data.models.ChildEntity
import stark.io.view.model.BirthCertificateRequest
import stark.io.view.model.ChildRequest
import stark.io.view.model.PassportRequest

object ChildRepos {
    suspend fun getChild(childId: Int): ChildRequest {
        val childEntity = DAOSource.childDAO.getChild(childId)
        val passportRequest = if (childEntity.passportId != -1) {
            val passportEntity = DAOSource.passportDAO.getPassport(childEntity.passportId)
            PassportRequest(
                passportEntity.series.toInt(),
                passportEntity.number.toInt(),
                passportEntity.dateOfGetting,
                passportEntity.issueName,
                passportEntity.isRussianPassport
            )
        } else null
        val birthCertificateRequest = if (childEntity.birthCertificateId != -1) {
            val birthCertificateEntity = DAOSource.birthCertificateDAO.getBirthCertificate(childEntity.birthCertificateId)
            BirthCertificateRequest(
                birthCertificateEntity.isRussian,
                birthCertificateEntity.series,
                birthCertificateEntity.number,
                birthCertificateEntity.dateOfGetting,
                birthCertificateEntity.issueName,
            )
        } else null
        return ChildRequest(
            childEntity.id,
            childEntity.firstName,
            childEntity.secondName,
            childEntity.lastName,
            childEntity.citizenCountry,
            childEntity.birthday,
            passportRequest,
            birthCertificateRequest,
            childEntity.address,
            childEntity.snils,
            childEntity.phoneNumber,
            childEntity.parentId
        )
    }
    suspend fun getChildsByParent(parentId: Int): List<ChildRequest> {
        val childEntityList = DAOSource.childDAO.getChildByParentId(parentId)
        return childEntityList.map {
            val passportRequest = if (it.passportId != -1) {
                val passportEntity = DAOSource.passportDAO.getPassport(it.passportId)
                PassportRequest(
                    passportEntity.series.toInt(),
                    passportEntity.number.toInt(),
                    passportEntity.dateOfGetting,
                    passportEntity.issueName,
                    passportEntity.isRussianPassport
                )
            } else null
            val birthCertificateRequest = if (it.birthCertificateId != -1) {
                val birthCertificateEntity = DAOSource.birthCertificateDAO.getBirthCertificate(it.birthCertificateId)
                BirthCertificateRequest(
                    birthCertificateEntity.isRussian,
                    birthCertificateEntity.series,
                    birthCertificateEntity.number,
                    birthCertificateEntity.dateOfGetting,
                    birthCertificateEntity.issueName,
                )
            } else null
            ChildRequest(
                it.id,
                it.firstName,
                it.secondName,
                it.lastName,
                it.citizenCountry,
                it.birthday,
                passportRequest,
                birthCertificateRequest,
                it.address,
                it.snils,
                it.phoneNumber,
                it.parentId
            )
        }
    }
    suspend fun addChild(childRequest: ChildRequest): Int {
        val passportId = if (childRequest.passport != null) {
            DAOSource.passportDAO.addPassport(
                childRequest.passport.series.toString(),
                childRequest.passport.number.toString(),
                childRequest.passport.dateOfGetting,
                childRequest.passport.issueName,
                childRequest.passport.isRussianPassport
            )!!.id
        } else -1
        val birthCertificateId = if (childRequest.birthCertificate != null) {
            DAOSource.birthCertificateDAO.addBirthCertificate(
                childRequest.birthCertificate.isRussian,
                childRequest.birthCertificate.series,
                childRequest.birthCertificate.number,
                childRequest.birthCertificate.dateOfGetting,
                childRequest.birthCertificate.issueName
            )!!.id
        } else -1
        return DAOSource.childDAO.addChild(
            childRequest.firstName,
            childRequest.secondName,
            childRequest.lastName,
            childRequest.citizenCountry,
            childRequest.birthday,
            passportId,
            birthCertificateId,
            childRequest.address,
            childRequest.snils,
            childRequest.phoneNumber,
            childRequest.parentId!!
        )!!.id
    }
    suspend fun updateChild(childRequest: ChildRequest) {
        val passportId = if (childRequest.passport != null) {
            DAOSource.passportDAO.addPassport(
                childRequest.passport.series.toString(),
                childRequest.passport.number.toString(),
                childRequest.passport.dateOfGetting,
                childRequest.passport.issueName,
                childRequest.passport.isRussianPassport
            )!!.id
        } else -1
        val birthCertificateId = if (childRequest.birthCertificate != null) {
            DAOSource.birthCertificateDAO.addBirthCertificate(
                childRequest.birthCertificate.isRussian,
                childRequest.birthCertificate.series,
                childRequest.birthCertificate.number,
                childRequest.birthCertificate.dateOfGetting,
                childRequest.birthCertificate.issueName
            )!!.id
        } else -1
        DAOSource.childDAO.editChild(
            childRequest.id!!,
            childRequest.firstName,
            childRequest.secondName,
            childRequest.lastName,
            childRequest.citizenCountry,
            childRequest.birthday,
            passportId,
            birthCertificateId,
            childRequest.address,
            childRequest.snils,
            childRequest.phoneNumber,
            childRequest.parentId!!
        )
    }
}