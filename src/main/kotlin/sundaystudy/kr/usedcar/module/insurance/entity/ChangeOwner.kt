package sundaystudy.kr.usedcar.module.insurance.entity

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
class ChangeOwner(
    @Column(name = "change_day")
    var changeDay: LocalDateTime,
) {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    var id: UUID = UUID.randomUUID()

    @JoinColumn(name = "insurance_id")
    @ManyToOne(fetch = FetchType.LAZY)
    lateinit var insurance: Insurance
}
