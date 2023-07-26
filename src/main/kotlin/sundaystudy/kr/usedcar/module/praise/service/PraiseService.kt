package sundaystudy.kr.usedcar.module.praise.service

import org.springframework.stereotype.Service
import sundaystudy.kr.usedcar.global.dto.IdResponse
import sundaystudy.kr.usedcar.module.praise.dto.request.PraiseRequest
import sundaystudy.kr.usedcar.module.praise.dto.response.PraiseDetailsResponse
import sundaystudy.kr.usedcar.module.praise.dto.response.PraiseResponse
import sundaystudy.kr.usedcar.module.praise.repository.PraiseRepository
import java.util.*

@Service
class PraiseService(
    private val praiseRepository: PraiseRepository,
) {
    fun savePraise(praiseRequest: PraiseRequest): IdResponse {
        TODO("Not yet implemented")
    }

    fun getAllPraises(): List<PraiseResponse> {
        TODO("Not yet implemented")
    }

    fun getPraiseByMemberId(memberId: UUID): PraiseResponse {
        TODO("Not yet implemented")
    }

    fun getPraiseDetails(id: UUID): PraiseDetailsResponse {
        TODO("Not yet implemented")
    }
}
