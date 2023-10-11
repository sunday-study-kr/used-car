package sundaystudy.kr.usedcar.module.usedcar.controller

import UsedCarResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import sundaystudy.kr.usedcar.global.dto.IdResponse
import sundaystudy.kr.usedcar.module.usedcar.dto.request.UpdateUsedCarRequest
import sundaystudy.kr.usedcar.module.usedcar.dto.request.UsedCarSaveRequest
import sundaystudy.kr.usedcar.module.usedcar.service.UsedCarService
import java.util.UUID

@RestController
@RequestMapping("/usedcar")
class UsedCarController(
    private val usedCarService: UsedCarService
){
    @PostMapping()
    fun saveUsedCar(@RequestBody usedCarSaveRequest: UsedCarSaveRequest) : ResponseEntity<IdResponse>
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(usedCarService.saveUsedCar(usedCarSaveRequest))
    }

    @GetMapping("/{id}")
    fun getUsedCarById(@PathVariable id : UUID) : ResponseEntity<UsedCarResponse>
    {
        return ResponseEntity.status(HttpStatus.OK).body(usedCarService.getUsedCar(id))
    }

    @PutMapping("/change")
    fun updateUsedCarInfo(@RequestBody request : UpdateUsedCarRequest) : ResponseEntity<Unit>
    {
        return ResponseEntity.status(HttpStatus.OK).body(usedCarService.updateUsedCarInfo(request))
    }

    @DeleteMapping("/{id}")
    fun deleteUsedCarById(@PathVariable id : UUID) : ResponseEntity<Unit>
    {
        usedCarService.deleteUsedCar(id)

        return ResponseEntity.status(HttpStatus.OK).body(Unit)
    }

}
