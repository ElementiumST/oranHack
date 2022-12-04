package stark.io.view.model

import kotlinx.serialization.Serializable

@Serializable
data class CampRequest(
    val id: Int?,
    val name: String,
    val description: String,
    val season: Int,
    val type: String,
    val phone: String,
    val address: String,
    val space: String,
    val corpuses: String,
    val dayOfStart: String,
    val dayOfEnd: String,
    val status: Int? = -1
)