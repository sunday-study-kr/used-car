package sundaystudy.kr.usedcar.support.docs

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.Import
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext
import org.springframework.restdocs.RestDocumentationContextProvider
import org.springframework.restdocs.RestDocumentationExtension
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import org.springframework.web.filter.CharacterEncodingFilter
import sundaystudy.kr.usedcar.config.security.jwt.JwtProvider
import sundaystudy.kr.usedcar.config.security.jwt.JwtValidator

@WebMvcTest
@AutoConfigureRestDocs
@Import(RestDocsConfig::class)
@ExtendWith(RestDocumentationExtension::class, SpringExtension::class)
open class RestDocsTest {
    @Autowired
    lateinit var objectMapper: ObjectMapper

    @MockBean
    lateinit var jpaMetamodelMappingContext: JpaMetamodelMappingContext
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var jwtValidator: JwtValidator

    @MockBean
    lateinit var jwtProvider: JwtProvider

    fun toRequestBody(value: Any): String {
        return objectMapper.writeValueAsString(value)
    }

    @BeforeEach
    fun setupMockMvc(ctx: WebApplicationContext, restDocumentationContextProvider: RestDocumentationContextProvider) {
        mockMvc = MockMvcBuilders.webAppContextSetup(ctx)
            .apply<DefaultMockMvcBuilder>(
                MockMvcRestDocumentation.documentationConfiguration(
                    restDocumentationContextProvider
                )
            )
            .addFilter<DefaultMockMvcBuilder>(CharacterEncodingFilter("UTF-8", true))
            .alwaysDo<DefaultMockMvcBuilder>(MockMvcResultHandlers.print())
            .build()
    }

    fun <T> any(type: Class<T>): T = Mockito.any<T>(type)
}
