package sundaystudy.kr.usedcar.module.badge.entity

import jakarta.persistence.*
import org.hibernate.annotations.Where
import sundaystudy.kr.usedcar.global.audit.AuditListener
import sundaystudy.kr.usedcar.global.audit.Auditable
import sundaystudy.kr.usedcar.global.audit.BaseTime
import sundaystudy.kr.usedcar.module.user.entity.User
import java.util.*

@Entity
@Where(clause = "deleted_at is null")
@EntityListeners(AuditListener::class)
class Badge(
    val badgeName: String,

    @JoinColumn
    @OneToOne(fetch = FetchType.LAZY)
    var user: User,
) : Auditable {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()

    var isRepresent: Boolean? = null
        protected set

    @Embedded
    override var baseTime: BaseTime = BaseTime()
}
