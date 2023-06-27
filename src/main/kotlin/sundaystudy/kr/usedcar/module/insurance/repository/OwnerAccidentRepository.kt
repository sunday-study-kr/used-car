package sundaystudy.kr.usedcar.module.insurance.repository

import org.springframework.data.jpa.repository.JpaRepository
import sundaystudy.kr.usedcar.module.insurance.entity.OwnerAccident
import java.util.UUID

interface OwnerAccidentRepository : JpaRepository<OwnerAccident,UUID> {
}
