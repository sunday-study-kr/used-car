package sundaystudy.kr.usedcar.module.badge.entity

import com.github.f4b6a3.ulid.UlidCreator
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
class Badge(
    val badgeName: String,

    @JoinColumn(columnDefinition = "BINARY(16)")
    @ManyToOne(fetch = FetchType.LAZY)
    var member: Member,
) : Auditable {

    init {
        organizeMember(this.member)
    }

    @Id
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UlidCreator.getMonotonicUlid().toUuid()

    var isRepresent: Boolean = false
        protected set

    @Embedded
    override var baseTime: BaseTime = BaseTime()

    fun updateToRepresent() {
        this.member.badges.find(Badge::isRepresent)?.updateToNotRepresent()
        this.isRepresent = true
    }

    private fun updateToNotRepresent() {
        this.isRepresent = false
    }

    private fun organizeMember(member: Member) {
        member.organizeBadge(this)
    }
}
