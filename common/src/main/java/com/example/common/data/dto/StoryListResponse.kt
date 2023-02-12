package com.example.common.data.dto

import com.example.common.data.entity.StoryWithDate

data class StoryListResponse(
    val success: Boolean,
    val data: List<StoryWithDate>
)