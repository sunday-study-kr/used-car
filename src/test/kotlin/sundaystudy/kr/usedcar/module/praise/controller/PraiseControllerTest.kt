package sundaystudy.kr.usedcar.module.praise.controller

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito.doNothing
import org.mockito.Mockito.`when`
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.http.MediaType
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*
import org.springframework.restdocs.operation.preprocess.Preprocessors.*
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import sundaystudy.kr.usedcar.global.dto.IdResponse
import sundaystudy.kr.usedcar.module.praise.dto.request.PraiseRequest
import sundaystudy.kr.usedcar.module.praise.dto.request.PraiseUpdateRequest
import sundaystudy.kr.usedcar.module.praise.dto.response.PraiseDetailsResponse
import sundaystudy.kr.usedcar.module.praise.dto.response.PraiseResponse
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
                .content(toRequestBody(PraiseRequest(UUID.randomUUID(), "친절해요")))
                .header("Authorization", "Bearer 12asdf21435.asdfgafdsg231f.432t4243cf")
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

    @Test
    @DisplayName("모든 칭찬 조회 api가 수행되는가")
    fun getAllPraises() {
        //given
        val expected = listOf(PraiseResponse(UUID.randomUUID(), UUID.randomUUID(), "친절해요", 1),
            PraiseResponse(UUID.randomUUID(), UUID.randomUUID(), "응답이 빨라요", 4))
        `when`(praiseService.getAllPraises(any(Pageable::class.java))).thenReturn(expected)

        //when
        val perform = mockMvc.perform(
            get("/praises")
                .content(toRequestBody(PageRequest.of(0, 20)))
                .header("Authorization", "Bearer 12asdf21435.asdfgafdsg231f.432t4243cf")
                .contentType(MediaType.APPLICATION_JSON))

        //then
        perform.andExpect(status().isOk)
            .andExpect(jsonPath("$").isArray)

        //docs
        perform.andDo(print())
            .andDo(
                document(
                    "get all praises",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint())))
    }

    @Test
    @DisplayName("멤버가 받은 칭찬 조회 api가 수행되는가")
    fun getPraiseByMemberId() {
        //given
        val expected = listOf(PraiseResponse(UUID.randomUUID(), UUID.randomUUID(), "친절해요", 1),
            PraiseResponse(UUID.randomUUID(), UUID.randomUUID(), "응답이 빨라요", 4))
        `when`(praiseService.getPraiseByMemberId(any(UUID::class.java))).thenReturn(expected)

        //when
        val perform = mockMvc.perform(
            get("/praises/members/" + UUID.randomUUID())
                .header("Authorization", "Bearer 12asdf21435.asdfgafdsg231f.432t4243cf")
                .contentType(MediaType.APPLICATION_JSON))

        //then
        perform.andExpect(status().isOk)
            .andExpect(jsonPath("$").isArray)

        //docs
        perform.andDo(print())
            .andDo(
                document(
                    "get praise by member",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint())))
    }

    @Test
    @DisplayName("칭찬 상세 조회 api가 수행되는가")
    fun getPraiseDetails() {
        //given
        val expected = PraiseDetailsResponse(UUID.randomUUID(), "친절해요")
        `when`(praiseService.getPraiseDetails(any(UUID::class.java))).thenReturn(expected)

        //when
        val perform = mockMvc.perform(
            get("/praises/" + UUID.randomUUID())
                .header("Authorization", "Bearer 12asdf21435.asdfgafdsg231f.432t4243cf")
                .contentType(MediaType.APPLICATION_JSON))

        //then
        perform.andExpect(status().isOk)
            .andExpect(jsonPath("$.id").isString)
            .andExpect(jsonPath("$.content").isString)
            .andExpect(jsonPath("$.praise_type").isString)

        //docs
        perform.andDo(print())
            .andDo(
                document(
                    "get praise details",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint())))
    }

    @Test
    @DisplayName("칭찬 업데이트 api가 수행되는가")
    fun updatePraise() {
        //given
        doNothing().`when`(praiseService).updatePraise(any(PraiseUpdateRequest::class.java))

        //when
        val perform = mockMvc.perform(
            put("/praises")
                .content(toRequestBody(PraiseUpdateRequest(UUID.randomUUID(), "친절해요")))
                .header("Authorization", "Bearer 12asdf21435.asdfgafdsg231f.432t4243cf")
                .contentType(MediaType.APPLICATION_JSON))

        //then
        perform.andExpect(status().isNoContent)

        //docs
        perform.andDo(print())
            .andDo(
                document(
                    "put update praise",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint())))
    }

    @Test
    @DisplayName("칭찬 삭제 api가 수행되는가")
    fun deletePraise() {
        //given
        doNothing().`when`(praiseService).deletePraise(any(UUID::class.java))

        //when
        val perform = mockMvc.perform(
            delete("/praises/" + UUID.randomUUID())
                .header("Authorization", "Bearer 12asdf21435.asdfgafdsg231f.432t4243cf")
                .contentType(MediaType.APPLICATION_JSON))

        //then
        perform.andExpect(status().isNoContent)

        //docs
        perform.andDo(print())
            .andDo(
                document(
                    "delete praise",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint())))
    }
}
