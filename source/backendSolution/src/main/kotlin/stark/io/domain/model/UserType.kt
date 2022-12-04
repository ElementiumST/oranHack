package stark.io.domain.model

sealed class UserType(val name: String) {
    object Parent: UserType("parent")
    object Organization: UserType("organization")
    object Minsots: UserType("minsots")
    object Administrator: UserType("administrator")


    companion object {
        fun fromString(userType: String): UserType {
            return when(userType) {
                "organization" -> Organization
                "minsots" -> Minsots
                "administrator" -> Administrator
                "parent" -> Parent
                else -> throw IllegalArgumentException(userType)
            }
        }
    }
}