package sundaystudy.kr.usedcar.module.usedcar.insurance.repository

import org.springframework.data.jpa.repository.JpaRepository
import sundaystudy.kr.usedcar.module.usedcar.insurance.entity.OpponentAccident
import java.util.UUID

interface OpponentAccidentRepository : JpaRepository<OpponentAccident, UUID>
