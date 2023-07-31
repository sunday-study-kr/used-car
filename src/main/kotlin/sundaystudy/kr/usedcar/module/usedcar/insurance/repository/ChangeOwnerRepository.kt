package sundaystudy.kr.usedcar.module.usedcar.insurance.repository

import org.springframework.data.jpa.repository.JpaRepository
import sundaystudy.kr.usedcar.module.usedcar.insurance.entity.ChangeOwner
import java.util.UUID

interface ChangeOwnerRepository : JpaRepository<ChangeOwner, UUID>
