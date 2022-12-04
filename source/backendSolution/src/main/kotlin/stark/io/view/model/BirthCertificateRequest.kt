package stark.io.view.model

import kotlinx.serialization.Serializable

@Serializable
data class BirthCertificateRequest(
    val isRussian: Boolean,
    val series: String,
    val number: String,
    val dateOfGetting: String,
    val issueName:String,
)
