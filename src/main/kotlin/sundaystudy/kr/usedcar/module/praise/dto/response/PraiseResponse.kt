package sundaystudy.kr.usedcar.module.praise.dto.response

import java.util.*

data class PraiseResponse(
    var id: UUID,
    var userId: UUID,
    var praiseType: String,
    var amount: Int,
)
