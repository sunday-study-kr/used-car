package sundaystudy.kr.usedcar.module.praise.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.util.*

data class PraiseUpdateRequest(
    @field:NotNull
    var id: UUID,
    @field:NotBlank
    var praiseType: String,
)
