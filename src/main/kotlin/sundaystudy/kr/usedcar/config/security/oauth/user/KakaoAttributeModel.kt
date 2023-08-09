package sundaystudy.kr.usedcar.config.security.oauth.user

import org.springframework.stereotype.Component
import sundaystudy.kr.usedcar.config.security.oauth.OAuth2Request
import sundaystudy.kr.usedcar.module.member.entity.AuthProvider

@Component
class KakaoAttributeModel: AttributeModel {
    override fun mapToRequest(attributes: MutableMap<String?, Any?>): OAuth2Request =
        OAuth2Request(attributes["id"].toString(), AuthProvider.KAKAO)
}
