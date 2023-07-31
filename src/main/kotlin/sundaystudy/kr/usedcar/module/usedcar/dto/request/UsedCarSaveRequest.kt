package sundaystudy.kr.usedcar.module.usedcar.dto.request

data class UsedCarSaveRequest(
    var licenseNumber: String,
    var price: Int,
    var savePrice: Int,
    var carSaveRequest: CarSaveRequest,
    var insurance : InsuranceRequest
)
