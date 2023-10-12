package sundaystudy.kr.usedcar.module.bookmark.service

import jakarta.transaction.Transactional
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import sundaystudy.kr.usedcar.module.bookmark.dto.BookmarkResponse
import sundaystudy.kr.usedcar.module.bookmark.entity.Bookmark
import sundaystudy.kr.usedcar.module.bookmark.mapper.BookmarkMapper
import sundaystudy.kr.usedcar.module.bookmark.repository.BookmarkRepository
import sundaystudy.kr.usedcar.module.member.repository.MemberRepository
import sundaystudy.kr.usedcar.module.member.service.AuthService
import sundaystudy.kr.usedcar.module.post.repository.PostRepository
import java.util.*

@Service
class BookmarkService(
    private val bookmarkRepository: BookmarkRepository,
    private val memberRepository: MemberRepository,
    private val postRepository: PostRepository,
    private val authService: AuthService,
    private val bookmarkMapper: BookmarkMapper,
) {
    fun getUserId(): UUID = authService.getLoginUser().id

    fun getBookmarkList(): List<BookmarkResponse> {
        return bookmarkMapper.toResponseList(bookmarkRepository.findAllByMemberId(getUserId()))
    }

    @Transactional
    fun saveBookmark(postId: UUID) {
        val member = memberRepository.getReferenceById(getUserId())
        val post = postRepository.getReferenceById(postId)
        bookmarkRepository.save(Bookmark(
            post,
            member
        ))
    }

    @Transactional
    fun deleteBookmark(bookmarkId: UUID) {
        bookmarkRepository.getReferenceById(bookmarkId).delete()
    }
}