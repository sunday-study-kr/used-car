package sundaystudy.kr.usedcar.module.Review.Repository

import org.springframework.data.jpa.repository.JpaRepository
import sundaystudy.kr.usedcar.module.Review.Entity.Review
import java.util.UUID

interface ReviewRepository: JpaRepository<Review, UUID>
