package sundaystudy.kr.usedcar.global.audit

import jakarta.persistence.Embeddable
import java.time.LocalDateTime

@Embeddable
class BaseTime {
    var createdAt: LocalDateTime? = null
    var updatedAt: LocalDateTime? = null
    var deletedAt: LocalDateTime? = null
}
