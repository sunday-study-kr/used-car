package sundaystudy.kr.usedcar.module.Car.Repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sundaystudy.kr.usedcar.module.Car.Entity.UsedCar
import java.util.UUID

@Repository
interface UsedCarRepository : JpaRepository<UsedCar,UUID> {
}
