package sundaystudy.kr.usedcar.module.usedcar.mapper

import org.mapstruct.Mapper
import sundaystudy.kr.usedcar.module.usedcar.dto.detail.AccidentDetail
import sundaystudy.kr.usedcar.module.usedcar.dto.detail.ChangeNumberDetail
import sundaystudy.kr.usedcar.module.usedcar.dto.detail.ChangeOwnerDetail
import sundaystudy.kr.usedcar.module.usedcar.dto.detail.UnsubscribedDetail
import sundaystudy.kr.usedcar.module.usedcar.dto.request.CarSaveRequest
import sundaystudy.kr.usedcar.module.usedcar.dto.request.InsuranceRequest
import sundaystudy.kr.usedcar.module.usedcar.dto.response.CarResponse
import sundaystudy.kr.usedcar.module.usedcar.dto.response.InsuranceResponse
import sundaystudy.kr.usedcar.module.usedcar.entity.*

@Mapper
interface UsedCarMapper2 {
    fun toCar(request : CarSaveRequest) : Car

    fun toInsurance(request : InsuranceRequest) : Insurance

    fun toChangeNumber(request : ChangeNumberDetail) : ChangeNumber

    fun toChangeOwner(request: ChangeOwnerDetail) : ChangeOwner

    fun toOpponentAccident(request : AccidentDetail) : OpponentAccident

    fun toOwnerAccident(request : AccidentDetail) : OwnerAccident

    fun toUnsubscribed(request : UnsubscribedDetail) : Unsubscribed

    fun toCarResponse(car : Car) : CarResponse

    fun toChangeNumberDetail(changeNumber: ChangeNumber) : ChangeNumberDetail

    fun toChangeOwnerDetail(changeOwner: ChangeOwner) : ChangeOwnerDetail

    fun toOpponentAccidentDetail(opponentAccident: OpponentAccident) : AccidentDetail

    fun toOwnerAccidentDetail(ownerAccident: OwnerAccident) : AccidentDetail

    fun toUnsubscribedDetail(unsubscribed : Unsubscribed) : UnsubscribedDetail

    fun toInsuranceResponse(insurance : Insurance) : InsuranceResponse
}
