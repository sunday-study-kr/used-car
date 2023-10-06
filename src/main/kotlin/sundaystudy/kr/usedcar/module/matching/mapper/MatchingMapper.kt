package sundaystudy.kr.usedcar.module.matching.mapper

import org.mapstruct.Mapper
import sundaystudy.kr.usedcar.module.matching.dto.MatchingResponse
import sundaystudy.kr.usedcar.module.matching.entity.Matching

@Mapper
interface MatchingMapper {

    fun toListResponse(matchingList: List<Matching>): List<MatchingResponse>
    fun toResponse(matching: Matching): MatchingResponse
}