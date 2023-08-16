package sundaystudy.kr.usedcar.module.member.controller

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get
import org.springframework.restdocs.operation.preprocess.Preprocessors.*
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import sundaystudy.kr.usedcar.module.member.dto.response.MemberDetailsResponse
import sundaystudy.kr.usedcar.module.member.service.MemberService
import sundaystudy.kr.usedcar.support.docs.RestDocsTest
import java.util.*

@DisplayName("Member 컨트롤러의")
@WebMvcTest(MemberController::class)
class MemberControllerTest: RestDocsTest() {
    @MockBean private lateinit var memberService: MemberService

    @Test
    @DisplayName("개인정보 조회 api가 수행되는가")
    fun getMemberDetails() {
        //given
        val expected = MemberDetailsResponse(UUID.randomUUID(), "ohksj77", 36.5, 50.0, 70.0)
        `when`(memberService.getMemberDetails()).thenReturn(expected)

        //when
        val perform = mockMvc.perform(
            get("/members/me")
                .header("Authorization", "Bearer 12asdf21435.asdfgafdsg231f.432t4243cf")
                .contentType(MediaType.APPLICATION_JSON))

        //then
        perform.andExpect(status().isOk)
            .andExpect(jsonPath("$.response_rate").isNumber)
            .andExpect(jsonPath("$.id").isString)

        //docs
        perform.andDo(print())
            .andDo(document("get member details", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())))
    }
}
