package sundaystudy.kr.usedcar.module.insurance.repository

import org.springframework.data.jpa.repository.JpaRepository
import sundaystudy.kr.usedcar.module.insurance.entity.ChangeNumber
import java.util.UUID

interface ChangeNumberRepository : JpaRepository<ChangeNumber, UUID>
