package sundaystudy.kr.usedcar.module.usedcar.dto.request
import sundaystudy.kr.usedcar.module.usedcar.insurance.dto.request.InsuranceRequest
import java.util.UUID

data class UsedCarSaveRequest(
    var licenseNumber: String,
    var price: Int,
    var savePrice: Int,
    var carSaveRequest: CarSaveRequest,
    var insurance : InsuranceRequest
)
