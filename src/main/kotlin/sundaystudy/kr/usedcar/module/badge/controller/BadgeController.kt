package sundaystudy.kr.usedcar.module.badge.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sundaystudy.kr.usedcar.module.badge.dto.response.BadgeResponse
import sundaystudy.kr.usedcar.module.badge.service.BadgeService
import java.util.*

@RestController
@RequestMapping("badges")
class BadgeController(
    private val badgeService: BadgeService,
) {
    @PostMapping("{id}")
    fun selectRepresentBadge(id: UUID) =
        badgeService.selectRepresentBadge(id)

    @GetMapping
    fun getAllBadges(): List<BadgeResponse> =
        badgeService.getAllBadges()
}
