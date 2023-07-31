package sundaystudy.kr.usedcar.module.praise.dto.response

import java.util.*

data class PraiseDetailsResponse(
    var id: UUID,
    var praiseType: String,
    var content: String,
)
