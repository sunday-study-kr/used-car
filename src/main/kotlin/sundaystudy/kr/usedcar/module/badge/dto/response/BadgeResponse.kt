package sundaystudy.kr.usedcar.module.badge.dto.response

import java.util.*

data class BadgeResponse(
    var id: UUID,
    var userId: UUID,
    var badgeName: String,
    var isRepresent: Boolean,
)
