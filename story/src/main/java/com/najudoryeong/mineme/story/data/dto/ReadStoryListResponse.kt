package com.najudoryeong.mineme.story.data.dto

import com.najudoryeong.mineme.story.domain.entity.StoryListWithDate

data class ReadStoryListResponse(
    val stories : List<StoryListWithDate>
)