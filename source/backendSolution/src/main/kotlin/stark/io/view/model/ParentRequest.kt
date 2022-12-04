package stark.io.view.model

import kotlinx.serialization.Serializable

@Serializable
data class ParentRequest (
    var id: Int? = 0,
    val fio: String,
    val parentStatus: String,
    val citizenCountry: String,
    val birthday: String,
    val passport: PassportRequest,
    val address: String,
    val snils: String,
    val phoneNumber: String,
    var email: String,
)