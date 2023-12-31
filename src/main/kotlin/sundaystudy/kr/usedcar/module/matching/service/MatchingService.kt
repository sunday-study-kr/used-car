package sundaystudy.kr.usedcar.module.matching.service

import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import sundaystudy.kr.usedcar.global.dto.IdResponse
import sundaystudy.kr.usedcar.global.exception.EntityNotFoundException
import sundaystudy.kr.usedcar.module.matching.dto.MatchingRequest
import sundaystudy.kr.usedcar.module.matching.dto.MatchingResponse
import sundaystudy.kr.usedcar.module.matching.mapper.MatchingMapper
import sundaystudy.kr.usedcar.module.matching.repository.MatchingRepository
import sundaystudy.kr.usedcar.module.member.service.AuthService
import sundaystudy.kr.usedcar.module.post.service.PostService
import java.util.*

@Service
class MatchingService(
    private val matchingRepository: MatchingRepository,
    private val postService: PostService,
    private val authService: AuthService,
    private val matchingMapper: MatchingMapper,
) {

    fun getLoginUserId(): UUID = authService.getLoginUserId()

    fun getMatchings(): List<MatchingResponse> {
        return matchingMapper.toResponses(matchingRepository.findAllByRequestMemberId(getLoginUserId()))
    }

    @Transactional
    fun saveMatching(matchingRequest: MatchingRequest): IdResponse {
        val post = postService.getPostEntity(matchingRequest.postId)
        val requestUser = authService.getLoginUser()
        val matching = matchingMapper.toEntity(
            post,
            requestUser,
            post.member
        )
        return IdResponse(
            matchingRepository.save(
                matching
            ).id
        )
    }

    fun getMatching(matchingId: UUID): MatchingResponse {
        return matchingMapper.toResponse(
            matchingRepository.findByIdOrNull(matchingId) ?: throw EntityNotFoundException()
        )
    }
}
