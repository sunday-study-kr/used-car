package sundaystudy.kr.usedcar.module.badge.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import sundaystudy.kr.usedcar.module.badge.dto.request.RepresentBadgeRequest
import sundaystudy.kr.usedcar.module.badge.entity.Badge
import sundaystudy.kr.usedcar.module.badge.repository.BadgeRepository
import sundaystudy.kr.usedcar.support.application.LoginTest

@DisplayName("Badge 서비스에")
class BadgeServiceTest: LoginTest() {

    @Autowired private lateinit var badgeService: BadgeService
    @Autowired private lateinit var badgeRepository: BadgeRepository

    @Test
    @DisplayName("대표 뱃지 등록시 대표 뱃지로 수정된다.")
    fun selectRepresentBadge() {
        // given
        badgeRepository.save(Badge("칭찬해요", loginUser))
        val id = badgeRepository.save(Badge("칭찬합니다", loginUser)).id

        // when
        badgeService.selectRepresentBadge(RepresentBadgeRequest(id))

        // then
        val result = badgeRepository.findByIdOrNull(id)
        assertThat(result!!.isRepresent).isTrue()
    }

    @Test
    @DisplayName("유저에 대한 모든 뱃지 조회시 저장된 뱃지들이 조회된다")
    fun getAllBadges() {
        // given
        val expected = listOf(Badge("칭찬해요", loginUser), Badge("칭찬합니다", loginUser))
        badgeRepository.saveAll(expected)

        // when
        val result = badgeService.getAllBadges(PageRequest.of(0, 20))

        // then
        assertThat(result).hasSize(expected.size)
    }
}
