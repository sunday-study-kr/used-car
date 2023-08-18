package sundaystudy.kr.usedcar.module.member.mapper

import org.springframework.stereotype.Component
import sundaystudy.kr.usedcar.config.security.oauth.OAuth2Request
import sundaystudy.kr.usedcar.module.member.dto.response.MemberDetailsResponse
import sundaystudy.kr.usedcar.module.member.entity.Member
import sundaystudy.kr.usedcar.module.member.entity.OAuth2Details

@Component
class MemberMapper {

    fun toEntity(oAuth2Request: OAuth2Request): Member =
        Member(
            oAuth2Details = OAuth2Details(
                clientId = oAuth2Request.clientId,
                authProvider = oAuth2Request.authProvider
            )
        )

    fun toDetailsResponse(member: Member): MemberDetailsResponse =
        MemberDetailsResponse(
            id = member.id,
            nickname = member.nickname,
            mannerTemperature = member.mannerTemperature,
            rateOfReDealing = member.rateOfReDealing,
            responseRate = member.responseRate
        )
}
