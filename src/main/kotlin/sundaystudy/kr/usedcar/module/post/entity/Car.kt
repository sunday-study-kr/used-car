package sundaystudy.kr.usedcar.module.post.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import java.util.*

@Entity
class Car(
    @Column(name = "car_type")
    var carType: String,
    @Column(name = "company")
    var company: String,
    @Column(name = "model_name")
    var modelName: String,
    @Column(name = "grade")
    var grade: String,
    @Column(name = "grade_detail")
    var gradeDetail: String,
    @Column(name = "year")
    var year: Int,
    @Column(name = "distance")
    var distance: Int,
    @Column(name = "displacement")
    var displacement: Int,
    @Column(name = "fuel_type")
    var fuelType: String,
) {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()

    @OneToOne(mappedBy = "car")
    lateinit var usedCar: UsedCar
}
