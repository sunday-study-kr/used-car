package sundaystudy.kr.usedcar.module.bookmark.repository

import org.springframework.data.jpa.repository.JpaRepository
import sundaystudy.kr.usedcar.module.bookmark.entity.Bookmark
import java.util.UUID

interface BookmarkRepository : JpaRepository<Bookmark, UUID>
