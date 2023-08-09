package sundaystudy.kr.usedcar.module.review.entity

import jakarta.persistence.*
import org.hibernate.annotations.Where
import sundaystudy.kr.usedcar.global.audit.AuditListener
import sundaystudy.kr.usedcar.global.audit.Auditable
import sundaystudy.kr.usedcar.global.audit.BaseTime
import sundaystudy.kr.usedcar.module.member.entity.Member
import java.util.*

@Entity
@Where(clause = "deleted_at is null")
@EntityListeners(AuditListener::class)
class Review(

    @Lob
    var content: String,

    @JoinColumn
    @OneToOne(fetch = FetchType.LAZY)
    var member: Member,

    @JoinColumn
    @OneToOne(fetch = FetchType.LAZY)
    var reviewer: Member,
) : Auditable {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()

    @Embedded
    override var baseTime: BaseTime = BaseTime()
}
