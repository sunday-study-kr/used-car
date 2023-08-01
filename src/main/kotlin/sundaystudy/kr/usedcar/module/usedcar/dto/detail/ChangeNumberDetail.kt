package sundaystudy.kr.usedcar.module.usedcar.dto.detail

import java.time.LocalDateTime

data class ChangeNumberDetail(
    var changeDay: LocalDateTime,
    var changeName: String,
    var isFirst: Boolean
)
