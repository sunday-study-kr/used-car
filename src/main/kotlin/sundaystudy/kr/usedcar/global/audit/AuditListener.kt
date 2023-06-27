package sundaystudy.kr.usedcar.global.audit

import jakarta.persistence.PrePersist
import jakarta.persistence.PreUpdate
import java.time.LocalDateTime

class AuditListener {
    @PrePersist
    fun setCreatedAt(auditable: Auditable) {
        auditable.baseTime.createdAt = LocalDateTime.now()
    }

    @PreUpdate
    fun setUpdatedAt(auditable: Auditable) {
        auditable.baseTime.updatedAt = LocalDateTime.now()
    }
}
