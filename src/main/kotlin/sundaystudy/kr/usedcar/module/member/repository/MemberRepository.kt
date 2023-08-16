package sundaystudy.kr.usedcar.module.member.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Transactional
import sundaystudy.kr.usedcar.module.member.entity.Member
import java.util.*

interface MemberRepository : JpaRepository<Member, UUID> {
    @Modifying
    @Transactional
    @Query("UPDATE Member m SET m.refreshToken = :refreshToken WHERE m.id = :id")
    fun updateRefreshToken(id: UUID, refreshToken: String)
    fun findByoAuth2DetailsClientId(clientId: String): Member?

    @Query("SELECT m.refreshToken FROM Member m WHERE m.id = :id")
    fun findRefreshTokenById(id: UUID): String
}
