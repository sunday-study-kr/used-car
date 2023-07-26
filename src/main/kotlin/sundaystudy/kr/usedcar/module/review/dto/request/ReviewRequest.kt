package sundaystudy.kr.usedcar.module.review.dto.request

import java.util.*

data class ReviewRequest(
    var content: String,
    var userId: UUID,
    var reviewerId: UUID,
)
