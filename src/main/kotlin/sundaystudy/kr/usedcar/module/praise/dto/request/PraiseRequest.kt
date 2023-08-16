package sundaystudy.kr.usedcar.module.praise.dto.request

import java.util.*

data class PraiseRequest(
    var content: String,
    var memberId: UUID,
    var praiseType: String,
)
