package sundaystudy.kr.usedcar.module.usedcar.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import sundaystudy.kr.usedcar.module.usedcar.insurance.entity.Insurance
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
    @OneToOne
    var car: Car? = null

    @JoinColumn(name = "insurance_id")
    @OneToOne
    var insurance: Insurance? = null
}
