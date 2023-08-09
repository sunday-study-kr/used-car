package sundaystudy.kr.usedcar.module.post.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import sundaystudy.kr.usedcar.global.dto.IdResponse
import sundaystudy.kr.usedcar.module.post.dto.request.PostRequest
import sundaystudy.kr.usedcar.module.post.dto.response.PostResponse
import sundaystudy.kr.usedcar.module.post.service.PostService
import java.util.*

@RestController
@RequestMapping("/post")
class PostController(
    private val postService: PostService
) {
    @PostMapping()
    fun savePost(postRequest: PostRequest) : ResponseEntity<IdResponse>
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.savePost(postRequest))
    }

    @GetMapping("/member/{id}")
    fun getPostByMemberId(@PathVariable id : UUID) : ResponseEntity<List<PostResponse>>
    {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPostByMemberId(id))
    }

    @GetMapping("/{id}")
    fun getPostById(@PathVariable id : UUID) : ResponseEntity<PostResponse>
    {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPostById(id))
    }

    @DeleteMapping("/{id}")
    fun deletePostById(@PathVariable id :UUID) : ResponseEntity<Unit>
    {
        postService.deletePostById(id)

        return ResponseEntity.status(HttpStatus.OK).body(Unit)
    }
}
