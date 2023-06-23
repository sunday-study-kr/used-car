package sundaystudy.kr.usedcar.module.Insurance.Entity

import jakarta.persistence.*
import java.util.Date
import java.util.UUID

@Entity
@Table(name="unsubscribed")
class Unsubscribed(
    @Column(name = "start_at")
    var startAt : Date,

    @Column(name = "end_at")
    var endAt : Date

) {
    @JoinColumn(name = "insuracne_id", columnDefinition = "BINARY(16)")
    @ManyToOne(fetch = FetchType.LAZY)
    lateinit var insurance: Insurance

    @Id
    @Column(nullable = false, columnDefinition = "BINARY(16)")
    val id : String = UUID.randomUUID().toString()

}
