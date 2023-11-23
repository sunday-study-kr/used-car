package sundaystudy.kr.usedcar.support.application

import org.junit.jupiter.api.BeforeEach
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import sundaystudy.kr.usedcar.module.member.entity.AuthProvider
import sundaystudy.kr.usedcar.module.member.entity.Member
import sundaystudy.kr.usedcar.module.member.entity.OAuth2Details
import sundaystudy.kr.usedcar.module.member.repository.MemberRepository
import sundaystudy.kr.usedcar.module.member.service.AuthService

@DatabaseTest
abstract class LoginTest {

    @MockBean
    protected lateinit var authService: AuthService

    @Autowired
    protected lateinit var memberRepository: MemberRepository
    protected lateinit var loginUser: Member

    @BeforeEach
    fun setup() {
        val member = Member(OAuth2Details("123456789", AuthProvider.KAKAO))
        loginUser = memberRepository.save(member)
        `when`(authService.getLoginUser()).thenReturn(loginUser)
    }
}
