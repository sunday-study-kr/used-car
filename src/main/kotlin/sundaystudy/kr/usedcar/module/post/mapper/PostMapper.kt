package sundaystudy.kr.usedcar.module.post.mapper

import org.springframework.stereotype.Component
import sundaystudy.kr.usedcar.module.member.entity.Member
import sundaystudy.kr.usedcar.module.post.dto.request.PostRequest
import sundaystudy.kr.usedcar.module.post.dto.response.PostResponse
import sundaystudy.kr.usedcar.module.post.entity.Post
import sundaystudy.kr.usedcar.module.usedcar.entity.UsedCar


@Component
class PostMapper {

    fun toEntity(request: PostRequest, member: Member, usedCar: UsedCar): Post =
        Post(request.introduce, request.dealAddress, usedCar, member)

    fun toPostResponse(post: Post): PostResponse = PostResponse(
        post.id, post.member.id, post.usedCar.id, post.chat, post.focus, post.look, post.introduce, post.dealAddress
    )

    fun toPostResponses(posts: List<Post>): List<PostResponse> =
        posts.map(this::toPostResponse)
}
