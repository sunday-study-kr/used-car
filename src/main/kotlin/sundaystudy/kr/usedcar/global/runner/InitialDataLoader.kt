package sundaystudy.kr.usedcar.global.runner

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Profile
import org.springframework.core.io.ClassPathResource
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component
import java.io.InputStreamReader


@Profile("!test")
@Component
class InitialDataLoader(
    private val jdbcTemplate: JdbcTemplate,
) : CommandLineRunner {
    private val logger = LoggerFactory.getLogger(InitialDataLoader::class.java)

    override fun run(vararg args: String?) {
        jdbcTemplate.execute("use usedcar")
        val isDataExist = jdbcTemplate.queryForObject(
            "SELECT CASE WHEN COUNT(id) > 0 THEN true ELSE FALSE END AS has_daa FROM car",
            Boolean::class.java
        ) ?: throw Exception("Cannot check `car` table")

        if (isDataExist === false) {
            val initialData = InputStreamReader(ClassPathResource("/initial.sql").inputStream)
            logger.info("-------- INITIAL DATA LOAD START --------")

            jdbcTemplate.runCatching {
                initialData.readLines().map {
                    jdbcTemplate.execute(it)
                }
            }.fold(
                onSuccess = {
                    logger.info("-------- INITIAL DATA LOAD DONE --------")
                    initialData.close()
                },
                onFailure = {
                    logger.error("-------- INITIAL DATE LOAD ERROR --------")
                    it.printStackTrace()
                    initialData.close()
                }
            )
        }
    }
}
