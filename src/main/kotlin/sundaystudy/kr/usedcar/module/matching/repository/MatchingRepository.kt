package sundaystudy.kr.usedcar.module.matching.repository

import org.springframework.data.jpa.repository.JpaRepository
import sundaystudy.kr.usedcar.module.matching.entity.Matching
import java.util.UUID

interface MatchingRepository : JpaRepository<Matching, UUID>
