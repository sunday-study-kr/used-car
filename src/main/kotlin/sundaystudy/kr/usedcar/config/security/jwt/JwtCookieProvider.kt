package sundaystudy.kr.usedcar.config.security.jwt

import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseCookie
import org.springframework.stereotype.Component
import sundaystudy.kr.usedcar.config.security.oauth.user.UserPrinciple

@Component
class JwtCookieProvider(
    private val jwtTokenProvider: JwtProvider
) {
    private val ACCESS_TOKEN_HEADER: String = "Access"
    private val REFRESH_TOKEN_HEADER: String = "Refresh"

    fun addJwtTokensInCookie(response: HttpServletResponse, loginUser: UserPrinciple) {
        val jwtToken = jwtTokenProvider.createToken(loginUser)
        val accessTokenCookie = setCookie(ACCESS_TOKEN_HEADER, jwtToken.accessToken)
        response.addHeader(HttpHeaders.SET_COOKIE, accessTokenCookie.toString())
        val refreshTokenCookie = setCookie(REFRESH_TOKEN_HEADER, jwtToken.refreshToken)
        response.addHeader(HttpHeaders.SET_COOKIE, refreshTokenCookie.toString())
    }

    private fun setCookie(key: String, value: String): ResponseCookie {
        return ResponseCookie.from(key, value).path("/").httpOnly(true).build()
    }
}
