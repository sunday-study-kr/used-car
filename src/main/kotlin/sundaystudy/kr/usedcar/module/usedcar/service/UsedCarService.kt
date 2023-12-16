package sundaystudy.kr.usedcar.module.usedcar.service

import UsedCarResponse
import jakarta.persistence.EntityNotFoundException
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import sundaystudy.kr.usedcar.global.dto.IdResponse
import sundaystudy.kr.usedcar.module.usedcar.dto.request.*
import sundaystudy.kr.usedcar.module.usedcar.entity.UsedCar
import sundaystudy.kr.usedcar.module.usedcar.mapper.UsedCarMapper
import sundaystudy.kr.usedcar.module.usedcar.repository.UsedCarRepository
import java.util.*

@Service
class UsedCarService(
    private val usedCarRepository: UsedCarRepository,
    private val usedCarMapper: UsedCarMapper
) {
    @Transactional
    fun saveUsedCar(usedCarSaveRequest: UsedCarSaveRequest): IdResponse {
        val usedCar = usedCarMapper.toUsedCar(usedCarSaveRequest)
        usedCarRepository.save(usedCar)

        return IdResponse(usedCar.id)
    }

    fun getUsedCar(id: UUID): UsedCarResponse {
        val usedCar = getUsedCarEntity(id)

        return usedCarMapper.toResponse(usedCar)
    }

    @Transactional
    fun updateCarAccident(request: UpdateAccidentRequest) {
        val usedCar = getUsedCarEntity(request.id)

        if (request.accidentType == AccidentType.OWNER) {
            usedCar.insurance!!.addOwnerAccident(usedCarMapper.toOwnerAccident(request.accidentDetail))
            return
        }
        usedCar.insurance!!.addOpponentAccident(usedCarMapper.toOpponentAccident(request.accidentDetail))
    }

    @Transactional
    fun updateUnsubscribed(request: UpdateUnsubscribedRequest) {
        val usedCar = getUsedCarEntity(request.id)
        usedCar.insurance!!.addUnsubscribed(usedCarMapper.toUnsubscribed(request.detail))
    }

    @Transactional
    fun updateUsedCarInfo(request: UpdateUsedCarRequest) {
        val usedCar = getUsedCarEntity(request.id)

        usedCar.updatePrice(request.price, request.savePrice)
    }

    @Transactional
    fun deleteUsedCar(id: UUID) {
        getUsedCarEntity(id).delete()
    }

    fun getUsedCarEntity(id: UUID): UsedCar = usedCarRepository.findByIdOrNull(id) ?: throw EntityNotFoundException()
}
