package sundaystudy.kr.usedcar.module.usedcar.controller

import UsedCarResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import sundaystudy.kr.usedcar.global.dto.IdResponse
import sundaystudy.kr.usedcar.module.usedcar.dto.request.UpdateAccidentRequest
import sundaystudy.kr.usedcar.module.usedcar.dto.request.UpdateUnsubscribedRequest
import sundaystudy.kr.usedcar.module.usedcar.dto.request.UpdateUsedCarRequest
import sundaystudy.kr.usedcar.module.usedcar.dto.request.UsedCarSaveRequest
import sundaystudy.kr.usedcar.module.usedcar.service.UsedCarService
import java.util.*

@RestController
@RequestMapping("/usedcar")
class UsedCarController(
    private val usedCarService: UsedCarService
) {
    @PostMapping
    fun saveUsedCar(@RequestBody usedCarSaveRequest: UsedCarSaveRequest): ResponseEntity<IdResponse> {
        return ResponseEntity.status(HttpStatus.CREATED).body(usedCarService.saveUsedCar(usedCarSaveRequest))
    }

    @GetMapping("/{id}")
    fun getUsedCarById(@PathVariable id: UUID): ResponseEntity<UsedCarResponse> {
        return ResponseEntity.ok(usedCarService.getUsedCar(id))
    }

    @PutMapping
    fun updateUsedCarInfo(@RequestBody request: UpdateUsedCarRequest): ResponseEntity<Unit> {
        usedCarService.updateUsedCarInfo(request)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/accident")
    fun updateAccident(@RequestBody request: UpdateAccidentRequest): ResponseEntity<Unit> {
        usedCarService.updateCarAccident(request)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/unsubscribed")
    fun updateUnsubscribed(@RequestBody request: UpdateUnsubscribedRequest): ResponseEntity<Unit> {
        usedCarService.updateUnsubscribed(request)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/{id}")
    fun deleteUsedCarById(@PathVariable id: UUID): ResponseEntity<Unit> {
        usedCarService.deleteUsedCar(id)
        return ResponseEntity.noContent().build()
    }
}
