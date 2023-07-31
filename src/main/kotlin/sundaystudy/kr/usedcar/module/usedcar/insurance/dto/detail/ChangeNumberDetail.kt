package sundaystudy.kr.usedcar.module.usedcar.insurance.dto.detail

import java.time.LocalDateTime

data class ChangeNumberDetail(
    var changeDay: LocalDateTime,
    var changeName: String,
    var isFirst: Boolean
)
