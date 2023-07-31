package sundaystudy.kr.usedcar.module.usedcar.insurance.repository

import org.springframework.data.jpa.repository.JpaRepository
import sundaystudy.kr.usedcar.module.usedcar.insurance.entity.Unsubscribed
import java.util.UUID

interface UnsubscribedRepository : JpaRepository<Unsubscribed, UUID>
