package sundaystudy.kr.usedcar.module.usedcar.dto.request
import jakarta.validation.constraints.NotNull
import sundaystudy.kr.usedcar.module.usedcar.dto.detail.*
import java.util.*

data class InsuranceRequest(
    @field:NotNull
    val isLoss: Boolean,
    @field:NotNull
    val isSteal: Boolean,
    @field:NotNull
    val isWater: Boolean,
    @field:NotNull
    val isRent: Boolean,
    @field:NotNull
    val isSales: Boolean,
    @field:NotNull
    val isPublic: Boolean,
    var changeNumber : List<ChangeNumberDetail>,
    var changeOwner : List<ChangeOwnerDetail>,
    var opponentAccident : List<AccidentDetail>,
    var ownerAccident : List<AccidentDetail>,
    var unsubscribed : List<UnsubscribedDetail>
)
