package sundaystudy.kr.usedcar.module.usedcar.controller

import UsedCarResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sundaystudy.kr.usedcar.global.dto.IdResponse
import sundaystudy.kr.usedcar.module.usedcar.dto.request.UsedCarSaveRequest
import sundaystudy.kr.usedcar.module.usedcar.service.UsedCarService
import java.util.UUID

@RestController
@RequestMapping("/usedcar")
class UsedCarController(
    private val usedCarService: UsedCarService
){
    @PostMapping()
    fun saveUsedCar(usedCarSaveRequest: UsedCarSaveRequest) : ResponseEntity<IdResponse>
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(usedCarService.saveUsedCar(usedCarSaveRequest))
    }

    @GetMapping("/{id}")
    fun getUsedCarById(@PathVariable id : UUID) : ResponseEntity<UsedCarResponse>
    {
        return ResponseEntity.status(HttpStatus.OK).body(usedCarService.getUsedCar(id))
    }

    @DeleteMapping("/{id}")
    fun deleteUsedCarById(@PathVariable id : UUID)
    {
        usedCarService.deleteUsedCar(id)
    }

}
