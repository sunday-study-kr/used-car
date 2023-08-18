package sundaystudy.kr.usedcar.module.review.repository

import org.springframework.data.jpa.repository.JpaRepository
import sundaystudy.kr.usedcar.module.review.entity.Review
import java.util.*

interface ReviewRepository : JpaRepository<Review, UUID> {
    fun findAllByMemberId(memberId: UUID): List<Review>
}
