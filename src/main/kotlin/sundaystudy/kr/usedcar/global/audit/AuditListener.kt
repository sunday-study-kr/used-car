package sundaystudy.kr.usedcar.global.audit

import jakarta.persistence.PrePersist
import jakarta.persistence.PreUpdate
import java.time.LocalDateTime

interface AuditListener {
    @PrePersist
    fun setCreatedAt(auditable: Auditable) {
        val baseTime: BaseTime = auditable.baseTime
        baseTime.createdAt = LocalDateTime.now()
    }

    @PreUpdate
    fun setUpdatedAt(auditable: Auditable) {
        val baseTime: BaseTime = auditable.baseTime
        baseTime.updatedAt = LocalDateTime.now()
    }
}
