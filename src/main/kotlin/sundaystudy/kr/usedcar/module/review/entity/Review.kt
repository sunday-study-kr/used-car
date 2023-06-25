package sundaystudy.kr.usedcar.module.review.entity

import jakarta.persistence.*
import sundaystudy.kr.usedcar.global.audit.AuditListener
import sundaystudy.kr.usedcar.global.audit.Auditable
import sundaystudy.kr.usedcar.global.audit.BaseTime
import sundaystudy.kr.usedcar.global.audit.SoftDelete
import sundaystudy.kr.usedcar.module.user.entity.User
import java.util.*

@Entity
@SoftDelete
@EntityListeners(AuditListener::class)
class Review(

        var content: String,

        @JoinColumn
        @OneToOne(fetch = FetchType.LAZY)
        var user: User,

        @JoinColumn
        @OneToOne(fetch = FetchType.LAZY)
        var reviewer: User
): Auditable {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()

    override var baseTime: BaseTime = BaseTime()
}
