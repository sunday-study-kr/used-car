package sundaystudy.kr.usedcar.module.insurance.repository

import org.springframework.data.jpa.repository.JpaRepository
import sundaystudy.kr.usedcar.module.insurance.entity.ChangeOwner
import java.util.UUID

interface ChangeOwnerRepository : JpaRepository<ChangeOwner,UUID> {
}
