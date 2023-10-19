package sundaystudy.kr.usedcar.module.praise.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import sundaystudy.kr.usedcar.module.member.entity.Member
import sundaystudy.kr.usedcar.module.praise.entity.Praise
import java.util.*

interface PraiseRepository : JpaRepository<Praise, UUID> {
    fun findByMember(member: Member): List<Praise>

    @Query("SELECT p FROM Praise p WHERE p.member = :member AND p.praiser = :praiser")
    fun findByMemberAndPraiser(member: Member, praiser: Member): Praise?
}
