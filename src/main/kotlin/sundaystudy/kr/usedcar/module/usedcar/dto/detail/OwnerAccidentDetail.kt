package sundaystudy.kr.usedcar.module.usedcar.dto.detail

import java.time.LocalDateTime

data class OwnerAccidentDetail(
    var Day: LocalDateTime,
    var partPrice: Int,
    var wagesPrice: Int,
    var coationPrice: Int,
    var totalPrice: Int
)
