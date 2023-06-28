package sundaystudy.kr.usedcar.module.post.repository

import org.springframework.data.jpa.repository.JpaRepository
import sundaystudy.kr.usedcar.module.post.entity.UsedCar
import java.util.UUID

interface UsedCarRepository : JpaRepository<UsedCar, UUID>
