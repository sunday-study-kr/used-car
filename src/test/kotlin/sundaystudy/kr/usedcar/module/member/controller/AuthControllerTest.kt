package sundaystudy.kr.usedcar.module.member.controller

import jakarta.servlet.http.Cookie
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders
import org.springframework.restdocs.operation.preprocess.Preprocessors
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import sundaystudy.kr.usedcar.config.security.jwt.JwtToken
import sundaystudy.kr.usedcar.module.member.service.AuthService
import sundaystudy.kr.usedcar.support.docs.RestDocsTest

@DisplayName("Auth 컨트롤러의")
@WebMvcTest(AuthController::class)
class AuthControllerTest: RestDocsTest() {

    @MockBean private lateinit var authService: AuthService

    @Test
    @DisplayName("토큰 갱신 api가 수행되는가")
    fun refreshToken() {
        //given
        val expected = JwtToken("access token", "refresh token")
        `when`(authService.refreshToken(any(String::class.java), any(String::class.java))).thenReturn(expected)

        //when
        val perform = mockMvc.perform(
            RestDocumentationRequestBuilders.get("/auth/refresh")
                .cookie(Cookie("Refresh", "refresh token"), Cookie("Access", "access token"))
                .contentType(MediaType.APPLICATION_JSON))

        //then
        perform.andExpect(status().isOk)
            .andExpect(jsonPath("$.access_token").isString)
            .andExpect(jsonPath("$.refresh_token").isString)

        //docs
        perform.andDo(MockMvcResultHandlers.print())
            .andDo(
                MockMvcRestDocumentation.document(
                    "get new refresh token",
                    Preprocessors.preprocessRequest(Preprocessors.prettyPrint()),
                    Preprocessors.preprocessResponse(Preprocessors.prettyPrint())
                )
            )
    }
}
