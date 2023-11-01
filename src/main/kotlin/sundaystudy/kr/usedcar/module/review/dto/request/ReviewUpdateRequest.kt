package sundaystudy.kr.usedcar.module.review.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.util.*

data class ReviewUpdateRequest (
    @field:NotNull
    var id: UUID,
    @field:NotBlank
    var content: String,
)
