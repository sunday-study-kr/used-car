package sundaystudy.kr.usedcar.module.member.controller.advice

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import sundaystudy.kr.usedcar.global.advice.ErrorResponse
import sundaystudy.kr.usedcar.module.member.exception.JwtProcessingException

@RestControllerAdvice
class AuthControllerAdvice {

    @ExceptionHandler(JwtProcessingException::class)
    fun jwtProcessingException(e: JwtProcessingException): ResponseEntity<ErrorResponse> =
        ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse(e.message))
}
