package stark.io.view.model

import kotlinx.serialization.Serializable

@Serializable
data class TokenRequest(
    val grantType: String,
    val refreshToken: String? = "",
    val username: String? = "",
    val password: String? = ""
)