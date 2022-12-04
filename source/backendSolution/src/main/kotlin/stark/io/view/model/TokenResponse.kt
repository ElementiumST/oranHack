package stark.io.view.model

import kotlinx.serialization.Serializable


@Serializable
data class TokenResponse(
    val refreshToken: String,
    val accessToken: String,
    val userType: String,
    )
