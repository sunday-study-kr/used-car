package sundaystudy.kr.usedcar.module.badge.service

import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import sundaystudy.kr.usedcar.global.exception.EntityNotFoundException
import sundaystudy.kr.usedcar.module.badge.dto.request.RepresentBadgeRequest
import sundaystudy.kr.usedcar.module.badge.dto.response.BadgeResponse
import sundaystudy.kr.usedcar.module.badge.entity.Badge
import sundaystudy.kr.usedcar.module.badge.mapper.BadgeMapper
import sundaystudy.kr.usedcar.module.badge.repository.BadgeRepository
import java.util.*

@Service
class BadgeService(
    private val badgeRepository: BadgeRepository,
    private val badgeMapper: BadgeMapper,
) {
    @Transactional
    fun selectRepresentBadge(representBadgeRequest: RepresentBadgeRequest) {
        val badge = getEntity(representBadgeRequest.id)
        badge.updateToRepresent()
    }

    fun getAllBadges(pageable: Pageable): List<BadgeResponse> =
        badgeMapper.toResponseList(badgeRepository.findAll(pageable).content)


    private fun getEntity(id: UUID): Badge =
        badgeRepository.findByIdOrNull(id)?: throw EntityNotFoundException()
}
