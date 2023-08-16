package sundaystudy.kr.usedcar.module.praise.repository

import org.springframework.data.jpa.repository.JpaRepository
import sundaystudy.kr.usedcar.module.member.entity.Member
import sundaystudy.kr.usedcar.module.praise.entity.Praise
import java.util.*

interface PraiseRepository : JpaRepository<Praise, UUID> {
    fun findByMember(member: Member): List<Praise>
}
