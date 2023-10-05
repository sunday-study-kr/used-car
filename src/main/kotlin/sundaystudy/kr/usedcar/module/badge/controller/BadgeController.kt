package sundaystudy.kr.usedcar.module.badge.controller

import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import sundaystudy.kr.usedcar.module.badge.dto.request.RepresentBadgeRequest
import sundaystudy.kr.usedcar.module.badge.dto.response.BadgeResponse
import sundaystudy.kr.usedcar.module.badge.service.BadgeService

@RestController
@RequestMapping("badges")
class BadgeController(
    private val badgeService: BadgeService,
) {
    @PostMapping
    fun selectRepresentBadge(@RequestBody representBadgeRequest: RepresentBadgeRequest): ResponseEntity<Any> {
        badgeService.selectRepresentBadge(representBadgeRequest)
        return ResponseEntity.noContent().build()
    }

    @GetMapping
    fun getAllBadges(pageable: Pageable): ResponseEntity<List<BadgeResponse>> =
        ResponseEntity.ok(badgeService.getAllBadges(pageable))
}
