package sundaystudy.kr.usedcar.module.review.service

import org.springframework.stereotype.Service
import sundaystudy.kr.usedcar.global.dto.IdResponse
import sundaystudy.kr.usedcar.module.review.dto.request.ReviewRequest
import sundaystudy.kr.usedcar.module.review.dto.response.ReviewResponse
import sundaystudy.kr.usedcar.module.review.repository.ReviewRepository
import java.util.*

@Service
class ReviewService(
    private val reviewRepository: ReviewRepository,
) {
    fun saveReview(reviewRequest: ReviewRequest): IdResponse {
        TODO("Not yet implemented")
    }

    fun getAllReviews(): List<ReviewResponse> {
        TODO("Not yet implemented")
    }

    fun getReview(id: UUID): ReviewResponse {
        TODO("Not yet implemented")
    }

    fun getAllReviewsByMemberId(userId: UUID): List<ReviewResponse> {
        TODO("Not yet implemented")
    }
}
