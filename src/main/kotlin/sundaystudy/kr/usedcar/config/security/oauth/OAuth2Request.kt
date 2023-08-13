package sundaystudy.kr.usedcar.config.security.oauth

import sundaystudy.kr.usedcar.module.member.entity.AuthProvider

data class OAuth2Request(
    var clientId: String,
    var authProvider: AuthProvider
)
