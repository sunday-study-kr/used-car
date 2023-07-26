package sundaystudy.kr.usedcar.module.praise.controller

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
    fun savePraise(praiseRequest: PraiseRequest): IdResponse =
        praiseService.savePraise(praiseRequest)

    @GetMapping
    fun getAllPraises(): List<PraiseResponse> =
        praiseService.getAllPraises()

    @GetMapping("members/{memberId}")
    fun getPraiseByMemberId(@PathVariable memberId: UUID): PraiseResponse =
        praiseService.getPraiseByMemberId(memberId)

    @GetMapping("{id}")
    fun getPraiseDetails(id: UUID): PraiseDetailsResponse =
        praiseService.getPraiseDetails(id)
}
