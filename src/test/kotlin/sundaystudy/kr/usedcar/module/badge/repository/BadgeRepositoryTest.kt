package sundaystudy.kr.usedcar.module.badge.repository

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import sundaystudy.kr.usedcar.module.badge.entity.Badge
import sundaystudy.kr.usedcar.module.member.entity.AuthProvider
import sundaystudy.kr.usedcar.module.member.entity.Member
import sundaystudy.kr.usedcar.module.member.entity.OAuth2Details
import sundaystudy.kr.usedcar.module.member.repository.MemberRepository
import sundaystudy.kr.usedcar.support.infra.EnableJpaTest

@EnableJpaTest
@DisplayName("Badge 레포지토리에")
class BadgeRepositoryTest {

    @Autowired
    private lateinit var badgeRepository: BadgeRepository
    @Autowired
    private lateinit var memberRepository: MemberRepository

    @Test
    @DisplayName("id로 조회시 저장한 데이터가 조회된다")
    fun findByIdOrNull() {
        // given
        val member = memberRepository.save(Member(OAuth2Details("123", AuthProvider.GOOGLE)))
        val expected = badgeRepository.save(Badge("칭찬뱃지", member))

        // when
        val result = badgeRepository.findByIdOrNull(expected.id)

        // then
        assertThat(result).isEqualTo(expected)
    }

    @Test
    @DisplayName("전체 조회시 저장한 모든 데이터가 조회된다")
    fun findAll() {
        // given
        val member = memberRepository.save(Member(OAuth2Details("123", AuthProvider.GOOGLE)))

        val expected: List<Badge> = listOf(
            Badge("칭찬뱃지1", member),
            Badge("칭찬뱃지2", member),
            Badge("칭찬뱃지3", member),
            Badge("칭찬뱃지4", member)
        )
        badgeRepository.saveAll(expected)

        // when
        val result: List<Badge> = badgeRepository.findAll()

        // then
        assertThat(result).hasSize(expected.size)
    }
}
