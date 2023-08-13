package sundaystudy.kr.usedcar.module.matching.entity

import jakarta.persistence.*
import sundaystudy.kr.usedcar.global.audit.Auditable
import sundaystudy.kr.usedcar.global.audit.BaseTime
import sundaystudy.kr.usedcar.module.member.entity.Member
import sundaystudy.kr.usedcar.module.post.entity.Post

@Entity
class Matching(
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private val id: String,
) : Auditable {

    @ManyToOne
    var post: Post? = null

    @ManyToOne
    @JoinColumn(name = "match_request_member_id")
    var requestMember: Member? = null

    @ManyToOne
    @JoinColumn(name = "post_member_id")
    var postOwner: Member? = null

    @Embedded
    override var baseTime: BaseTime = BaseTime()
}
