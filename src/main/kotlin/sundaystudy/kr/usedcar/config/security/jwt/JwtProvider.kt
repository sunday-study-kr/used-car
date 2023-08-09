package sundaystudy.kr.usedcar.config.security.jwt

import io.jsonwebtoken.*
import org.springframework.stereotype.Component
import sundaystudy.kr.usedcar.config.security.oauth.user.UserPrinciple
import sundaystudy.kr.usedcar.module.member.repository.MemberRepository
import java.security.Key
import java.util.*

@Component
class JwtProvider(
    private val key: Key,
    private val memberRepository: MemberRepository
) {
    private val ACCESS_TOKEN_EXPIRE_LENGTH = 60L * 60 * 24 * 1000 // 1 Day
    private val REFRESH_TOKEN_EXPIRE_LENGTH = 60L * 60 * 24 * 14 * 1000 // 14 Days

    fun createToken(userDetails: UserPrinciple): JwtToken {
        val claims = getClaims(userDetails)
        val accessToken = getToken(
            userDetails,
            claims,
            ACCESS_TOKEN_EXPIRE_LENGTH
        )
        val refreshToken = getToken(
            userDetails,
            claims,
            REFRESH_TOKEN_EXPIRE_LENGTH
        )
        saveRefreshToken(refreshToken, userDetails)
        return JwtToken(accessToken, refreshToken)
    }

    fun validateToken(token: String?): Boolean {
        return try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token)
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun saveRefreshToken(refreshToken: String, userDetails: UserPrinciple) {
        val id = UUID.fromString(userDetails.getName())
        memberRepository.updateRefreshToken(id, refreshToken)
    }

    private fun getClaims(userDetails: UserPrinciple): Claims {
        val claims = Jwts.claims()
        claims["id"] = userDetails.getName()
        return claims
    }

    private fun getToken(loginUser: UserPrinciple, claims: Claims, validationSecond: Long): String {
        val now = Date().time
        return Jwts.builder()
            .setSubject(loginUser.getName())
            .setClaims(claims)
            .signWith(key, SignatureAlgorithm.HS512)
            .setExpiration(Date(now + validationSecond))
            .compact()
    }
}