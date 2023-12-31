package sundaystudy.kr.usedcar.config.security.oauth.user

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.oauth2.core.user.OAuth2User
import java.util.*

class UserPrinciple(
    private val id: UUID,
    private val authorities: MutableCollection<out GrantedAuthority>,
    private val attributes: MutableMap<String, Any> = mutableMapOf()
) : UserDetails, OAuth2User {
    override fun getName(): String = id.toString()

    override fun getAttributes(): MutableMap<String, Any> = attributes

    override fun getPassword(): String = ""

    override fun getUsername(): String = "user"

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = authorities
}
