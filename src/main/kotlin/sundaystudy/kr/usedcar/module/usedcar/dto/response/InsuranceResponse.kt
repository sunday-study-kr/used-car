package sundaystudy.kr.usedcar.module.usedcar.dto.response

import sundaystudy.kr.usedcar.module.usedcar.dto.detail.*

data class InsuranceResponse(
    val isLoss: Boolean,
    val isSteal: Boolean,
    val isWater: Boolean,
    val isRent: Boolean,
    val isSales: Boolean,
    val isPublic: Boolean,
    var changeNumber: List<ChangeNumberDetail>,
    var changeOwner: List<ChangeOwnerDetail>,
    var opponentAccident: List<OpponentAccidentDetail>,
    var ownerAccident: List<OwnerAccidentDetail>,
    var unsubscribed: List<UnsubscribedDetail>
)
