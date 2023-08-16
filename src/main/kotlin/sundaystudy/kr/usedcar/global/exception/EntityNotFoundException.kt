package sundaystudy.kr.usedcar.global.exception

class EntityNotFoundException(
    override val message: String = "엔티티 조회중 오류가 발생했습니다."
): IllegalArgumentException(message)
