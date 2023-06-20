package sundaystudy.kr.usedcar.module.Insurance.Repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sundaystudy.kr.usedcar.module.Insurance.Entity.Insurance
import java.util.*

@Repository
interface InsuranceRepository : JpaRepository<Insurance,UUID> {
    override fun findById(id: UUID): Optional<Insurance>
}
