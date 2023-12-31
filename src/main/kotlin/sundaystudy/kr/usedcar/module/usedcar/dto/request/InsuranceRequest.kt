package sundaystudy.kr.usedcar.module.usedcar.dto.request

import sundaystudy.kr.usedcar.module.usedcar.dto.detail.AccidentDetail
import sundaystudy.kr.usedcar.module.usedcar.dto.detail.ChangeNumberDetail
import sundaystudy.kr.usedcar.module.usedcar.dto.detail.ChangeOwnerDetail
import sundaystudy.kr.usedcar.module.usedcar.dto.detail.UnsubscribedDetail

data class InsuranceRequest(
    val isLoss: Boolean,
    val isSteal: Boolean,
    val isWater: Boolean,
    val isRent: Boolean,
    val isSales: Boolean,
    val isPublic: Boolean,
    var changeNumber: List<ChangeNumberDetail>,
    var changeOwner: List<ChangeOwnerDetail>,
    var ownerAccident: List<AccidentDetail>,
    var opponentAccident: List<AccidentDetail>,
    var unsubscribed: List<UnsubscribedDetail>
)
