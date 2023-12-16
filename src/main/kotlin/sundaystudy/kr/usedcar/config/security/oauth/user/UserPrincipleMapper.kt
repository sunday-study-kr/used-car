package sundaystudy.kr.usedcar.config.security.oauth.user

import org.springframework.stereotype.Component
import sundaystudy.kr.usedcar.module.member.entity.Member

@Component
class UserPrincipleMapper {
    fun mapToUserPrinciple(member: Member): UserPrinciple {
        return UserPrinciple(member.id, member.getRole(), mutableMapOf(Pair("id", member.id)))
    }
}
