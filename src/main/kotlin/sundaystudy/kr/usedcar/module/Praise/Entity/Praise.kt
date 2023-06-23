package sundaystudy.kr.usedcar.module.Praise.Entity

import jakarta.persistence.*
import sundaystudy.kr.usedcar.module.User.Entity.User
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
) {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()

    var amount: Int = 1
        protected set

    fun increaseAmount() {
        this.amount++
    }
}
