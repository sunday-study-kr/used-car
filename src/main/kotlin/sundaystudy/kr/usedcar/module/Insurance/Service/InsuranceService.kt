package sundaystudy.kr.usedcar.module.Insurance.Service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class InsuranceService(@Autowired val insuranceService: InsuranceService) {
}
