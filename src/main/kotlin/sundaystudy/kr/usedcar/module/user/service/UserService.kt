package sundaystudy.kr.usedcar.module.user.service

import org.springframework.stereotype.Service
import sundaystudy.kr.usedcar.module.user.dto.response.UserDetailsResponse
import sundaystudy.kr.usedcar.module.user.repository.UserRepository

@Service
class UserService(
    private val userRepository: UserRepository,
) {
    fun getUserDetails(): UserDetailsResponse {
        TODO("Not yet implemented")
    }
}
