package sundaystudy.kr.usedcar.module.badge.service

import org.springframework.stereotype.Service
import sundaystudy.kr.usedcar.module.badge.dto.response.BadgeResponse
import sundaystudy.kr.usedcar.module.badge.repository.BadgeRepository
import java.util.*

@Service
class BadgeService(
    private val badgeRepository: BadgeRepository,
) {
    fun selectRepresentBadge(id: UUID) {
        TODO("Not yet implemented")
    }

    fun getAllBadges(): List<BadgeResponse> {
        TODO("Not yet implemented")
    }
}
