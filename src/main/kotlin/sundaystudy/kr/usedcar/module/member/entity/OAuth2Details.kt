package sundaystudy.kr.usedcar.module.member.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

@Embeddable
class OAuth2Details(
    @Column(nullable = false, unique = true)
    var clientId: String,

    @Enumerated(EnumType.STRING)
    var authProvider: AuthProvider
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as OAuth2Details
        if (clientId != other.clientId) return false
        if (authProvider != other.authProvider) return false
        return true
    }

    override fun hashCode(): Int {
        var result = clientId.hashCode()
        result = 31 * result + authProvider.hashCode()
        return result
    }
}
