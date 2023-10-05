package sundaystudy.kr.usedcar.module.review.service

import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import sundaystudy.kr.usedcar.global.dto.IdResponse
import sundaystudy.kr.usedcar.global.exception.EntityNotFoundException
import sundaystudy.kr.usedcar.module.member.service.AuthService
import sundaystudy.kr.usedcar.module.member.service.MemberService
import sundaystudy.kr.usedcar.module.review.dto.request.ReviewRequest
import sundaystudy.kr.usedcar.module.review.dto.request.ReviewUpdateRequest
import sundaystudy.kr.usedcar.module.review.dto.response.ReviewResponse
import sundaystudy.kr.usedcar.module.review.mapper.ReviewMapper
import sundaystudy.kr.usedcar.module.review.repository.ReviewRepository
import java.util.*

@Service
class ReviewService(
    private val reviewRepository: ReviewRepository,
    private val reviewMapper: ReviewMapper,
    private val memberService: MemberService,
    private val authService: AuthService,
) {
    fun saveReview(reviewRequest: ReviewRequest): IdResponse {
        val member = memberService.getEntity(reviewRequest.memberId)
        val reviewer = authService.getLoginUser()
        val review = reviewRepository.save(reviewMapper.toEntity(reviewRequest, member, reviewer))
        return IdResponse(review.id)
    }

    fun getAllReviews(pageable: Pageable): List<ReviewResponse> =
        reviewMapper.toResponseList(reviewRepository.findAll(pageable).content)

    fun getReview(id: UUID): ReviewResponse =
        reviewMapper.toResponse(getEntity(id))

    fun getAllReviewsByMemberId(memberId: UUID): List<ReviewResponse> =
        reviewMapper.toResponseList(reviewRepository.findAllByMemberId(memberId))

    @Transactional
    fun updateReview(reviewUpdateRequest: ReviewUpdateRequest) {
        val review = getEntity(reviewUpdateRequest.id)
        review.update(reviewUpdateRequest.content)
    }

    @Transactional
    fun deleteReview(id: UUID) =
        getEntity(id).delete()

    private fun getEntity(id: UUID) =
        reviewRepository.findByIdOrNull(id) ?: throw EntityNotFoundException()
}
