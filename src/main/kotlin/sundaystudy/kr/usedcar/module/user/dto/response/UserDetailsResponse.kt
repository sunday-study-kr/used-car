package sundaystudy.kr.usedcar.module.user.dto.response

import java.util.*

data class UserDetailsResponse(
    var id: UUID,
    var nickname: String,
    var mannerTemperature: Double,
    var rateOfReDealing: Double,
    var responseRate: Double,
)
