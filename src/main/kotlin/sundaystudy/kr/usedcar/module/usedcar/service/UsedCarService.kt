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
import sundaystudy.kr.usedcar.module.usedcar.mapper.UsedCarMapper
import sundaystudy.kr.usedcar.module.usedcar.repository.UsedCarRepository
import java.util.UUID

@Service
class UsedCarService(
    private val usedCarRepository: UsedCarRepository,
    private val usedCarMapper: UsedCarMapper
) {
    @Transactional
    fun saveUsedCar(usedCarSaveRequest: UsedCarSaveRequest) : IdResponse {
        var usedCar = UsedCar(usedCarSaveRequest.licenseNumber,usedCarSaveRequest.price,usedCarSaveRequest.savePrice)
        var car : Car  = usedCarMapper.toCar(usedCarSaveRequest.carSaveRequest)

        var tmpInsurance = usedCarSaveRequest.insurance

        var insurance : Insurance = usedCarMapper.toInsurance(tmpInsurance)

        for(request in tmpInsurance.changeNumber){
            insurance.addChangeNumber(usedCarMapper.toChangeNumber(request))
        }

        for(request in tmpInsurance.changeOwner){
            insurance.addChangeOwner(usedCarMapper.toChangeOwner(request))
        }

        for(request in tmpInsurance.ownerAccident){
            insurance.addOwnerAccident(usedCarMapper.toOwnerAccident(request))
        }

        for(request in tmpInsurance.opponentAccident){
            insurance.addOpponentAccident(usedCarMapper.toOpponentAccident(request))
        }

        for(request in tmpInsurance.unsubscribed){
            insurance.addUnsubscribed(usedCarMapper.toUnsubscribed(request))
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

        var insuranceResponse : InsuranceResponse = usedCarMapper.toInsuranceResponse(curUsedCar.insurance!!)

        var usedCarResponse : UsedCarResponse = UsedCarResponse(curUsedCar.licenseNumber,curUsedCar.price,curUsedCar.savePrice,usedCarMapper.toCarResponse(curUsedCar.car!!),insuranceResponse)

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
}
