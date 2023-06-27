package sundaystudy.kr.usedcar.global.audit

import jakarta.persistence.EntityListeners
import org.hibernate.annotations.Where
import java.lang.annotation.Inherited

@Inherited
@Where(clause = "deleted_at is null")
@EntityListeners(AuditListener::class)
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class SoftDelete
