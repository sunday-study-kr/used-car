package sundaystudy.kr.usedcar.module.usedcar.dto.detail

import java.time.LocalDateTime

data class AccidentDetail (
    var Day: LocalDateTime,
    var partPrice: Int,
    var wagesPrice: Int,
    var coationPrice: Int,
    var totalPrice: Int
)
