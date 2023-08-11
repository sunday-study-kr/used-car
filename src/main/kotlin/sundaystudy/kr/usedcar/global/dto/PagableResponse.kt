package sundaystudy.kr.usedcar.global.dto

data class PageableeResponse<T>(
    val result: List<T>,
    val limit: Number,
    val offset: Number,
    val total: Number,
)