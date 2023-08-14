package sundaystudy.kr.usedcar.module.usedcar.service

import UsedCarResponse
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import sundaystudy.kr.usedcar.global.dto.IdResponse
import sundaystudy.kr.usedcar.module.usedcar.dto.detail.*
import sundaystudy.kr.usedcar.module.usedcar.dto.request.CarSaveRequest
import sundaystudy.kr.usedcar.module.usedcar.dto.request.InsuranceRequest
import sundaystudy.kr.usedcar.module.usedcar.dto.request.UsedCarSaveRequest
import sundaystudy.kr.usedcar.module.usedcar.dto.response.CarResponse
import sundaystudy.kr.usedcar.module.usedcar.dto.response.InsuranceResponse
import sundaystudy.kr.usedcar.module.usedcar.entity.*
import sundaystudy.kr.usedcar.module.usedcar.repository.UsedCarRepository
import java.util.UUID

@Service
class UsedCarService(
    private val usedCarRepository: UsedCarRepository
) {
    @Transactional
    fun saveUsedCar(usedCarSaveRequest: UsedCarSaveRequest) : IdResponse {
        var usedCar = UsedCar(usedCarSaveRequest.licenseNumber,usedCarSaveRequest.price,usedCarSaveRequest.savePrice)

        var car : Car  = usedCarSaveRequest.carSaveRequest.toCar()
        var insurance : Insurance = usedCarSaveRequest.insurance.toInsurance()

        for(request in usedCarSaveRequest.insurance.changeNumber){
            insurance.addChangeNumber(request.toChangeNumber())
        }

        for(request in usedCarSaveRequest.insurance.changeOwner){
            insurance.addChangeOwner(request.toChangeOwner())
        }

        for(request in usedCarSaveRequest.insurance.ownerAccident){
            insurance.addOwnerAccident(request.toOwnerAccident())
        }

        for(request in usedCarSaveRequest.insurance.opponentAccident){
            insurance.addOpponentAccident(request.toOpponentAccident())
        }

        for(request in usedCarSaveRequest.insurance.unsubscribed){
            insurance.addUnsubscribed(request.toUnsubscribed())
        }

        usedCar.addCar(car)
        usedCar.addInsurance(insurance)

        usedCarRepository.save(usedCar)

        return IdResponse(usedCar.id)
    }

    fun getUsedCar(id : UUID) : UsedCarResponse
    {
        val usedCar = usedCarRepository.findById(id)

        if(usedCar.isEmpty)
            throw RuntimeException()

        val curUsedCar = usedCar.get()

        var insuranceResponse : InsuranceResponse = toInsuranceResponse(curUsedCar.insurance!!)

        var usedCarResponse : UsedCarResponse = UsedCarResponse(curUsedCar.licenseNumber,curUsedCar.price,curUsedCar.savePrice,curUsedCar.car!!.toDto(),insuranceResponse)

        return usedCarResponse
    }

    fun updateUsedCarInfo()
    {
        TODO("NOT YET")
    }

    fun updateUsedCarInsurance()
    {
        TODO("NOT YET")
    }


    fun deleteUsedCar(id : UUID)
    {
        TODO("NOT YET")
    }

    fun CarSaveRequest.toCar() = Car(carType, company, modelName, grade, gradeDetail, year, distance, displacement, fuelType)
    fun InsuranceRequest.toInsurance() = Insurance(isLoss, isSteal, isWater, isRent, isSales, isPublic)
    fun ChangeNumberDetail.toChangeNumber() = ChangeNumber(changeDay, changeName, isFirst)
    fun ChangeOwnerDetail.toChangeOwner() = ChangeOwner(changeDay)
    fun OpponentAccidentDetail.toOpponentAccident() = OpponentAccident(Day, partPrice, wagesPrice, coationPrice, totalPrice)
    fun OwnerAccidentDetail.toOwnerAccident() = OwnerAccident(Day, partPrice, wagesPrice, coationPrice, totalPrice)
    fun UnsubscribedDetail.toUnsubscribed() = Unsubscribed(startAt, endAt)

    fun Car.toDto() = CarResponse(carType, company, modelName, grade, gradeDetail, year, distance, displacement, fuelType)
    fun ChangeNumber.toDto() = ChangeNumberDetail(changeDay, changeName, isFirst)
    fun ChangeOwner.toDto() = ChangeOwnerDetail(changeDay)
    fun OpponentAccident.toDto() = OpponentAccidentDetail(Day, partPrice, wagesPrice, coationPrice, totalPrice)
    fun OwnerAccident.toDto() = OwnerAccidentDetail(Day, partPrice, wagesPrice, coationPrice, totalPrice)
    fun Unsubscribed.toDto() = UnsubscribedDetail(startAt, endAt)

    fun toInsuranceResponse(insurance : Insurance) : InsuranceResponse{
        var response : InsuranceResponse = InsuranceResponse(insurance.isLoss,insurance.isSteal,insurance.isWater,insurance.isRent,insurance.isSales,insurance.isPublic,
            mutableListOf(),mutableListOf(),mutableListOf(),mutableListOf(),mutableListOf()
        )

        for(cur in insurance.changeNumber){
            response.changeNumber.add(cur.toDto())
        }
        for(cur in insurance.changeOwner){
            response.changeOwner.add(cur.toDto())
        }
        for(cur in insurance.ownerAccident){
            response.ownerAccident.add(cur.toDto())
        }
        for(cur in insurance.unsubscribed){
            response.unsubscribed.add(cur.toDto())
        }
        for(cur in insurance.opponentAccident){
            response.opponentAccident.add(cur.toDto())
        }

        return response
    }
}
