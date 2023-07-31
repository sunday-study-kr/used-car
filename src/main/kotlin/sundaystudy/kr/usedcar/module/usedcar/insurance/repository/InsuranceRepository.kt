package sundaystudy.kr.usedcar.module.usedcar.insurance.repository

import org.springframework.data.jpa.repository.JpaRepository
import sundaystudy.kr.usedcar.module.usedcar.insurance.entity.Insurance
import java.util.*

interface InsuranceRepository : JpaRepository<Insurance, UUID> {
    override fun findById(id: UUID): Optional<Insurance>
}
