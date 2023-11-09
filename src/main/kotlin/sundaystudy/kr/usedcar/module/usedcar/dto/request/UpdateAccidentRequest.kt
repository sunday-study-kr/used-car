package sundaystudy.kr.usedcar.module.usedcar.dto.request
import jakarta.validation.constraints.NotNull
import sundaystudy.kr.usedcar.module.usedcar.dto.detail.AccidentDetail
import java.util.*

data class UpdateAccidentRequest(
    @field:NotNull
    var id : UUID,
    @field:NotNull
    var accidentType: AccidentType,
    @field:NotNull
    var accidentDetail: AccidentDetail
)
