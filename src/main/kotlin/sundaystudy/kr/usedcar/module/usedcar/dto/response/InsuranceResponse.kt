package sundaystudy.kr.usedcar.module.usedcar.dto.response

import sundaystudy.kr.usedcar.module.usedcar.dto.detail.*

data class InsuranceResponse(
    val isLoss: Boolean,
    val isSteal: Boolean,
    val isWater: Boolean,
    val isRent: Boolean,
    val isSales: Boolean,
    val isPublic: Boolean,
    var changeNumber: MutableList<ChangeNumberDetail>,
    var changeOwner: MutableList<ChangeOwnerDetail>,
    var opponentAccident: MutableList<AccidentDetail>,
    var ownerAccident: MutableList<AccidentDetail>,
    var unsubscribed: MutableList<UnsubscribedDetail>
)
