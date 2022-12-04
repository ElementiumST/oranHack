package stark.io.view.model

import kotlinx.serialization.Serializable

@Serializable
data class SignUpRequest(
    val email: String,
    val password: String,
    val isOrganization: Boolean
)
