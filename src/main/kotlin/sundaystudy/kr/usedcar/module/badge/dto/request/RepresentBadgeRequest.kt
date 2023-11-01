package sundaystudy.kr.usedcar.module.badge.dto.request

import jakarta.validation.constraints.NotNull
import java.util.*

data class RepresentBadgeRequest(
    @field:NotNull
    var id: UUID
)
