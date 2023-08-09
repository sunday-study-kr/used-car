package sundaystudy.kr.usedcar.module.post.dto.request
import java.util.*

data class PostRequest(
    var memberId : UUID,
    var introduce: String,
    var dealAddress: String,
    var usedCarId : UUID
)
