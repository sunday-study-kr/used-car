package sundaystudy.kr.usedcar.module.usedcar.entity

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
class ChangeNumber(
    @Column(name = "change_day")
    var changeDay: LocalDateTime,
    @Column(name = "change_name")
    var changeName: String,
    @Column(name = "is_first")
    var isFirst: Boolean,
) {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()

    @JoinColumn(name = "insuracne_id")
    @ManyToOne(fetch = FetchType.LAZY)
    var insurance: Insurance? = null
}
