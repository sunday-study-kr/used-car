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
    @Column(name = "chat")
    var chat: Int,
    @Column(name = "focus")
    var focus: Int,
    @Column(name = "look")
    var look: Int,
    @Column(name = "introduce")
    var introduce: String,
    @Column(name = "deal_address")
    var dealAddress: String,

) : Auditable {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "used_car_id")
    var usedCar: UsedCar? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    var member : Member? = null

    @Embedded
    override var baseTime: BaseTime = BaseTime()

    fun addMember(member: Member){
        this.member = member
        member.posts.add(this)
    }

    fun addUsedCar(usedCar: UsedCar){
        this.usedCar = usedCar
    }
}
