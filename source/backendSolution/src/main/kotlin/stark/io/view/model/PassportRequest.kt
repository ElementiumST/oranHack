package stark.io.view.model

import kotlinx.serialization.Serializable

@Serializable
data class PassportRequest(
    val series: Int,
    val number: Int,
    val dateOfGetting: String,
    val issueName: String,
    val isRussianPassport: Boolean,
)