package sundaystudy.kr.usedcar.module.post.mapper

import org.springframework.stereotype.Component
import sundaystudy.kr.usedcar.module.member.entity.Member
import sundaystudy.kr.usedcar.module.post.dto.request.PostRequest
import sundaystudy.kr.usedcar.module.post.dto.response.PostResponse
import sundaystudy.kr.usedcar.module.post.entity.Post
import sundaystudy.kr.usedcar.module.usedcar.entity.UsedCar


@Component
class PostMapper {

    fun toEntity(request : PostRequest,member : Member,usedCar : UsedCar) : Post{
        var post = Post(request.introduce,request.dealAddress)
        post.addMember(member)
        post.addUsedCar(usedCar)

        return post
    }

    fun toPostResponse(post : Post) : PostResponse = PostResponse(post.id,post.member!!.id,post.usedCar!!.id
    ,post.chat,post.focus,post.look,post.introduce,post.dealAddress)

    fun toPostListResponse(posts : MutableList<Post>) : MutableList<PostResponse> {
        var responseList = mutableListOf<PostResponse>()
        for(cur in posts){
            responseList.add(toPostResponse(cur))
        }

        return responseList
    }
}
