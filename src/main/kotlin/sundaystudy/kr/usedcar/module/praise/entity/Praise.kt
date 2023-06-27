package sundaystudy.kr.usedcar.module.praise.entity

import jakarta.persistence.*
import sundaystudy.kr.usedcar.global.audit.Auditable
import sundaystudy.kr.usedcar.global.audit.BaseTime
import sundaystudy.kr.usedcar.module.user.entity.User
import java.util.*

@Entity
class Praise(
        val praiseType: String,

        @JoinColumn
        @OneToOne(fetch = FetchType.LAZY)
        val user: User,

        @JoinColumn
        @OneToOne(fetch = FetchType.LAZY)
        val praiser: User
): Auditable {
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
