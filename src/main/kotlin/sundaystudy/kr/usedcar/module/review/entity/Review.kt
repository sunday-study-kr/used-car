package sundaystudy.kr.usedcar.module.review.entity

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
class Review(

    @Lob
    var content: String,

    @JoinColumn
    @OneToOne(fetch = FetchType.LAZY)
    var user: User,

    @JoinColumn
    @OneToOne(fetch = FetchType.LAZY)
    var reviewer: User,
) : Auditable {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()

    @Embedded
    override var baseTime: BaseTime = BaseTime()
}
