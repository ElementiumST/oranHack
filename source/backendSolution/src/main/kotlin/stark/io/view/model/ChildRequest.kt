package stark.io.view.model

import kotlinx.serialization.Serializable

@Serializable
data class ChildRequest(
    val id: Int? = -1,
    val firstName: String,
    val secondName: String,
    val lastName: String,
    val citizenCountry: String,
    val birthday: String,
    val passport: PassportRequest? = null,
    val birthCertificate: BirthCertificateRequest? = null,
    val address: String,
    val snils: String,
    val phoneNumber: String,
    var parentId: Int? = -1
)