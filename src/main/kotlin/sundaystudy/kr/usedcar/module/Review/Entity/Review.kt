package sundaystudy.kr.usedcar.module.Review.Entity

import jakarta.persistence.*
import sundaystudy.kr.usedcar.module.User.Entity.User
import java.util.*

@Entity
class Review(

        var content: String,

        @JoinColumn
        @OneToOne(fetch = FetchType.LAZY)
        var user: User,

        @JoinColumn
        @OneToOne(fetch = FetchType.LAZY)
        var reviewer: User
) {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()
}
