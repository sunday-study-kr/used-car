package sundaystudy.kr.usedcar.config.security.oauth

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler
import org.springframework.stereotype.Component
import org.springframework.web.util.UriComponentsBuilder
import sundaystudy.kr.usedcar.config.security.jwt.JwtCookieProvider
import sundaystudy.kr.usedcar.config.security.oauth.user.UserPrinciple

@Component
class OAuth2AuthenticationSuccessHandler(
    private val jwtCookieProvider: JwtCookieProvider,
): SimpleUrlAuthenticationSuccessHandler() {
    @Value("\${app.auth.authorizedRedirectUri}")
    private lateinit var REDIRECT_URI: String

    override fun onAuthenticationSuccess(
        request: HttpServletRequest?, response: HttpServletResponse, authentication: Authentication
    ) {
        val targetUri = determineTargetUrl(request, response, authentication)
        if (response.isCommitted) {
            return
        }
        clearAuthenticationAttributes(request, response)
        val loginUser: UserPrinciple = authentication.principal as UserPrinciple
        jwtCookieProvider.addJwtTokensInCookie(response, loginUser)
        redirectStrategy.sendRedirect(request, response, targetUri)
    }

    override fun determineTargetUrl(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authentication: Authentication
    ): String = UriComponentsBuilder.fromUriString(REDIRECT_URI)
            .build().toUriString()


    protected fun clearAuthenticationAttributes(request: HttpServletRequest?, response: HttpServletResponse?) {
        super.clearAuthenticationAttributes(request)
    }
}
