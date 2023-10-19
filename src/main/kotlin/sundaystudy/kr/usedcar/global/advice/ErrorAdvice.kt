package sundaystudy.kr.usedcar.global.advice

import jakarta.validation.ValidationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import sundaystudy.kr.usedcar.global.exception.EntityNotFoundException

@RestControllerAdvice
class ErrorAdvice {

    @ExceptionHandler(EntityNotFoundException::class)
    fun jwtProcessingException(e: EntityNotFoundException): ResponseEntity<ErrorResponse> =
        ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse(e.message))

    @ExceptionHandler(ValidationException::class)
    fun validationException(e: ValidationException): ResponseEntity<ErrorResponse> =
        ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse(e.message))
}
