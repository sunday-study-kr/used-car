package sundaystudy.kr.usedcar.module.usedcar.dto.request

import jakarta.validation.constraints.NotNull
import java.util.UUID

data class UpdateUsedCarRequest(
    @field:NotNull
    var id : UUID,
    @field:NotNull
    var price : Int,
    @field:NotNull
    var savePrice : Int
)
