package sundaystudy.kr.usedcar.module.Car.Repository

import org.springframework.data.jpa.repository.JpaRepository
import sundaystudy.kr.usedcar.module.Car.Entity.UsedCar
import java.util.UUID

interface UsedCarRepository : JpaRepository<UsedCar,UUID> {
}
