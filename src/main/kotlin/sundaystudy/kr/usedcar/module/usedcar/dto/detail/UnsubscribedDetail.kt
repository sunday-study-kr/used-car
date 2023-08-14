package sundaystudy.kr.usedcar.module.usedcar.dto.detail

import java.time.LocalDateTime
import java.util.*

data class UnsubscribedDetail(
    var startAt: LocalDateTime,
    var endAt: LocalDateTime
)
