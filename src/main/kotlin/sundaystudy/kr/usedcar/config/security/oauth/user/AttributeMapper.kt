package sundaystudy.kr.usedcar.config.security.oauth.user

import org.springframework.stereotype.Component
import sundaystudy.kr.usedcar.config.security.oauth.OAuth2Request
import sundaystudy.kr.usedcar.module.member.entity.AuthProvider

@Component
class AttributeMapper(
    private val attributeModelFactory: AttributeModelFactory
) {
    fun mapToRequest(provider: AuthProvider, attributes: MutableMap<String?, Any?>): OAuth2Request? =
        attributeModelFactory.getAttributeModel(provider)?.mapToRequest(attributes)
}
