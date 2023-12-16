package sundaystudy.kr.usedcar.module.matching.controller

import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import sundaystudy.kr.usedcar.global.dto.IdResponse
import sundaystudy.kr.usedcar.module.matching.dto.MatchingRequest
import sundaystudy.kr.usedcar.module.matching.dto.MatchingResponse
import sundaystudy.kr.usedcar.module.matching.service.MatchingService
import java.util.*

@RestController("matching")
class MatchingController(
    private val matchingService: MatchingService
) {

    @GetMapping("/")
    fun getMatchingList(pageable: Pageable): ResponseEntity<List<MatchingResponse>> {
        return ResponseEntity.ok(matchingService.getMatchings())
    }

    @GetMapping("/{id}")
    fun getMatching(@PathVariable("id") matchingId: UUID): ResponseEntity<MatchingResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(matchingService.getMatching(matchingId))
    }

    @PostMapping("/")
    fun saveMatching(@RequestBody request: MatchingRequest): ResponseEntity<IdResponse> {
        return ResponseEntity.ok(matchingService.saveMatching(request))
    }
}
