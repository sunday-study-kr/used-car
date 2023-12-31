package sundaystudy.kr.usedcar.module.matching.dto

import java.util.*

data class MatchingResponse(
    val id: UUID,
    val requestMemberId: UUID?,
    val postOwnerId: UUID?
)
