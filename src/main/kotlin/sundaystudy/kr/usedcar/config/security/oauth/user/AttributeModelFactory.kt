package sundaystudy.kr.usedcar.config.security.oauth.user

import org.springframework.stereotype.Component
import sundaystudy.kr.usedcar.module.member.entity.AuthProvider
import java.util.*


@Component
class AttributeModelFactory(
    private val kakaoAttributeModel: KakaoAttributeModel,
    private val googleAttributeModel: GoogleAttributeModel
) {
    private val mapperMap: EnumMap<AuthProvider, AttributeModel> = EnumMap(AuthProvider::class.java)

    init {
        mapperMap[AuthProvider.GOOGLE] = googleAttributeModel
        mapperMap[AuthProvider.KAKAO] = kakaoAttributeModel
    }

    fun getAttributeModel(authProvider: AuthProvider): AttributeModel? =
        mapperMap[authProvider]
}
