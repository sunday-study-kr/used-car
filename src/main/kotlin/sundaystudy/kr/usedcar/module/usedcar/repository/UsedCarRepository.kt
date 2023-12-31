package sundaystudy.kr.usedcar.module.usedcar.repository

import org.springframework.data.jpa.repository.JpaRepository
import sundaystudy.kr.usedcar.module.usedcar.entity.UsedCar
import java.util.*

interface UsedCarRepository : JpaRepository<UsedCar, UUID>
