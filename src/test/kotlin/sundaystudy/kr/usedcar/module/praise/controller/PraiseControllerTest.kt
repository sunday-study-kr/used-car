package sundaystudy.kr.usedcar.module.praise.controller

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post
import org.springframework.restdocs.operation.preprocess.Preprocessors.*
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import sundaystudy.kr.usedcar.global.dto.IdResponse
import sundaystudy.kr.usedcar.module.praise.dto.request.PraiseRequest
import sundaystudy.kr.usedcar.module.praise.service.PraiseService
import sundaystudy.kr.usedcar.support.docs.RestDocsTest
import java.util.*

@DisplayName("Praise 컨트롤러의")
@WebMvcTest(PraiseController::class)
class PraiseControllerTest: RestDocsTest() {
    @MockBean private lateinit var praiseService: PraiseService

    @Test
    @DisplayName("칭찬 저장 api가 수행되는가")
    fun savePraise() {
        //given
        val expected = IdResponse(UUID.randomUUID())
        `when`(praiseService.savePraise(any(PraiseRequest::class.java))).thenReturn(expected)

        //when
        val perform = mockMvc.perform(
            post("/praises")
                .content(toRequestBody(PraiseRequest(UUID.randomUUID(), UUID.randomUUID(), "친절해요")))
                .contentType(MediaType.APPLICATION_JSON))

        //then
        perform.andExpect(status().isCreated)
            .andExpect(jsonPath("$.id").isString)

        //docs
        perform.andDo(print())
            .andDo(
                document(
                    "post praise",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint())))
    }
}
