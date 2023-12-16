package sundaystudy.kr.usedcar.module.usedcar.mapper

import UsedCarResponse
import org.springframework.stereotype.Component
import sundaystudy.kr.usedcar.module.usedcar.dto.detail.AccidentDetail
import sundaystudy.kr.usedcar.module.usedcar.dto.detail.ChangeNumberDetail
import sundaystudy.kr.usedcar.module.usedcar.dto.detail.ChangeOwnerDetail
import sundaystudy.kr.usedcar.module.usedcar.dto.detail.UnsubscribedDetail
import sundaystudy.kr.usedcar.module.usedcar.dto.request.CarSaveRequest
import sundaystudy.kr.usedcar.module.usedcar.dto.request.InsuranceRequest
import sundaystudy.kr.usedcar.module.usedcar.dto.request.UsedCarSaveRequest
import sundaystudy.kr.usedcar.module.usedcar.dto.response.CarResponse
import sundaystudy.kr.usedcar.module.usedcar.dto.response.InsuranceResponse
import sundaystudy.kr.usedcar.module.usedcar.entity.*

@Component
class UsedCarMapper {
    fun toCar(request: CarSaveRequest, usedCar: UsedCar): Car =
        Car(
            request.carType,
            request.company,
            request.modelName,
            request.grade,
            request.gradeDetail,
            request.year,
            request.distance,
            request.displacement,
            request.fuelType,
            usedCar
        )

    fun toInsurance(request: InsuranceRequest, usedCar: UsedCar): Insurance {
        return Insurance(
            request.isLoss,
            request.isSteal,
            request.isWater,
            request.isRent,
            request.isSales,
            request.isPublic,
            request.unsubscribed.map(this::toUnsubscribed).toMutableList(),
            request.ownerAccident.map(this::toOwnerAccident).toMutableList(),
            request.opponentAccident.map(this::toOpponentAccident).toMutableList(),
            request.changeOwner.map(this::toChangeOwner).toMutableList(),
            request.changeNumber.map(this::toChangeNumber).toMutableList(),
            usedCar
        )
    }

    fun toChangeNumber(request: ChangeNumberDetail): ChangeNumber =
        ChangeNumber(request.changeDay, request.changeName, request.isFirst)

    fun toChangeOwner(request: ChangeOwnerDetail): ChangeOwner =
        ChangeOwner(request.changeDay)

    fun toOpponentAccident(request: AccidentDetail): OpponentAccident =
        OpponentAccident(
            request.Day,
            request.partPrice,
            request.wagesPrice,
            request.coationPrice,
            request.totalPrice
        )

    fun toOwnerAccident(request: AccidentDetail): OwnerAccident =
        OwnerAccident(
            request.Day,
            request.partPrice,
            request.wagesPrice,
            request.coationPrice,
            request.totalPrice
        )

    fun toUnsubscribed(request: UnsubscribedDetail): Unsubscribed =
        Unsubscribed(request.startAt, request.endAt)

    fun toCarResponse(car: Car): CarResponse =
        CarResponse(
            car.carType,
            car.company,
            car.modelName,
            car.grade,
            car.gradeDetail,
            car.year,
            car.distance,
            car.displacement,
            car.fuelType
        )

    fun toChangeNumberDetail(changeNumber: ChangeNumber): ChangeNumberDetail =
        ChangeNumberDetail(changeNumber.changeDay, changeNumber.changeName, changeNumber.isFirst)

    fun toChangeOwnerDetail(changeOwner: ChangeOwner): ChangeOwnerDetail =
        ChangeOwnerDetail(changeOwner.changeDay)


    fun toOpponentAccidentDetail(opponentAccident: OpponentAccident): AccidentDetail {
        return AccidentDetail(
            opponentAccident.Day,
            opponentAccident.partPrice,
            opponentAccident.wagesPrice,
            opponentAccident.coationPrice,
            opponentAccident.totalPrice
        )
    }

    fun toOwnerAccidentDetail(ownerAccident: OwnerAccident): AccidentDetail =
        AccidentDetail(
            ownerAccident.Day,
            ownerAccident.partPrice,
            ownerAccident.wagesPrice,
            ownerAccident.coationPrice,
            ownerAccident.totalPrice
        )

    fun toUnsubscribedDetail(unsubscribed: Unsubscribed): UnsubscribedDetail {
        return UnsubscribedDetail(unsubscribed.startAt, unsubscribed.endAt)
    }

    fun toInsuranceResponse(insurance: Insurance): InsuranceResponse =
        InsuranceResponse(
            insurance.isLoss,
            insurance.isSteal,
            insurance.isWater,
            insurance.isRent,
            insurance.isSales,
            insurance.isPublic,
            insurance.changeNumber.map(this::toChangeNumberDetail),
            insurance.changeOwner.map(this::toChangeOwnerDetail),
            insurance.ownerAccident.map(this::toOwnerAccidentDetail),
            insurance.opponentAccident.map(this::toOpponentAccidentDetail),
            insurance.unsubscribed.map(this::toUnsubscribedDetail)
        )

    fun toResponse(usedCar: UsedCar): UsedCarResponse =
        UsedCarResponse(
            usedCar.licenseNumber,
            usedCar.price,
            usedCar.savePrice,
            toCarResponse(usedCar.car!!),
            toInsuranceResponse(usedCar.insurance!!)
        )

    fun toUsedCar(usedCarSaveRequest: UsedCarSaveRequest): UsedCar {
        val usedCar = UsedCar(usedCarSaveRequest.licenseNumber, usedCarSaveRequest.price, usedCarSaveRequest.savePrice)
        toCar(usedCarSaveRequest.carSaveRequest, usedCar)
        toInsurance(usedCarSaveRequest.insurance, usedCar)
        return usedCar
    }
}
