package sundaystudy.kr.usedcar.module.matching.mapper

import org.springframework.stereotype.Component
import sundaystudy.kr.usedcar.module.matching.dto.MatchingResponse
import sundaystudy.kr.usedcar.module.matching.entity.Matching
import sundaystudy.kr.usedcar.module.member.entity.Member
import sundaystudy.kr.usedcar.module.post.entity.Post

@Component
class MatchingMapper {

    fun toResponse(matching: Matching): MatchingResponse =
        MatchingResponse(
            id = matching.id,
            requestMemberId = matching.requestMember?.id,
            postOwnerId = matching.postOwner?.id
        )

    fun toResponses(matchings: List<Matching>): List<MatchingResponse> =
        matchings.map(this::toResponse)

    fun toEntity(post: Post, requestUser: Member, member: Member?): Matching =
        Matching(
            post = post,
            requestMember = requestUser,
            postOwner = member
        )
}
