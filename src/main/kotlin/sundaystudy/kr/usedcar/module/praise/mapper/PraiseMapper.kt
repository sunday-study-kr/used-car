package sundaystudy.kr.usedcar.module.praise.mapper

import org.springframework.stereotype.Component
import sundaystudy.kr.usedcar.module.member.entity.Member
import sundaystudy.kr.usedcar.module.praise.dto.request.PraiseRequest
import sundaystudy.kr.usedcar.module.praise.dto.response.PraiseDetailsResponse
import sundaystudy.kr.usedcar.module.praise.dto.response.PraiseResponse
import sundaystudy.kr.usedcar.module.praise.entity.Praise

@Component
class PraiseMapper {
    fun toEntity(praiseRequest: PraiseRequest, member: Member, praiser: Member): Praise =
        Praise(
            praiseType = praiseRequest.praiseType,
            content = praiseRequest.content,
            member = member,
            praiser = praiser
        )

    fun toResponseList(praiseList: List<Praise>): List<PraiseResponse> =
        praiseList.map(this::toResponse)

    private fun toResponse(praise: Praise): PraiseResponse =
        PraiseResponse(
            id = praise.id,
            memberId = praise.member.id,
            praiseType = praise.praiseType,
            amount = praise.amount
        )

    fun toDetailsResponse(praise: Praise): PraiseDetailsResponse =
        PraiseDetailsResponse(
            id = praise.id,
            praiseType = praise.praiseType,
            content = praise.content
        )
}
