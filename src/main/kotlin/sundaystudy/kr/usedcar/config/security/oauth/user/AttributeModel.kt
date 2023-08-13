package sundaystudy.kr.usedcar.config.security.oauth.user

import sundaystudy.kr.usedcar.config.security.oauth.OAuth2Request

interface AttributeModel {
    fun mapToRequest(attributes: MutableMap<String?, Any?>): OAuth2Request
}
