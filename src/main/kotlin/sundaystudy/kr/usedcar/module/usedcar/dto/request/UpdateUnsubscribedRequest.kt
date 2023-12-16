package sundaystudy.kr.usedcar.module.usedcar.dto.request

import sundaystudy.kr.usedcar.module.usedcar.dto.detail.UnsubscribedDetail
import java.util.*

data class UpdateUnsubscribedRequest(
    var id: UUID,
    var detail: UnsubscribedDetail
)
