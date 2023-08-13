package sundaystudy.kr.usedcar.config.security.oauth

import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Component
import sundaystudy.kr.usedcar.config.security.oauth.user.UserPrinciple
import sundaystudy.kr.usedcar.module.member.entity.Member


@Component
class PrincipleMapper {
    fun mapToUserPrinciple(member: Member): OAuth2User {
        val attributes: MutableMap<String, Any> = HashMap()
        attributes["id"] = member.id
        return UserPrinciple(member.id, member.getRole(), attributes)
    }
}
