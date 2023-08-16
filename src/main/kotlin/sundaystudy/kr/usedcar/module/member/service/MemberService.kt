package sundaystudy.kr.usedcar.module.member.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import sundaystudy.kr.usedcar.config.security.oauth.OAuth2Request
import sundaystudy.kr.usedcar.global.exception.EntityNotFoundException
import sundaystudy.kr.usedcar.module.member.dto.response.MemberDetailsResponse
import sundaystudy.kr.usedcar.module.member.entity.Member
import sundaystudy.kr.usedcar.module.member.mapper.MemberMapper
import sundaystudy.kr.usedcar.module.member.repository.MemberRepository
import java.util.*

@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val memberMapper: MemberMapper,
    private val authService: AuthService,
) {
    fun getMemberDetails(): MemberDetailsResponse {
        val loginUser = authService.getLoginUser()
        return memberMapper.toDetailsResponse(loginUser)
    }

    fun saveIfNone(oAuth2Request: OAuth2Request): Member {
        return memberRepository.findByoAuth2DetailsClientId(oAuth2Request.clientId)
            ?: memberRepository.save(memberMapper.toEntity(oAuth2Request))
    }

    fun getEntity(id: UUID) =
        memberRepository.findByIdOrNull(id)?: throw EntityNotFoundException()
}
