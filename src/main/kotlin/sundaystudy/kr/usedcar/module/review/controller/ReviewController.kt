package sundaystudy.kr.usedcar.module.review.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
    fun saveReview(reviewRequest: ReviewRequest): ResponseEntity<IdResponse> =
        ResponseEntity.status(HttpStatus.CREATED).body(reviewService.saveReview(reviewRequest))

    @GetMapping
    fun getAllReview(): ResponseEntity<List<ReviewResponse>> =
        ResponseEntity.ok(reviewService.getAllReviews())

    @GetMapping("{id}")
    fun getReview(@PathVariable id: UUID): ResponseEntity<ReviewResponse> =
        ResponseEntity.ok(reviewService.getReview(id))

    @GetMapping("members/{memberId}")
    fun getReviewsByMemberId(@PathVariable memberId: UUID): ResponseEntity<List<ReviewResponse>> =
        ResponseEntity.ok(reviewService.getAllReviewsByMemberId(memberId))
}
