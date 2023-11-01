package sundaystudy.kr.usedcar.module.review.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.util.*

data class ReviewRequest(
    @field:NotBlank
    var content: String,
    @field:NotNull
    var memberId: UUID,
)
