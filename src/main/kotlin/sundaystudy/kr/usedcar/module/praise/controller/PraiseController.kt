package sundaystudy.kr.usedcar.module.praise.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import sundaystudy.kr.usedcar.global.dto.IdResponse
import sundaystudy.kr.usedcar.module.praise.dto.request.PraiseRequest
import sundaystudy.kr.usedcar.module.praise.dto.response.PraiseDetailsResponse
import sundaystudy.kr.usedcar.module.praise.dto.response.PraiseResponse
import sundaystudy.kr.usedcar.module.praise.service.PraiseService
import java.util.*

@RestController
@RequestMapping("praises")
class PraiseController(
    private val praiseService: PraiseService,
) {
    @PostMapping
    fun savePraise(praiseRequest: PraiseRequest): ResponseEntity<IdResponse> =
        ResponseEntity.status(HttpStatus.CREATED).body(praiseService.savePraise(praiseRequest))

    @GetMapping
    fun getAllPraises(): ResponseEntity<List<PraiseResponse>> =
        ResponseEntity.ok(praiseService.getAllPraises())

    @GetMapping("members/{memberId}")
    fun getPraiseByMemberId(@PathVariable memberId: UUID): ResponseEntity<PraiseResponse> =
        ResponseEntity.ok(praiseService.getPraiseByMemberId(memberId))

    @GetMapping("{id}")
    fun getPraiseDetails(@PathVariable id: UUID): ResponseEntity<PraiseDetailsResponse> =
        ResponseEntity.ok(praiseService.getPraiseDetails(id))
}
