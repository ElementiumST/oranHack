package stark.io.data.dao

object DAOSource {
    val userDAO: DAOUser by lazy { DAOUserImpl() }
    val passportDAO: DAOPassport by lazy { DAOPassportImpl() }
    val parentDAO: DAOParent by lazy { DAOParentImpl() }
    val birthCertificateDAO: DAOBirthCertificate by lazy { DAOBirthCertificateImpl() }
    val childDAO: DAOChild by lazy { DAOChildImpl() }
    val campDAO: DAOCamp by lazy { DAOCampImpl() }
}