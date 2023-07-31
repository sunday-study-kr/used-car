package sundaystudy.kr.usedcar.module.usedcar.insurance.entity

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
class OpponentAccident(

    @Column(name = "day")
    var Day: LocalDateTime,

    @Column(name = "part_price")
    var partPrice: Int,

    @Column(name = "wages_price")
    var wagesPrice: Int,

    @Column(name = "coation_price")
    var coationPrice: Int,

    @Column(name = "total_price")
    var totalPrice: Int
) {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    var id: UUID = UUID.randomUUID()


    @JoinColumn(name = "insuracne_id")
    @ManyToOne(fetch = FetchType.LAZY)
    var insurance: Insurance? = null

}
