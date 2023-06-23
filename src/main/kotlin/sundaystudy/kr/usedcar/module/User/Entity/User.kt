package sundaystudy.kr.usedcar.module.User.Entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.UUID

@Entity
class User(
        var nickname: String
) {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID()

    var mannerTemperature: Double = 36.5
        protected set

    var rateOfReDealing: Double = 0.0
        protected set

    var responseRate: Double = 0.0
        protected set

    // TODO Double 필드 3개에 대한 업데이트 로직 함수 작성
}
