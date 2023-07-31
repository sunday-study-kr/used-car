package sundaystudy.kr.usedcar.module.usedcar.insurance.repository

import org.springframework.data.jpa.repository.JpaRepository
import sundaystudy.kr.usedcar.module.usedcar.insurance.entity.ChangeNumber
import java.util.UUID

interface ChangeNumberRepository : JpaRepository<ChangeNumber, UUID>
