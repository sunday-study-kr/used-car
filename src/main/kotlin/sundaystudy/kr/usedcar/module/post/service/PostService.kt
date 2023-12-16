package sundaystudy.kr.usedcar.module.post.service

import jakarta.persistence.EntityNotFoundException
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import sundaystudy.kr.usedcar.module.member.service.AuthService
import sundaystudy.kr.usedcar.module.member.service.MemberService
import sundaystudy.kr.usedcar.module.post.dto.request.PostRequest
import sundaystudy.kr.usedcar.module.post.dto.response.PostResponse
import sundaystudy.kr.usedcar.module.post.mapper.PostMapper
import sundaystudy.kr.usedcar.module.post.repository.PostRepository
import sundaystudy.kr.usedcar.module.usedcar.service.UsedCarService
import java.util.*

@Service
class PostService(
    private val postRepository: PostRepository,
    private val authService: AuthService,
    private val memberService: MemberService,
    private val usedCarService: UsedCarService,
    private val postMapper: PostMapper
) {
    @Transactional
    fun savePost(postRequest: PostRequest): PostResponse {
        return postMapper.toPostResponse(
            postRepository.save(
                postMapper.toEntity(
                    postRequest,
                    authService.getLoginUser(),
                    usedCarService.getUsedCarEntity(postRequest.usedCarId)
                )
            )
        )
    }

    fun getPostByMemberId(memberId: UUID): List<PostResponse> {
        return postMapper.toPostResponses(postRepository.findAllByMember(memberService.getEntity(memberId)))
    }

    fun getPostById(id: UUID): PostResponse {
        return postMapper.toPostResponse(getPostEntity(id))
    }

    fun getPostEntity(id: UUID) = postRepository.findByIdOrNull(id) ?: throw EntityNotFoundException()

    @Transactional
    fun deletePostById(id: UUID) {
        getPostEntity(id).delete()
    }

}
