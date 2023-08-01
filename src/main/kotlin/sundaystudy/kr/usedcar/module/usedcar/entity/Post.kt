package sundaystudy.kr.usedcar.module.usedcar.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import java.util.*

@Entity
class Post(
    @Column(name = "chat")
    var chat: Int,
    @Column(name = "focus")
    var focus: Int,
    @Column(name = "look")
    var look: Int,
    @Column(name = "introduce")
    var introduce: String,
    @Column(name = "deal_address")
    var dealAddress: String,

    // created_at , updated_at , deleted_at
) {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()

    @OneToOne
    @JoinColumn(name = "used_car_id")
    var usedCar: UsedCar? = null

    // user와 연관관계 추가
}
