package sundaystudy.kr.usedcar.module.post.service

import org.springframework.stereotype.Service
import sundaystudy.kr.usedcar.global.dto.IdResponse
import sundaystudy.kr.usedcar.module.post.dto.request.PostRequest
import sundaystudy.kr.usedcar.module.post.dto.response.PostResponse
import sundaystudy.kr.usedcar.module.post.repository.PostRepository
import java.util.*

@Service
class PostService(
    private val postRepository: PostRepository) {
    fun savePost(postRequest: PostRequest) : IdResponse
    {
        TODO()
    }

    fun getPostByUserId(userId : UUID) : List<PostResponse>
    {
        TODO()
    }

    fun getPostById(id : UUID) : PostResponse
    {
        TODO()
    }

    fun deletePostById(id : UUID)
    {
        TODO()
    }

}
