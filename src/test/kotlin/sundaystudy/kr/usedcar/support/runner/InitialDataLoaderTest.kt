package sundaystudy.kr.usedcar.support.runner

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component

@Primary
@Component
class InitialDataLoaderTest(
): CommandLineRunner {
    override fun run(vararg args: String?) {}
}
