package sundaystudy.kr.usedcar.module.usedcar.service

import UsedCarResponse
import jakarta.persistence.EntityNotFoundException
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import sundaystudy.kr.usedcar.global.dto.IdResponse
import sundaystudy.kr.usedcar.module.usedcar.dto.detail.UnsubscribedDetail
import sundaystudy.kr.usedcar.module.usedcar.dto.request.*
import sundaystudy.kr.usedcar.module.usedcar.dto.response.InsuranceResponse
import sundaystudy.kr.usedcar.module.usedcar.entity.*
import sundaystudy.kr.usedcar.module.usedcar.exception.UsedCarNotFoundException
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
        val usedCar = getUsedCarEntity(id)

        var insuranceResponse : InsuranceResponse = usedCarMapper.toInsuranceResponse(usedCar.insurance!!)

        var usedCarResponse : UsedCarResponse = UsedCarResponse(usedCar.licenseNumber,usedCar.price,usedCar.savePrice,usedCarMapper.toCarResponse(usedCar.car!!),insuranceResponse)

        return usedCarResponse
    }
    @Transactional
    fun updateCarAccident(request: UpdateAccidentRequest)
    {
        val usedCar =  getUsedCarEntity(request.id)

        if(request.accidentType == AccidentType.OWNER){
            usedCar.insurance!!.addOwnerAccident(usedCarMapper.toOwnerAccident(request.accidentDetail))
        }else{
            usedCar.insurance!!.addOpponentAccident(usedCarMapper.toOpponentAccident(request.accidentDetail))
        }
    }

    @Transactional
    fun updateUnsubscribed(request : UpdateUnsubscribedRequest){
        val usedCar = getUsedCarEntity(request.id)
        usedCar.insurance!!.addUnsubscribed(usedCarMapper.toUnsubscribed(request.detail))
    }

    @Transactional
    fun updateUsedCarInfo(request : UpdateUsedCarRequest)
    {
        val usedCar = getUsedCarEntity(request.id)

        usedCar.price = request.price
        usedCar.savePrice = request.savePrice
    }

    @Transactional
    fun deleteUsedCar(id : UUID)
    {
        usedCarRepository.getReferenceById(id).delete()
    }

    private fun getUsedCarEntity(id : UUID) : UsedCar = usedCarRepository.findByIdOrNull(id) ?: throw EntityNotFoundException()
}

