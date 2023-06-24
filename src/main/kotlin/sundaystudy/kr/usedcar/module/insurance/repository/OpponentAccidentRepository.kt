package sundaystudy.kr.usedcar.module.insurance.repository

import org.springframework.data.jpa.repository.JpaRepository
import sundaystudy.kr.usedcar.module.insurance.entity.OpponentAccident
import java.util.UUID

interface OpponentAccidentRepository : JpaRepository<OpponentAccident,UUID> {
}
