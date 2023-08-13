package sundaystudy.kr.usedcar

import org.junit.jupiter.api.Test
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration

@ActiveProfiles("test")
@ContextConfiguration(inheritInitializers = true)
class UsedCarApplicationTests {

	@Test
	fun contextLoads() {
	}

}
