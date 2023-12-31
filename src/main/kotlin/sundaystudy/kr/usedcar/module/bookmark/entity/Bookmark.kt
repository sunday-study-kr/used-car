package sundaystudy.kr.usedcar.module.bookmark.entity

import jakarta.persistence.*
import sundaystudy.kr.usedcar.global.audit.Auditable
import sundaystudy.kr.usedcar.global.audit.BaseTime
import sundaystudy.kr.usedcar.module.member.entity.Member
import sundaystudy.kr.usedcar.module.post.entity.Post
import java.util.*

@Entity
class Bookmark(
    @OneToOne
    var post: Post? = null,
    @ManyToOne
    var member: Member? = null
) : Auditable {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    var id: UUID = UUID.randomUUID()

    @Embedded
    override var baseTime: BaseTime = BaseTime()
}
