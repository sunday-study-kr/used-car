package sundaystudy.kr.usedcar.module.user.entity

import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.Id
import sundaystudy.kr.usedcar.global.audit.Auditable
import sundaystudy.kr.usedcar.global.audit.BaseTime
import java.util.UUID

@Entity
class User(
    var nickname: String,
) : Auditable {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()

    var mannerTemperature: Double = 36.5
        protected set

    var rateOfReDealing: Double = 0.0
        protected set

    var responseRate: Double = 0.0
        protected set

    @Embedded
    override var baseTime: BaseTime = BaseTime()

    // TODO Double 필드 3개에 대한 업데이트 로직 함수 작성
}
