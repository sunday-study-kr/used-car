package sundaystudy.kr.usedcar.module.review.controller

import org.springframework.web.bind.annotation.*
import sundaystudy.kr.usedcar.global.dto.IdResponse
import sundaystudy.kr.usedcar.module.review.dto.request.ReviewRequest
import sundaystudy.kr.usedcar.module.review.dto.response.ReviewResponse
import sundaystudy.kr.usedcar.module.review.service.ReviewService
import java.util.*

@RestController
@RequestMapping("reviews")
class ReviewController(
    private val reviewService: ReviewService,
) {
    @PostMapping
    fun saveReview(reviewRequest: ReviewRequest): IdResponse =
        reviewService.saveReview(reviewRequest)

    @GetMapping
    fun getAllReview(): List<ReviewResponse> =
        reviewService.getAllReviews()

    @GetMapping("{id}")
    fun getReview(): ReviewResponse =
        reviewService.getReview()

    @GetMapping("members/{memberId}")
    fun getReview(@PathVariable memberId: UUID): List<ReviewResponse> =
        reviewService.getAllReviewsByMemberId()
}
