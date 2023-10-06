package sundaystudy.kr.usedcar.module.bookmark.mapper

import org.mapstruct.Mapper
import sundaystudy.kr.usedcar.module.bookmark.dto.BookmarkResponse
import sundaystudy.kr.usedcar.module.bookmark.entity.Bookmark

@Mapper
interface BookmarkMapper {
    fun toResponseList(reviewList: List<Bookmark>): List<BookmarkResponse>
    fun toResponse(bookmark: Bookmark): BookmarkResponse
}