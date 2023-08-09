package sundaystudy.kr.usedcar.config.security

import jakarta.servlet.http.HttpServletResponse
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import sundaystudy.kr.usedcar.config.security.jwt.JwtAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val oAuth2UserService: OAuth2UserService<OAuth2UserRequest, OAuth2User>,
    private val authenticationSuccessHandler: AuthenticationSuccessHandler,
    private val jwtAuthenticationFilter: JwtAuthenticationFilter
) {

    @Bean
    fun configure(http: HttpSecurity): SecurityFilterChain {
        return http
            .httpBasic {
                it.disable()
            }
            .formLogin{
                it.disable()
            }
            .authorizeHttpRequests {
                it.requestMatchers("/oauth2/**", "/auth/**")
                    .permitAll()
                    .anyRequest()
                    .authenticated()
            }
            .oauth2Login {
                it.authorizationEndpoint{ endpoint ->
                    endpoint.baseUri("/oauth2/authorize")
                }
                it.redirectionEndpoint { endpoint ->
                    endpoint.baseUri("/oauth2/callback/*")
                }
                it.userInfoEndpoint { endpoint ->
                    endpoint.userService(oAuth2UserService::loadUser)
                }
                it.successHandler(authenticationSuccessHandler)
            }
            .sessionManagement {
                it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)
            .exceptionHandling {
                it.authenticationEntryPoint { _, response, authException ->
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.message)
                }
                it.accessDeniedHandler { _, response, accessDeniedException ->
                    response.sendError(HttpServletResponse.SC_FORBIDDEN, accessDeniedException.message)
                }
            }
            .build()
    }
}
