package stark.io.view.model

import kotlinx.serialization.Serializable

@Serializable
data class BirthCertificateRequest(
    val isRussian: Boolean,
    val series: Int,
    val number: Int,
    val dateOfGetting: String,
    val issueName:String,
)
