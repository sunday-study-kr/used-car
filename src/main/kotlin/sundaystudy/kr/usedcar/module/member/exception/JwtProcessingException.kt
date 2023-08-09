package sundaystudy.kr.usedcar.module.member.exception

class JwtProcessingException(override val message: String = "Jwt 예외가 발생했습니다.") : IllegalStateException(message)
