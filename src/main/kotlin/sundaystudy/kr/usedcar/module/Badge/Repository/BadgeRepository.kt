package sundaystudy.kr.usedcar.module.Badge.Repository

import org.springframework.data.jpa.repository.JpaRepository
import sundaystudy.kr.usedcar.module.Badge.Entity.Badge
import java.util.UUID

interface BadgeRepository: JpaRepository<Badge, UUID>
