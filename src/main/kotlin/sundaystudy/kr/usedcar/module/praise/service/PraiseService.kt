package sundaystudy.kr.usedcar.module.praise.service

import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import sundaystudy.kr.usedcar.global.dto.IdResponse
import sundaystudy.kr.usedcar.global.exception.EntityNotFoundException
import sundaystudy.kr.usedcar.module.member.service.AuthService
import sundaystudy.kr.usedcar.module.member.service.MemberService
import sundaystudy.kr.usedcar.module.praise.dto.request.PraiseRequest
import sundaystudy.kr.usedcar.module.praise.dto.response.PraiseDetailsResponse
import sundaystudy.kr.usedcar.module.praise.dto.response.PraiseResponse
import sundaystudy.kr.usedcar.module.praise.entity.Praise
import sundaystudy.kr.usedcar.module.praise.mapper.PraiseMapper
import sundaystudy.kr.usedcar.module.praise.repository.PraiseRepository
import java.util.*

@Service
class PraiseService(
    private val praiseRepository: PraiseRepository,
    private val praiseMapper: PraiseMapper,
    private val authService: AuthService,
    private val memberService: MemberService,
) {
    fun savePraise(praiseRequest: PraiseRequest): IdResponse {
        val praiser = authService.getLoginUser()
        val praiseReciever = memberService.getEntity(praiseRequest.memberId)
        val praise = praiseRepository.save(praiseMapper.toEntity(praiseRequest, praiseReciever, praiser))
        return IdResponse(praise.id)
    }

    fun getAllPraises(pageable: Pageable): List<PraiseResponse> =
        praiseMapper.toResponseList(praiseRepository.findAll(pageable).content)


    fun getPraiseByMemberId(memberId: UUID): List<PraiseResponse> {
        val praiseReciever = memberService.getEntity(memberId)
        return praiseMapper.toResponseList(praiseRepository.findByMember(praiseReciever))
    }

    fun getPraiseDetails(id: UUID): PraiseDetailsResponse =
        praiseMapper.toDetailsResponse(getEntity(id))

    private fun getEntity(id: UUID): Praise =
        praiseRepository.findByIdOrNull(id) ?: throw EntityNotFoundException()
}
