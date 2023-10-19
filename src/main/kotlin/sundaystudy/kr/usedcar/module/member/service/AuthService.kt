package sundaystudy.kr.usedcar.module.member.service

import jakarta.persistence.EntityNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import sundaystudy.kr.usedcar.config.security.jwt.JwtProvider
import sundaystudy.kr.usedcar.config.security.jwt.JwtToken
import sundaystudy.kr.usedcar.config.security.jwt.JwtValidator
import sundaystudy.kr.usedcar.config.security.oauth.user.UserPrinciple
import sundaystudy.kr.usedcar.module.member.entity.Member
import sundaystudy.kr.usedcar.module.member.exception.JwtProcessingException
import sundaystudy.kr.usedcar.module.member.repository.MemberRepository
import java.util.*

@Service
class AuthService(
    private val memberRepository: MemberRepository,
    private val jwtProvider: JwtProvider,
    private val jwtValidator: JwtValidator
) {
    fun refreshToken(oldRefreshToken: String, oldAccessToken: String): JwtToken {
        validateTokens(oldRefreshToken, oldAccessToken)
        val user: UserPrinciple = getUserDetails(oldAccessToken)
        validateSavedRefreshTokenIfExpired(oldRefreshToken, UUID.fromString(user.getName()))
        return findMemberAndUpdateRefreshToken(user)
    }

    private fun findMemberAndUpdateRefreshToken(user: UserPrinciple): JwtToken {
        val jwtToken: JwtToken = jwtProvider.createToken(user)
        memberRepository.findById(UUID.fromString(user.getName()))
            .orElseThrow { EntityNotFoundException() }
            .updateRefreshToken(jwtToken.refreshToken)
        return jwtToken
    }

    private fun getUserDetails(oldAccessToken: String): UserPrinciple {
        val authentication = jwtValidator.getAuthentication(oldAccessToken)
        return authentication.principal as UserPrinciple
    }

    private fun validateTokens(oldRefreshToken: String, oldAccessToken: String) {
        validateJwtTokens(oldRefreshToken, oldAccessToken)
        validateIfRefreshTokenExpired(oldRefreshToken)
    }

    private fun validateSavedRefreshTokenIfExpired(oldRefreshToken: String, id: UUID) {
        val savedToken: String = memberRepository.findRefreshTokenById(id)
        if (savedToken != oldRefreshToken) {
            throw JwtProcessingException()
        }
    }

    private fun validateIfRefreshTokenExpired(oldRefreshToken: String) {
        if (!jwtProvider.validateToken(oldRefreshToken)) {
            throw JwtProcessingException()
        }
    }

    private fun validateJwtTokens(oldRefreshToken: String, oldAccessToken: String) {
        if (!StringUtils.hasText(oldRefreshToken) || !StringUtils.hasText(oldAccessToken)) {
            throw JwtProcessingException()
        }
    }

    fun getLoginUserId(): UUID {
        val principal = SecurityContextHolder.getContext().authentication.principal
        return UUID.fromString((principal as UserPrinciple).getName())
    }

    fun getLoginUser(): Member =
        memberRepository.findByIdOrNull(getLoginUserId()) ?: throw EntityNotFoundException()
}
