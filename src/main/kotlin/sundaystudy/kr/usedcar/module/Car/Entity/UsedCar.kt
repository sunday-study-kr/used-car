package sundaystudy.kr.usedcar.module.Car.Entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "used_car")
class UsedCar {

    @Id
    val id : UUID = UUID.randomUUID()
}
