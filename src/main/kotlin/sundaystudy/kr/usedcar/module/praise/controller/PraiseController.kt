package sundaystudy.kr.usedcar.module.praise.controller

import jakarta.validation.Valid
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import sundaystudy.kr.usedcar.global.dto.IdResponse
import sundaystudy.kr.usedcar.module.praise.dto.request.PraiseRequest
import sundaystudy.kr.usedcar.module.praise.dto.request.PraiseUpdateRequest
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
    fun savePraise(@RequestBody @Valid praiseRequest: PraiseRequest): ResponseEntity<IdResponse> =
        ResponseEntity.status(HttpStatus.CREATED).body(praiseService.savePraise(praiseRequest))

    @GetMapping
    fun getAllPraises(pageable: Pageable): ResponseEntity<List<PraiseResponse>> =
        ResponseEntity.ok(praiseService.getAllPraises(pageable))

    @GetMapping("members/{memberId}")
    fun getPraiseByMemberId(@PathVariable memberId: UUID): ResponseEntity<List<PraiseResponse>> =
        ResponseEntity.ok(praiseService.getPraiseByMemberId(memberId))

    @GetMapping("{id}")
    fun getPraiseDetails(@PathVariable id: UUID): ResponseEntity<PraiseDetailsResponse> =
        ResponseEntity.ok(praiseService.getPraiseDetails(id))

    @PutMapping
    fun updatePraise(@RequestBody @Valid praiseUpdateRequest: PraiseUpdateRequest): ResponseEntity<Unit> {
        praiseService.updatePraise(praiseUpdateRequest)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("{id}")
    fun deletePraise(@PathVariable id: UUID): ResponseEntity<Unit> {
        praiseService.deletePraise(id)
        return ResponseEntity.noContent().build()
    }
}
