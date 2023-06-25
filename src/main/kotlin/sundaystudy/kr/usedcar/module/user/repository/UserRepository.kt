package sundaystudy.kr.usedcar.module.user.repository

import org.springframework.data.jpa.repository.JpaRepository
import sundaystudy.kr.usedcar.module.user.entity.User
import java.util.UUID

interface UserRepository : JpaRepository<User, UUID>
