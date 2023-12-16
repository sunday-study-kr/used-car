package sundaystudy.kr.usedcar.module.post.entity

import jakarta.persistence.*
import org.hibernate.annotations.Where
import sundaystudy.kr.usedcar.global.audit.AuditListener
import sundaystudy.kr.usedcar.global.audit.Auditable
import sundaystudy.kr.usedcar.global.audit.BaseTime
import sundaystudy.kr.usedcar.module.member.entity.Member
import sundaystudy.kr.usedcar.module.usedcar.entity.UsedCar
import java.util.*

@Entity
@Where(clause = "deleted_at is null")
@EntityListeners(AuditListener::class)
class Post(
    @Column(name = "introduce")
    var introduce: String,

    @Column(name = "deal_address")
    var dealAddress: String,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "used_car_id")
    var usedCar: UsedCar,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    var member: Member

) : Auditable {

    @Column(name = "chat")
    var chat: Int = 0

    @Column(name = "focus")
    var focus: Int = 0

    @Column(name = "look")
    var look: Int = 0

    @Id
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()

    @Embedded
    override var baseTime: BaseTime = BaseTime()

    init {
        addMember(member)
        addUsedCar(usedCar)
    }

    private fun addMember(member: Member) {
        this.member = member
        member.posts.add(this)
    }

    private fun addUsedCar(usedCar: UsedCar) {
        this.usedCar = usedCar
    }
}
