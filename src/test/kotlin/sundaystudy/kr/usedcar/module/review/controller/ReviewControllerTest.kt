package sundaystudy.kr.usedcar.module.review.controller

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito.doNothing
import org.mockito.Mockito.`when`
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.domain.Pageable
import org.springframework.http.MediaType
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*
import org.springframework.restdocs.operation.preprocess.Preprocessors.*
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import sundaystudy.kr.usedcar.global.dto.IdResponse
import sundaystudy.kr.usedcar.module.review.dto.request.ReviewRequest
import sundaystudy.kr.usedcar.module.review.dto.request.ReviewUpdateRequest
import sundaystudy.kr.usedcar.module.review.dto.response.ReviewResponse
import sundaystudy.kr.usedcar.module.review.service.ReviewService
import sundaystudy.kr.usedcar.support.docs.RestDocsTest
import java.util.*

@DisplayName("Review 컨트롤러의")
@WebMvcTest(ReviewController::class)
class ReviewControllerTest: RestDocsTest() {

    @MockBean private lateinit var reviewService: ReviewService

    @Test
    @DisplayName("리뷰 저장 api가 수행되는가")
    fun saveReview() {
        //given
        val expected = IdResponse(UUID.randomUUID())
        `when`(reviewService.saveReview(any(ReviewRequest::class.java))).thenReturn(expected)

        //when
        val perform = mockMvc.perform(
            post("/reviews")
                .content(toRequestBody(ReviewRequest("매우 좋습니다", UUID.randomUUID())))
                .header("Authorization", "Bearer 12asdf21435.asdfgafdsg231f.432t4243cf")
                .contentType(MediaType.APPLICATION_JSON))

        //then
        perform.andExpect(status().isCreated)
            .andExpect(jsonPath("$.id").isString)

        //docs
        perform.andDo(print())
            .andDo(
                document(
                    "post review",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint())
                )
            )
    }

    @Test
    @DisplayName("리뷰 전체 조회 api가 수행되는가")
    fun getAllReview() {
        //given
        val expected = listOf(ReviewResponse(UUID.randomUUID(), "매우 좋아요", UUID.randomUUID()))
        `when`(reviewService.getAllReviews(any(Pageable::class.java))).thenReturn(expected)

        //when
        val perform = mockMvc.perform(
            get("/reviews")
                .header("Authorization", "Bearer 12asdf21435.asdfgafdsg231f.432t4243cf")
                .contentType(MediaType.APPLICATION_JSON))

        //then
        perform.andExpect(status().isOk)
            .andExpect(jsonPath("$").isArray)

        //docs
        perform.andDo(print())
            .andDo(
                document(
                    "get all reviews",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint())
                )
            )
    }

    @Test
    @DisplayName("리뷰 단건 조회 api가 수행되는가")
    fun getReview() {
        //given
        val expected = ReviewResponse(UUID.randomUUID(), "매우 좋아요", UUID.randomUUID())
        `when`(reviewService.getReview(any(UUID::class.java))).thenReturn(expected)

        //when
        val perform = mockMvc.perform(
            get("/reviews/" + UUID.randomUUID())
                .header("Authorization", "Bearer 12asdf21435.asdfgafdsg231f.432t4243cf")
                .contentType(MediaType.APPLICATION_JSON))

        //then
        perform.andExpect(status().isOk)
            .andExpect(jsonPath("$.id").isString)
            .andExpect(jsonPath("$.content").isString)
            .andExpect(jsonPath("$.member_id").isString)

        //docs
        perform.andDo(print())
            .andDo(
                document(
                    "get review",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint())
                )
            )
    }

    @Test
    @DisplayName("멤버가 작성한 리뷰 조회 api가 수행되는가")
    fun getReviewsByMemberId() {
        //given
        val expected = listOf(ReviewResponse(UUID.randomUUID(), "매우 좋아요", UUID.randomUUID()))
        `when`(reviewService.getAllReviewsByMemberId(any(UUID::class.java))).thenReturn(expected)

        //when
        val perform = mockMvc.perform(
            get("/reviews/members/" + UUID.randomUUID())
                .header("Authorization", "Bearer 12asdf21435.asdfgafdsg231f.432t4243cf")
                .contentType(MediaType.APPLICATION_JSON))

        //then
        perform.andExpect(status().isOk)
            .andExpect(jsonPath("$").isArray)

        //docs
        perform.andDo(print())
            .andDo(
                document(
                    "get all reviews by member",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint())
                )
            )
    }

    @Test
    @DisplayName("리뷰 업데이트 api가 수행되는가")
    fun updateReview() {
        //given
        doNothing().`when`(reviewService).updateReview(any(ReviewUpdateRequest::class.java))

        //when
        val perform = mockMvc.perform(
            put("/reviews")
                .content(toRequestBody(ReviewUpdateRequest(UUID.randomUUID(), "수정할 내용")))
                .header("Authorization", "Bearer 12asdf21435.asdfgafdsg231f.432t4243cf")
                .contentType(MediaType.APPLICATION_JSON))

        //then
        perform.andExpect(status().isNoContent)

        //docs
        perform.andDo(print())
            .andDo(
                document(
                    "put update review",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint())
                )
            )
    }

    @Test
    @DisplayName("리뷰 삭제 api가 수행되는가")
    fun deleteReview() {
        //given
        doNothing().`when`(reviewService).deleteReview(any(UUID::class.java))

        //when
        val perform = mockMvc.perform(
            delete("/reviews/" + UUID.randomUUID())
                .header("Authorization", "Bearer 12asdf21435.asdfgafdsg231f.432t4243cf")
                .contentType(MediaType.APPLICATION_JSON))

        //then
        perform.andExpect(status().isNoContent)

        //docs
        perform.andDo(print())
            .andDo(
                document(
                    "delete review",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint())
                )
            )
    }
}
