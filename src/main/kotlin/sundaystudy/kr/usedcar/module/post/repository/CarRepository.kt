package sundaystudy.kr.usedcar.module.post.repository

import org.springframework.data.jpa.repository.JpaRepository
import sundaystudy.kr.usedcar.module.post.entity.Car
import java.util.UUID

interface CarRepository : JpaRepository<Car, UUID>
