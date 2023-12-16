package sundaystudy.kr.usedcar.module.bookmark.service

import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import sundaystudy.kr.usedcar.global.dto.IdResponse
import sundaystudy.kr.usedcar.global.exception.EntityNotFoundException
import sundaystudy.kr.usedcar.module.bookmark.dto.BookmarkResponse
import sundaystudy.kr.usedcar.module.bookmark.entity.Bookmark
import sundaystudy.kr.usedcar.module.bookmark.mapper.BookmarkMapper
import sundaystudy.kr.usedcar.module.bookmark.repository.BookmarkRepository
import sundaystudy.kr.usedcar.module.member.service.AuthService
import sundaystudy.kr.usedcar.module.post.service.PostService
import java.util.*

@Service
class BookmarkService(
    private val bookmarkRepository: BookmarkRepository,
    private val postService: PostService,
    private val authService: AuthService,
    private val bookmarkMapper: BookmarkMapper,
) {
    fun getUserId(): UUID = authService.getLoginUser().id

    fun getBookmarks(): List<BookmarkResponse> {
        return bookmarkMapper.toResponseList(bookmarkRepository.findAllByMemberId(getUserId()))
    }

    @Transactional
    fun saveBookmark(postId: UUID): IdResponse {
        val member = authService.getLoginUser()
        val post = postService.getPostEntity(postId)
        val bookmark = bookmarkRepository.save(
            Bookmark(
                post,
                member
            )
        )
        return IdResponse(bookmark.id)
    }

    @Transactional
    fun deleteBookmark(bookmarkId: UUID) {
        val bookmark = bookmarkRepository.findByIdOrNull(bookmarkId) ?: throw EntityNotFoundException()
        bookmark.delete()
    }
}
