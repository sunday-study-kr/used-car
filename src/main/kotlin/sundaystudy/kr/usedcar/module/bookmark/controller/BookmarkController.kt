package sundaystudy.kr.usedcar.module.bookmark.controller

import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import sundaystudy.kr.usedcar.global.dto.PageableeResponse
import sundaystudy.kr.usedcar.module.bookmark.dto.BookmarkResponse
import sundaystudy.kr.usedcar.module.bookmark.service.BookmarkService

@RestController("bookmark")
class BookmarkController(
    private val bookmarkService: BookmarkService
) {
    @GetMapping("/")
    fun getBookmarkList(pageable: Pageable): ResponseEntity<PageableeResponse<BookmarkResponse>> {
        return ResponseEntity.status(HttpStatus.OK).body(PageableeResponse(bookmarkService.getBookmarkList(), pageable.pageNumber, pageable.offset, 0))
    }

    @PostMapping("/post/{id}")
    fun saveBookmark(@PathVariable("id") id: String): ResponseEntity<BookmarkResponse> {

        return ResponseEntity.status(HttpStatus.CREATED).body(BookmarkResponse(""))
    }

    @DeleteMapping("/post/{id}")
    fun deleteBookmark(@PathVariable("id") id: String): ResponseEntity<BookmarkResponse> {

        return ResponseEntity.status(HttpStatus.OK).body(BookmarkResponse(""))
    }
}