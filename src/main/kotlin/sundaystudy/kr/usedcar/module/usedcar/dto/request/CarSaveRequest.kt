package sundaystudy.kr.usedcar.module.usedcar.dto.request

import jakarta.validation.constraints.NotNull

data class CarSaveRequest(
    @field:NotNull
    var carType : String,
    @field:NotNull
    var company: String,
    @field:NotNull
    var modelName: String,
    @field:NotNull
    var grade: String,
    @field:NotNull
    var gradeDetail: String,
    @field:NotNull
    var year: Int,
    @field:NotNull
    var distance: Int,
    @field:NotNull
    var displacement: Int,
    @field:NotNull
    var fuelType: String
)
