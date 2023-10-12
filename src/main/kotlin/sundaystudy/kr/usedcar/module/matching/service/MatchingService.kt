package sundaystudy.kr.usedcar.module.matching.service

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import sundaystudy.kr.usedcar.module.matching.dto.MatchingResponse
import sundaystudy.kr.usedcar.module.matching.entity.Matching
import sundaystudy.kr.usedcar.module.matching.mapper.MatchingMapper
import sundaystudy.kr.usedcar.module.matching.repository.MatchingRepository
import sundaystudy.kr.usedcar.module.member.repository.MemberRepository
import sundaystudy.kr.usedcar.module.member.service.AuthService
import sundaystudy.kr.usedcar.module.member.service.MemberService
import sundaystudy.kr.usedcar.module.post.repository.PostRepository
import java.util.UUID

@Service
class MatchingService(
    private val matchingRepository: MatchingRepository,
    private val postRepository: PostRepository,
    private val memberService: MemberService,
    private val authService: AuthService,
    private val matchingMapper: MatchingMapper,
    ) {

    fun getLoginUserId(): UUID = authService.getLoginUserId()

    fun getMatchingList(): List<MatchingResponse> {
        return matchingMapper.toListResponse(matchingRepository.findAllByRequestMemberId(getLoginUserId()))
    }

    @Transactional
    fun saveMatching(postId: UUID): MatchingResponse {
        val post = postRepository.getReferenceById(postId)
        val requestUser = memberService.getEntity(getLoginUserId())
        return matchingMapper.toResponse(matchingRepository.save(
            Matching(
                post,
                requestUser,
                post.member,
            )
        ))
    }

    fun getMatching(matchingId: UUID): MatchingResponse {
        return matchingMapper.toResponse(matchingRepository.getReferenceById(matchingId))
    }
}