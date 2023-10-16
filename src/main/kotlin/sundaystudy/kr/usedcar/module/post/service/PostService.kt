package sundaystudy.kr.usedcar.module.post.service

import jakarta.persistence.EntityNotFoundException
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import sundaystudy.kr.usedcar.module.member.service.AuthService
import sundaystudy.kr.usedcar.module.member.service.MemberService
import sundaystudy.kr.usedcar.module.post.dto.request.PostRequest
import sundaystudy.kr.usedcar.module.post.dto.response.PostResponse
import sundaystudy.kr.usedcar.module.post.entity.Post
import sundaystudy.kr.usedcar.module.post.mapper.PostMapper
import sundaystudy.kr.usedcar.module.post.repository.PostRepository
import sundaystudy.kr.usedcar.module.usedcar.service.UsedCarService
import java.util.*

@Service
class PostService(
    private val postRepository: PostRepository,
    private val authService : AuthService,
    private val memberService : MemberService,
    private val usedCarService: UsedCarService,
    private val postMapper : PostMapper
    ) {
    @Transactional
    fun savePost(postRequest: PostRequest) : PostResponse
    {
        val member = authService.getLoginUser()
        val usedCar = usedCarService.getUsedCarEntity(postRequest.usedCarId)

        val post : Post = postMapper.toEntity(postRequest)

        post.addMember(member)
        post.addUsedCar(usedCar)
        return postMapper.toPostResponse(postRepository.save(post))
    }

    fun getPostByMemberId(memberId : UUID) : List<PostResponse>
    {
        return postMapper.toPostListResponse(postRepository.findAllByMember(memberService.getEntity(memberId)))
    }

    fun getPostById(id : UUID) : PostResponse
    {
        return postMapper.toPostResponse(postRepository.findById(id).orElseThrow { EntityNotFoundException() })
    }

    fun getPostEntity(id : UUID) : Post = postRepository.findById(id).orElseThrow { EntityNotFoundException() }

    @Transactional
    fun deletePostById(id : UUID)
    {
        getPostEntity(id).delete()
    }

}
