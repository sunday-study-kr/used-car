package sundaystudy.kr.usedcar.module.matching.service

import org.springframework.stereotype.Service
import sundaystudy.kr.usedcar.module.matching.repository.MatchingRepository

@Service
class MatchingService(
    private val matchingRepository: MatchingRepository
) {
}