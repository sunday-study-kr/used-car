package sundaystudy.kr.usedcar.module.usedcar.exception

import jakarta.persistence.EntityNotFoundException

class UsedCarNotFoundException(override val message: String = "해당 UsedCar 데이터가 존재하지 않습니다.") :
    EntityNotFoundException(message)
