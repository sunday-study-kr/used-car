package sundaystudy.kr.usedcar.module.badge.controller

import jakarta.validation.Valid
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
    fun selectRepresentBadge(@RequestBody @Valid representBadgeRequest: RepresentBadgeRequest): ResponseEntity<Unit> {
        badgeService.selectRepresentBadge(representBadgeRequest)
        return ResponseEntity.noContent().build()
    }

    @GetMapping
    fun getAllBadges(pageable: Pageable): ResponseEntity<List<BadgeResponse>> =
        ResponseEntity.ok(badgeService.getAllBadges(pageable))
}
