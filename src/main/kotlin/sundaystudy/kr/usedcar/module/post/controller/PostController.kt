package sundaystudy.kr.usedcar.module.post.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sundaystudy.kr.usedcar.global.dto.IdResponse
import sundaystudy.kr.usedcar.module.post.dto.request.PostRequest
import sundaystudy.kr.usedcar.module.post.dto.response.PostResponse
import sundaystudy.kr.usedcar.module.post.service.PostService
import java.util.UUID

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

    @GetMapping("/user/{id}")
    fun getPostByUserId(@PathVariable id : UUID) : ResponseEntity<List<PostResponse>>
    {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPostByUserId(id))
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
