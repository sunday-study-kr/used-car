package sundaystudy.kr.usedcar.module.usedcar.dto.request

import java.util.*

data class UpdateUsedCarRequest(
    var id: UUID,
    var price: Int,
    var savePrice: Int
)
