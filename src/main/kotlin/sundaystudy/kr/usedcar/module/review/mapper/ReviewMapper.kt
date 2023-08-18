package sundaystudy.kr.usedcar.module.review.mapper

import org.springframework.stereotype.Component
import sundaystudy.kr.usedcar.module.member.entity.Member
import sundaystudy.kr.usedcar.module.review.dto.request.ReviewRequest
import sundaystudy.kr.usedcar.module.review.dto.response.ReviewResponse
import sundaystudy.kr.usedcar.module.review.entity.Review

@Component
class ReviewMapper {

    fun toEntity(reviewRequest: ReviewRequest, member: Member, reviewer: Member): Review =
        Review(
            content = reviewRequest.content,
            member = member,
            reviewer = reviewer
        )

    fun toResponseList(reviewList: List<Review>): List<ReviewResponse> =
        reviewList.map(this::toResponse)

    fun toResponse(review: Review): ReviewResponse =
        ReviewResponse(
            id = review.id,
            content = review.content,
            memberId = review.member.id
        )
}
