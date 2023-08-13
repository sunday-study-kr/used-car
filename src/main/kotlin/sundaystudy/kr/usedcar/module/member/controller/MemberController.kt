package sundaystudy.kr.usedcar.module.member.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sundaystudy.kr.usedcar.module.member.dto.response.MemberDetailsResponse
import sundaystudy.kr.usedcar.module.member.service.MemberService

@RestController
@RequestMapping("members")
class MemberController(
    private val memberService: MemberService,
) {
    @GetMapping("me")
    fun getMemberDetails(): ResponseEntity<MemberDetailsResponse> =
        ResponseEntity.ok(memberService.getMemberDetails())
}
