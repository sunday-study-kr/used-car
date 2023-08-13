package sundaystudy.kr.usedcar.module.member.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sundaystudy.kr.usedcar.config.security.jwt.JwtToken
import sundaystudy.kr.usedcar.module.member.service.AuthService

@RestController
@RequestMapping("auth")
class AuthController(
    private val authService: AuthService,
) {
    @GetMapping("refresh")
    fun refreshToken(
        @CookieValue("Refresh") refreshToken: String,
        @CookieValue("Access") accessToken: String
    ): ResponseEntity<JwtToken> =
        ResponseEntity.ok(authService.refreshToken(refreshToken, accessToken))
}
