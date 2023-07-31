package sundaystudy.kr.usedcar.module.usedcar.service

import UsedCarResponse
import org.springframework.stereotype.Service
import sundaystudy.kr.usedcar.global.dto.IdResponse
import sundaystudy.kr.usedcar.module.usedcar.dto.request.UsedCarSaveRequest
import sundaystudy.kr.usedcar.module.usedcar.repository.UsedCarRepository
import java.util.UUID

@Service
class UsedCarService(
    private val usedCarRepository: UsedCarRepository,
) {

    fun saveUsedCar(usedCarSaveRequest: UsedCarSaveRequest) : IdResponse
    {
        TODO("NOT YET")
    }

    fun getUsedCar(id : UUID) : UsedCarResponse
    {
        TODO("NOT YET")
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
