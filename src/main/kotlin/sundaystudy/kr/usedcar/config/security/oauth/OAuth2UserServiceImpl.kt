package sundaystudy.kr.usedcar.config.security.oauth

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Service
import sundaystudy.kr.usedcar.config.security.oauth.user.AttributeMapper
import sundaystudy.kr.usedcar.module.member.entity.AuthProvider
import sundaystudy.kr.usedcar.module.member.service.MemberService
import java.util.*

@Service
class OAuth2UserServiceImpl(
    private val memberService: MemberService,
    private val attributeMapper: AttributeMapper,
    private val principleMapper: PrincipleMapper
) : DefaultOAuth2UserService() {

    override fun loadUser(userRequest: OAuth2UserRequest?): OAuth2User? {
        val attributes = super.loadUser(userRequest).attributes
        val authProvider: AuthProvider = AuthProvider.valueOf(
            userRequest!!.clientRegistration.clientName.uppercase(Locale.getDefault())
        )

        val oAuth2Request = attributes?.let {
            attributeMapper.mapToRequest(authProvider, it)
        }

        val member = oAuth2Request?.let {
            memberService.saveIfNone(oAuth2Request)
        }

        return member?.let { principleMapper.mapToUserPrinciple(it) }
    }
}
