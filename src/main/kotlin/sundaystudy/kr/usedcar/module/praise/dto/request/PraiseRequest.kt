package sundaystudy.kr.usedcar.module.praise.dto.request

import java.util.*

data class PraiseRequest(
    var praiserId: UUID,
    var memberId: UUID,
    var praiseType: String,
)
