package sundaystudy.kr.usedcar.module.user.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sundaystudy.kr.usedcar.module.user.dto.response.UserDetailsResponse
import sundaystudy.kr.usedcar.module.user.service.UserService

@RestController
@RequestMapping("users")
class UserController(
    private val userService: UserService,
) {
    @GetMapping("me")
    fun getUserDetails(): UserDetailsResponse =
        userService.getUserDetails()
}
