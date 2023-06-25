package sundaystudy.kr.usedcar.global.audit

import org.hibernate.annotations.Where

@Where(clause = "deleted_at is null")
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class SoftDelete
