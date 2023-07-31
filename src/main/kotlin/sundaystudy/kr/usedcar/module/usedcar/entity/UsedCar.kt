package sundaystudy.kr.usedcar.module.usedcar.entity

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "used_car")
class UsedCar(

    @Column(name = "license_number")
    var licenseNumber: String,

    @Column(name = "price")
    var price: Int,

    @Column(name = "save_price")
    var savePrice: Int,

    // created_at , updated_at
) {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()

    @JoinColumn(name = "car_id")
    @OneToOne(fetch = FetchType.LAZY)
    var car: Car? = null

    @JoinColumn(name = "insurance_id")
    @OneToOne(fetch = FetchType.LAZY)
    var insurance: Insurance? = null
}
