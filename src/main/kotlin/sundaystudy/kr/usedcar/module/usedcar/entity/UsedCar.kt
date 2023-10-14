package sundaystudy.kr.usedcar.module.usedcar.entity

import jakarta.persistence.*
import org.hibernate.annotations.Where
import sundaystudy.kr.usedcar.global.audit.AuditListener
import sundaystudy.kr.usedcar.global.audit.Auditable
import sundaystudy.kr.usedcar.global.audit.BaseTime

import java.util.UUID

@Entity
@Where(clause = "deleted_at is null")
@EntityListeners(AuditListener::class)
@Table(name = "used_car")
class UsedCar(

    @Column(name = "license_number")
    var licenseNumber: String,

    @Column(name = "price")
    var price: Int,

    @Column(name = "save_price")
    var savePrice: Int,

) : Auditable {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()

    @Embedded
    override var baseTime: BaseTime = BaseTime()

    @JoinColumn(name = "car_id")
    @OneToOne(fetch = FetchType.LAZY , cascade = [CascadeType.PERSIST , CascadeType.MERGE])
    var car: Car? = null

    @JoinColumn(name = "insurance_id")
    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST , CascadeType.MERGE])
    var insurance: Insurance? = null

    fun addCar(car : Car){
        this.car = car
        car.usedCar = this
    }

    fun addInsurance(insurance: Insurance){
        this.insurance = insurance
        insurance.usedCar = this
    }
}
