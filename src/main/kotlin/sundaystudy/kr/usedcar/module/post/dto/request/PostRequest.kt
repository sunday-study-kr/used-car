package sundaystudy.kr.usedcar.module.post.dto.request
import java.util.UUID

data class PostRequest(
    var userId : UUID,
    var introduce: String,
    var dealAddress: String,
    var usedCarId : UUID
)
