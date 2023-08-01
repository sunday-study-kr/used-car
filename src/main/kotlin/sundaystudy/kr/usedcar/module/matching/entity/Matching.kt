package sundaystudy.kr.usedcar.module.matching.entity

import jakarta.persistence.*
import sundaystudy.kr.usedcar.global.audit.Auditable
import sundaystudy.kr.usedcar.global.audit.BaseTime
import sundaystudy.kr.usedcar.module.usedcar.entity.Post
import sundaystudy.kr.usedcar.module.user.entity.User

@Entity
class Matching(
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private val id: String,
) : Auditable {

    @ManyToOne
    var post: Post? = null

    @ManyToOne
    @JoinColumn(name = "match_request_user_id")
    var requestUser: User? = null

    @ManyToOne
    @JoinColumn(name = "post_user_id")
    var postOwner: User? = null

    @Embedded
    override var baseTime: BaseTime = BaseTime()
}
