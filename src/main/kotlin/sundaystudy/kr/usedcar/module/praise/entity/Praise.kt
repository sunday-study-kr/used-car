package sundaystudy.kr.usedcar.module.praise.entity

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
class Praise(

    @Column(nullable = false)
    val praiseType: String,

    @Lob
    val content: String,

    @JoinColumn
    @OneToOne(fetch = FetchType.LAZY)
    val user: User,

    @JoinColumn
    @OneToOne(fetch = FetchType.LAZY)
    val praiser: User,
) : Auditable {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()

    var amount: Int = 1
        protected set

    fun increaseAmount() {
        this.amount++
    }

    @Embedded
    override var baseTime: BaseTime = BaseTime()
}
