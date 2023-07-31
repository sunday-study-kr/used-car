package sundaystudy.kr.usedcar.module.review.dto.response

import java.util.*

data class ReviewResponse(
    var id: UUID,
    var content: String,
    var userId: UUID,
)
