package sundaystudy.kr.usedcar.module.badge.controller

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito.doNothing
import org.mockito.Mockito.`when`
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post
import org.springframework.restdocs.operation.preprocess.Preprocessors.*
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import sundaystudy.kr.usedcar.module.badge.dto.request.RepresentBadgeRequest
import sundaystudy.kr.usedcar.module.badge.dto.response.BadgeResponse
import sundaystudy.kr.usedcar.module.badge.service.BadgeService
import sundaystudy.kr.usedcar.support.docs.RestDocsTest
import java.util.*

@DisplayName("Badge 컨트롤러의")
@WebMvcTest(BadgeController::class)
class BadgeControllerTest: RestDocsTest() {
    @MockBean private lateinit var badgeService: BadgeService

    @Test
    @DisplayName("대표 뱃지 선택 api가 수행되는가")
    fun selectRepresentBadge() {
        //given
        doNothing().`when`(badgeService).selectRepresentBadge(any(RepresentBadgeRequest::class.java))

        //when
        val perform = mockMvc.perform(
            post("/badges")
                .content(toRequestBody(RepresentBadgeRequest(UUID.randomUUID())))
                .contentType(MediaType.APPLICATION_JSON))

        //then
        perform.andExpect(status().isOk)

        //docs
        perform.andDo(print())
            .andDo(
                document(
                    "post select represent badge",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint())))
    }

    @Test
    @DisplayName("뱃지 전체 조회 api가 수행되는가")
    fun getAllBadges() {
        //given
        val expected = listOf(
            BadgeResponse(UUID.randomUUID(), UUID.randomUUID(), "거래왕", true),
            BadgeResponse(UUID.randomUUID(), UUID.randomUUID(), "친절왕", true))
        `when`(badgeService.getAllBadges()).thenReturn(expected)

        //when
        val perform = mockMvc.perform(
            get("/badges")
                .contentType(MediaType.APPLICATION_JSON))

        //then
        perform.andExpect(status().isOk)

        //docs
        perform.andDo(print())
            .andDo(
                document(
                    "get all badges",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint())))
    }
}
