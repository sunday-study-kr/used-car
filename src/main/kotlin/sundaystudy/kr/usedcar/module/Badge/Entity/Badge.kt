package sundaystudy.kr.usedcar.module.Badge.Entity

import jakarta.persistence.*
import sundaystudy.kr.usedcar.module.User.Entity.User
import java.util.*

@Entity
class Badge(
        val badgeName: String,

        @JoinColumn
        @OneToOne(fetch = FetchType.LAZY)
        var user: User
) {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()

    var isRepresent: Boolean? = null
        protected set
}
