package sundaystudy.kr.usedcar.config.security.jwt

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthenticationFilter(
    private val jwtValidator: JwtValidator
) : OncePerRequestFilter() {
    private val TOKEN_TAG: String = "Authorization"
    private val TOKEN_PREFIX: String = "Bearer "
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = parseBearerToken(request)
        val authentication = token?.let {
            jwtValidator.getAuthentication(it)
        }
        SecurityContextHolder.getContext().authentication = authentication

        filterChain.doFilter(request, response)
    }

    private fun parseBearerToken(request: HttpServletRequest): String? {
        val bearerToken = request.getHeader(TOKEN_TAG)
        return if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(TOKEN_PREFIX))
            bearerToken.substring(7) else null
    }
}
