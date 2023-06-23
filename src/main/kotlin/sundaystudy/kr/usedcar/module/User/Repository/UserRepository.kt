package sundaystudy.kr.usedcar.module.User.Repository

import org.springframework.data.jpa.repository.JpaRepository
import sundaystudy.kr.usedcar.module.User.Entity.User
import java.util.UUID

interface UserRepository : JpaRepository<User, UUID>
