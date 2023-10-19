package sundaystudy.kr.usedcar.module.praise.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.util.*

data class PraiseRequest(
    @field:NotNull
    var memberId: UUID,
    @field:NotBlank
    var praiseType: String,
)
