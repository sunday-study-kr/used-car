package sundaystudy.kr.usedcar.module.praise.dto.request

import java.util.*

data class PraiseUpdateRequest(
    var id: UUID,
    var content: String,
    var praiseType: String,
)