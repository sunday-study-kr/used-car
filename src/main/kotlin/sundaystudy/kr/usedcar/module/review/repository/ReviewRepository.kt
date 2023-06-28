package sundaystudy.kr.usedcar.module.review.repository

import org.springframework.data.jpa.repository.JpaRepository
import sundaystudy.kr.usedcar.module.review.entity.Review
import java.util.UUID

interface ReviewRepository : JpaRepository<Review, UUID>
