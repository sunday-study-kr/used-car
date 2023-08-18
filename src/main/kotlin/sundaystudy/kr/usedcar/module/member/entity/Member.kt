package sundaystudy.kr.usedcar.module.member.entity

import jakarta.persistence.*
import org.hibernate.annotations.Where
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import sundaystudy.kr.usedcar.global.audit.AuditListener
import sundaystudy.kr.usedcar.global.audit.Auditable
import sundaystudy.kr.usedcar.global.audit.BaseTime
import sundaystudy.kr.usedcar.module.badge.entity.Badge
import java.util.*

@Entity
@Where(clause = "deleted_at is null")
@EntityListeners(AuditListener::class)
class Member(
    @Embedded
    private var oAuth2Details: OAuth2Details
) : Auditable {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()

    var nickname: String? = null
        protected set

    var mannerTemperature: Double = 36.5
        protected set

    var rateOfReDealing: Double = 0.0
        protected set

    var responseRate: Double = 0.0
        protected set

    var refreshToken: String? = null
        protected set

    @Enumerated(EnumType.STRING)
    var role: Role = Role.ROLE_USER
        protected set

    @OneToMany(mappedBy = "member")
    var badges: MutableList<Badge> = mutableListOf()
        protected set

    @Embedded
    override var baseTime: BaseTime = BaseTime()

    fun getRole(): MutableCollection<out GrantedAuthority> =
        mutableListOf(SimpleGrantedAuthority(role.name))

    fun updateRefreshToken(refreshToken: String) {
        this.refreshToken = refreshToken
    }

    fun organizeBadge(badge: Badge) {
        this.badges.add(badge)
    }

    // TODO Double 필드 3개에 대한 업데이트 로직 함수 작성
}
