package sundaystudy.kr.usedcar.module.usedcar.dto.response

import jakarta.persistence.Column

data class CarResponse(
    var carType: String,
    var company: String,
    var modelName: String,
    var grade: String,
    var gradeDetail: String,
    var year: Int,
    var distance: Int,
    var displacement: Int,
    var fuelType: String
)
