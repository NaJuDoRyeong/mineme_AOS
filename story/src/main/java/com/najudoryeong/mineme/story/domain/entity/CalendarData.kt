package com.najudoryeong.mineme.story.domain.entity

data class CalendarData(
    val day : String,
    val data :CalendarItemData?
)

data class CalendarItemData(
    val postId: Int,
    val imageUrl: String
)
