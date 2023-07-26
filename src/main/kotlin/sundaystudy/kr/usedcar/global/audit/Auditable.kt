package sundaystudy.kr.usedcar.global.audit

import java.time.LocalDateTime

interface Auditable {
    var baseTime: BaseTime
    fun delete() {
        baseTime.deletedAt = LocalDateTime.now()
    }
}
