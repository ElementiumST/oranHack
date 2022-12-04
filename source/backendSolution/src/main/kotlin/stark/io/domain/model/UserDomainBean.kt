package stark.io.domain.model

data class UserDomainBean(
    val username: String,
    val userType: UserType,
    val refreshToken: String
)