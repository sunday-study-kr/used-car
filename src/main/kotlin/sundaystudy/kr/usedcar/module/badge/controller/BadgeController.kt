package sundaystudy.kr.usedcar.module.badge.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import sundaystudy.kr.usedcar.module.badge.dto.response.BadgeResponse
import sundaystudy.kr.usedcar.module.badge.service.BadgeService
import java.util.*

@RestController
@RequestMapping("badges")
class BadgeController(
    private val badgeService: BadgeService,
) {
    @PostMapping("{id}")
    fun selectRepresentBadge(@PathVariable id: UUID): ResponseEntity<Any> {
        badgeService.selectRepresentBadge(id)
        return ResponseEntity.ok().build()
    }

    @GetMapping
    fun getAllBadges(): ResponseEntity<List<BadgeResponse>> =
        ResponseEntity.ok(badgeService.getAllBadges())
}
