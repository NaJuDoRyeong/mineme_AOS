package com.najudoryeong.mineme.story.domain.entity

import com.najudoryeong.mineme.common.domain.entity.Story

data class StoryListWithDate(
    val year : String,
    val month : String,
    val posts : List<Story>
)