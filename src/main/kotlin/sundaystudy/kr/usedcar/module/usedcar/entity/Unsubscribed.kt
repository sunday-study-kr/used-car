package sundaystudy.kr.usedcar.module.usedcar.entity

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "unsubscribed")
class Unsubscribed(
    @Column(name = "start_at")
    var startAt: LocalDateTime,

    @Column(name = "end_at")
    var endAt: LocalDateTime,

    ) {
    @JoinColumn(name = "insurance_id", columnDefinition = "BINARY(16)")
    @ManyToOne(fetch = FetchType.LAZY)
    var insurance: Insurance? = null

    @Id
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()

}
