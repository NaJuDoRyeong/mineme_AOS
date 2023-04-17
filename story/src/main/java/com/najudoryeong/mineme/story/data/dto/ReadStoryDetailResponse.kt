package com.najudoryeong.mineme.story.data.dto

import android.net.Uri

data class ReadStoryDetailResponse(
    val stories : List<StoryDetailData>
)

data class StoryDetailData(
    val region : String,
    val isAnniversary : String,
    val anniversary : Anniversary?,
    val date : String,
    val images : List<String>,
    val postId : Long,
    val content : String,
    val author : String
)


data class UseStoryDetailData(
    val region : String,
    val isAnniversary : String,
    val anniversary : Anniversary?,
    val date : String,
    val images : List<Uri>,
    val postId : Long,
    val content : String,
    val author : String
)



data class Anniversary(
    val type : String,
    val day : Long
)