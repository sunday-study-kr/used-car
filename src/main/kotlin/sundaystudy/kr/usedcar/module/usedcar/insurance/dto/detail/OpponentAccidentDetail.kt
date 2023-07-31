package sundaystudy.kr.usedcar.module.usedcar.insurance.dto.detail

import java.time.LocalDateTime

data class OpponentAccidentDetail(
    var Day: LocalDateTime,
    var partPrice: Int,
    var wagesPrice: Int,
    var coationPrice: Int,
    var totalPrice: Int
)
