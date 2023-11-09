package sundaystudy.kr.usedcar.module.post.repository

import org.springframework.data.jpa.repository.JpaRepository
import sundaystudy.kr.usedcar.module.member.entity.Member
import sundaystudy.kr.usedcar.module.post.entity.Post
import java.util.UUID

interface PostRepository : JpaRepository<Post,UUID>{
    fun findAllByMember(member : Member) : MutableList<Post>
}
