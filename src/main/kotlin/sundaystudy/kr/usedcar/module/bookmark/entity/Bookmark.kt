package sundaystudy.kr.usedcar.module.bookmark.entity

import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import sundaystudy.kr.usedcar.global.audit.Auditable
import sundaystudy.kr.usedcar.global.audit.BaseTime
import sundaystudy.kr.usedcar.module.post.entity.Post
import sundaystudy.kr.usedcar.module.user.entity.User

@Entity
class Bookmark(
    @Id
    private val id: String,
) : Auditable {

    @OneToOne
    var post: Post? = null

    @ManyToOne
    var user: User? = null

    @Embedded
    override var baseTime: BaseTime = BaseTime()
}
