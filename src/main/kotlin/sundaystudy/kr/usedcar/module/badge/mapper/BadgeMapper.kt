package sundaystudy.kr.usedcar.module.badge.mapper

import org.springframework.stereotype.Component
import sundaystudy.kr.usedcar.module.badge.dto.response.BadgeResponse
import sundaystudy.kr.usedcar.module.badge.entity.Badge

@Component
class BadgeMapper {

    fun toResponseList(badgeList: List<Badge>): List<BadgeResponse> =
        badgeList.map(this::toResponse)

    private fun toResponse(badge: Badge): BadgeResponse {
        return BadgeResponse(
            id = badge.id,
            memberId = badge.member.id,
            badgeName = badge.badgeName,
            isRepresent = badge.isRepresent
        )
    }
}
