package sundaystudy.kr.usedcar.module.member.mapper

import org.springframework.stereotype.Component
import sundaystudy.kr.usedcar.config.security.oauth.OAuth2Request
import sundaystudy.kr.usedcar.module.member.entity.Member
import sundaystudy.kr.usedcar.module.member.entity.OAuth2Details

@Component
class MemberMapper {

    fun toEntity(oAuth2Request: OAuth2Request): Member =
        Member(oAuth2Details = OAuth2Details(oAuth2Request.clientId, oAuth2Request.authProvider))
}
