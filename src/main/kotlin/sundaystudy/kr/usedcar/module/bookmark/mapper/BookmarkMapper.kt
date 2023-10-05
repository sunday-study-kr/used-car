package sundaystudy.kr.usedcar.module.bookmark.mapper

import org.springframework.stereotype.Component
import sundaystudy.kr.usedcar.module.bookmark.dto.BookmarkResponse
import sundaystudy.kr.usedcar.module.bookmark.entity.Bookmark

@Component
class BookmarkMapper {
    fun toResponseList(reviewList: List<Bookmark>): List<BookmarkResponse> =
        reviewList.map(this::toResponse)

    fun toResponse(bookmark: Bookmark): BookmarkResponse =
        BookmarkResponse(
            bookmarkId = bookmark.id.toString(),
        )
}