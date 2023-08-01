package sundaystudy.kr.usedcar.module.post.dto.response
import java.util.UUID

data class PostResponse(
    var id : UUID,
    var userId : UUID,
    var usedCarId : UUID,
    var chat: Int,
    var focus: Int,
    var look: Int,
    var introduce: String,
    var dealAddress: String
)
