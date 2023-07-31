import sundaystudy.kr.usedcar.module.usedcar.dto.response.CarResponse
import sundaystudy.kr.usedcar.module.usedcar.insurance.dto.response.InsuranceResponse

data class UsedCarResponse(
    var licenseNumber: String,
    var price: Int,
    var savePrice: Int,
    var carResponse: CarResponse,
    var insuranceDetail : InsuranceResponse
)
