package sundaystudy.kr.usedcar.module.usedcar.insurance.entity

import jakarta.persistence.*
import java.util.Date
import java.util.UUID

@Entity
@Table(name = "unsubscribed")
class Unsubscribed(
    @Column(name = "start_at")
    var startAt: Date,

    @Column(name = "end_at")
    var endAt: Date,

) {
    @JoinColumn(name = "insurance_id", columnDefinition = "BINARY(16)")
    @ManyToOne(fetch = FetchType.LAZY)
    var insurance: Insurance? = null

    @Id
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()
}
