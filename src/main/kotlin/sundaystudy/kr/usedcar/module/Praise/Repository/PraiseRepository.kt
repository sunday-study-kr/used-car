package sundaystudy.kr.usedcar.module.Praise.Repository

import org.springframework.data.jpa.repository.JpaRepository
import sundaystudy.kr.usedcar.module.Praise.Entity.Praise
import java.util.UUID

interface PraiseRepository: JpaRepository<Praise, UUID>
