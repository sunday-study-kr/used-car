package sundaystudy.kr.usedcar.module.usedcar.mapper

import org.springframework.stereotype.Component
import sundaystudy.kr.usedcar.module.usedcar.dto.detail.*
import sundaystudy.kr.usedcar.module.usedcar.dto.request.CarSaveRequest
import sundaystudy.kr.usedcar.module.usedcar.dto.request.InsuranceRequest
import sundaystudy.kr.usedcar.module.usedcar.dto.response.CarResponse
import sundaystudy.kr.usedcar.module.usedcar.dto.response.InsuranceResponse
import sundaystudy.kr.usedcar.module.usedcar.entity.*

@Component
class UsedCarMapper {
    fun toCar(request : CarSaveRequest) : Car{
        return Car(request.carType,request.company,request.modelName,request.grade,request.gradeDetail,request.year
        ,request.distance,request.displacement,request.fuelType)
    }

    fun toInsurance(request : InsuranceRequest) : Insurance{
        return Insurance(request.isLoss,request.isSteal,request.isWater,request.isRent,request.isSales,request.isPublic)
    }

    fun toChangeNumber(request : ChangeNumberDetail) : ChangeNumber{
        return ChangeNumber(request.changeDay,request.changeName,request.isFirst)
    }

    fun toChangeOwner(request: ChangeOwnerDetail) : ChangeOwner{
        return ChangeOwner(request.changeDay)
    }

    fun toOpponentAccident(request : OpponentAccidentDetail) : OpponentAccident{
        return OpponentAccident(request.Day,request.partPrice,request.wagesPrice,request.coationPrice,request.totalPrice)
    }

    fun toOwnerAccident(request : OwnerAccidentDetail) : OwnerAccident{
        return OwnerAccident(request.Day,request.partPrice,request.wagesPrice,request.coationPrice,request.totalPrice)
    }

    fun toUnsubscribed(request : UnsubscribedDetail) : Unsubscribed{
        return Unsubscribed(request.startAt,request.endAt)
    }

    fun toCarResponse(car : Car) : CarResponse{
        return CarResponse(car.carType,car.company,car.modelName,car.grade,car.gradeDetail,car.year,car.distance,car.displacement,car.fuelType)
    }

    fun toChangeNumberDetail(changeNumber: ChangeNumber) : ChangeNumberDetail{
        return ChangeNumberDetail(changeNumber.changeDay,changeNumber.changeName,changeNumber.isFirst)
    }

    fun toChangeOwnerDetail(changeOwner: ChangeOwner) : ChangeOwnerDetail{
        return ChangeOwnerDetail(changeOwner.changeDay)
    }

    fun toOpponentAccidentDetail(opponentAccident: OpponentAccident) : OpponentAccidentDetail{
        return OpponentAccidentDetail(opponentAccident.Day,opponentAccident.partPrice,opponentAccident.wagesPrice,opponentAccident.coationPrice,opponentAccident.totalPrice)
    }

    fun toOwnerAccidentDetail(ownerAccident: OwnerAccident) : OwnerAccidentDetail{
        return OwnerAccidentDetail(ownerAccident.Day,ownerAccident.partPrice,ownerAccident.wagesPrice,ownerAccident.coationPrice,ownerAccident.totalPrice)
    }

    fun toUnsubscribedDetail(unsubscribed : Unsubscribed) : UnsubscribedDetail{
        return UnsubscribedDetail(unsubscribed.startAt,unsubscribed.endAt)
    }

    fun toInsuranceResponse(insurance : Insurance) : InsuranceResponse {
        var response : InsuranceResponse = InsuranceResponse(insurance.isLoss,insurance.isSteal,insurance.isWater,insurance.isRent,insurance.isSales,insurance.isPublic,
            mutableListOf(),mutableListOf(),mutableListOf(),mutableListOf(),mutableListOf()
        )

        for(cur in insurance.changeNumber){
            response.changeNumber.add(toChangeNumberDetail(cur))
        }
        for(cur in insurance.changeOwner){
            response.changeOwner.add(toChangeOwnerDetail(cur))
        }
        for(cur in insurance.ownerAccident){
            response.ownerAccident.add(toOwnerAccidentDetail(cur))
        }
        for(cur in insurance.unsubscribed){
            response.unsubscribed.add(toUnsubscribedDetail(cur))
        }
        for(cur in insurance.opponentAccident){
            response.opponentAccident.add(toOpponentAccidentDetail(cur))
        }

        return response
    }
}
