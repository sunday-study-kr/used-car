package sundaystudy.kr.usedcar.module.member.dto.response

import java.util.*

data class MemberDetailsResponse(
    var id: UUID,
    var nickname: String?,
    var mannerTemperature: Double,
    var rateOfReDealing: Double,
    var responseRate: Double,
)
