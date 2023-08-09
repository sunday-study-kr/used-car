package sundaystudy.kr.usedcar.module.bookmark.entity

import jakarta.persistence.*
import sundaystudy.kr.usedcar.global.audit.Auditable
import sundaystudy.kr.usedcar.global.audit.BaseTime
import sundaystudy.kr.usedcar.module.post.entity.Post

import sundaystudy.kr.usedcar.module.member.entity.Member

@Entity
class Bookmark(
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private val id: String,
) : Auditable {

    @OneToOne
    var post: Post? = null

    @ManyToOne
    var member: Member? = null

    @Embedded
    override var baseTime: BaseTime = BaseTime()
}
