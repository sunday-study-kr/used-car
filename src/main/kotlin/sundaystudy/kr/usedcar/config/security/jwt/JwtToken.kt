package sundaystudy.kr.usedcar.config.security.jwt

data class JwtToken(
    var accessToken: String,
    var refreshToken: String,
)
