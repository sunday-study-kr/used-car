package sundaystudy.kr.usedcar.module.usedcar.repository

import org.springframework.data.jpa.repository.JpaRepository
import sundaystudy.kr.usedcar.module.usedcar.entity.Car
import java.util.UUID

interface CarRepository : JpaRepository<Car, UUID>
