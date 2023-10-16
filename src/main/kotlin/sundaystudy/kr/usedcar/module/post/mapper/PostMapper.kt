package sundaystudy.kr.usedcar.module.post.mapper

import org.springframework.stereotype.Component
import sundaystudy.kr.usedcar.module.member.entity.Member
import sundaystudy.kr.usedcar.module.post.dto.request.PostRequest
import sundaystudy.kr.usedcar.module.post.dto.response.PostResponse
import sundaystudy.kr.usedcar.module.post.entity.Post
import sundaystudy.kr.usedcar.module.usedcar.entity.UsedCar


@Component
class PostMapper {

    fun toEntity(request : PostRequest) : Post{
        return Post(0,0,0,request.introduce,request.dealAddress)
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
