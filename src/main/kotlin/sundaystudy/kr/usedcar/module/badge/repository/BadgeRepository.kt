package sundaystudy.kr.usedcar.module.badge.repository

import org.springframework.data.jpa.repository.JpaRepository
import sundaystudy.kr.usedcar.module.badge.entity.Badge
import java.util.UUID

interface BadgeRepository : JpaRepository<Badge, UUID>
