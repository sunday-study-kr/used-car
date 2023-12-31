package sundaystudy.kr.usedcar.module.usedcar.dto.request

import sundaystudy.kr.usedcar.module.usedcar.dto.detail.AccidentDetail
import java.util.*

data class UpdateAccidentRequest(
    var id: UUID,
    var accidentType: AccidentType,
    var accidentDetail: AccidentDetail
)
