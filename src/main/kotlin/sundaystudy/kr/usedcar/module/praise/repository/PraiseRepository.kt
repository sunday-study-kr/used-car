package sundaystudy.kr.usedcar.module.praise.repository

import org.springframework.data.jpa.repository.JpaRepository
import sundaystudy.kr.usedcar.module.praise.entity.Praise
import java.util.UUID

interface PraiseRepository: JpaRepository<Praise, UUID>
