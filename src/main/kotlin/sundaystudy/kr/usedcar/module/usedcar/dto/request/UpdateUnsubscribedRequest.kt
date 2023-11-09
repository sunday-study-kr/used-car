package sundaystudy.kr.usedcar.module.usedcar.dto.request

import jakarta.validation.constraints.NotNull
import sundaystudy.kr.usedcar.module.usedcar.dto.detail.UnsubscribedDetail
import java.util.UUID

data class UpdateUnsubscribedRequest(
    @field:NotNull
    var id : UUID,
    @field:NotNull
    var detail : UnsubscribedDetail
)
