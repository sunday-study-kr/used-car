package sundaystudy.kr.usedcar.module.matching.controller

import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import sundaystudy.kr.usedcar.global.dto.PageableeResponse
import sundaystudy.kr.usedcar.module.matching.dto.MatchingRequest
import sundaystudy.kr.usedcar.module.matching.dto.MatchingResponse
import sundaystudy.kr.usedcar.module.matching.service.MatchingService

@RestController("matching")
class MatchingController(
    private val matchingService: MatchingService
) {

    @GetMapping("/")
    fun getMatchingList(pageable: Pageable): ResponseEntity<PageableeResponse<MatchingResponse>> {
        return ResponseEntity.status(HttpStatus.OK).body(PageableeResponse(listOf(), pageable.pageNumber, pageable.offset, 0))
    }

    @GetMapping("/{id}")
    fun getMatching(@PathVariable("id") matchingId: String): ResponseEntity<MatchingResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(MatchingResponse(""))
    }

    @PostMapping("/")
    fun saveMatching(@RequestBody request: MatchingRequest): ResponseEntity<MatchingResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(MatchingResponse(""))
    }
}