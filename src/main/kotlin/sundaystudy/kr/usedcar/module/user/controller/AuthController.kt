package sundaystudy.kr.usedcar.module.user.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sundaystudy.kr.usedcar.config.security.jwt.JwtToken
import sundaystudy.kr.usedcar.module.user.service.AuthService

@RestController
@RequestMapping("auth")
class AuthController(
    private val authService: AuthService,
) {
    @GetMapping("refresh")
    fun refreshToken(): ResponseEntity<JwtToken> =
        ResponseEntity.ok(authService.refreshToken())
}
