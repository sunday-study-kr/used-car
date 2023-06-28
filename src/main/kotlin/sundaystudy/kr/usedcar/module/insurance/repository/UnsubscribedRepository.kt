package sundaystudy.kr.usedcar.module.insurance.repository

import org.springframework.data.jpa.repository.JpaRepository
import sundaystudy.kr.usedcar.module.insurance.entity.Unsubscribed
import java.util.UUID

interface UnsubscribedRepository : JpaRepository<Unsubscribed, UUID>
