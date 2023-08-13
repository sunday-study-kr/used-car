package sundaystudy.kr.usedcar.config.security.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import sundaystudy.kr.usedcar.config.security.oauth.user.UserPrincipleMapper
import sundaystudy.kr.usedcar.module.member.repository.MemberRepository
import java.security.Key
import java.util.*

@Component
class JwtValidator(
    private val key: Key,
    private val memberRepository: MemberRepository,
    private val userPrincipleMapper: UserPrincipleMapper
) {
    fun getAuthentication(accessToken: String): Authentication {
        val claims = getTokenBodyClaims(accessToken)
        val loginUser = memberRepository.findByIdOrNull(extractUUID(claims))?.let {
            userPrincipleMapper.mapToUserPrinciple(it)
        }
        return UsernamePasswordAuthenticationToken(loginUser, "", loginUser?.authorities)
    }

    fun extractUUID(claims: Claims): UUID {
        return UUID.fromString(claims.get("id", String::class.java))
    }

    fun getTokenBodyClaims(accessToken: String?): Claims {
        return Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(accessToken)
            .body
    }
}
