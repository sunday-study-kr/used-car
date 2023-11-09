package sundaystudy.kr.usedcar.module.usedcar.dto.request

import jakarta.validation.constraints.NotNull

data class UsedCarSaveRequest(
    @field:NotNull
    var licenseNumber: String,
    @field:NotNull
    var price: Int,
    @field:NotNull
    var savePrice: Int,
    @field:NotNull
    var carSaveRequest: CarSaveRequest,
    @field:NotNull
    var insurance : InsuranceRequest
)
