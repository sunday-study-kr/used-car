package sundaystudy.kr.usedcar.module.bookmark.controller

import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import sundaystudy.kr.usedcar.global.dto.IdResponse
import sundaystudy.kr.usedcar.module.bookmark.dto.BookmarkResponse
import sundaystudy.kr.usedcar.module.bookmark.service.BookmarkService
import java.util.*

@RestController("bookmark")
class BookmarkController(
    private val bookmarkService: BookmarkService
) {
    @GetMapping("/")
    fun getBookmarkList(pageable: Pageable): ResponseEntity<List<BookmarkResponse>> {
        return ResponseEntity.ok(bookmarkService.getBookmarks())
    }

    @PostMapping("/post/{id}")
    fun saveBookmark(@PathVariable("id") id: UUID): ResponseEntity<IdResponse> {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookmarkService.saveBookmark(id))
    }

    @DeleteMapping("/post/{id}")
    fun deleteBookmark(@PathVariable("id") id: UUID): ResponseEntity<BookmarkResponse> {
        bookmarkService.deleteBookmark(id)
        return ResponseEntity.ok().build()
    }
}
