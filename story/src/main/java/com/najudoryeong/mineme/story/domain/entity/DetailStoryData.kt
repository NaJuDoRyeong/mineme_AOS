package com.najudoryeong.mineme.story.domain.entity

data class DetailStoryData(
    val List:
)



data class DetailStory(

    val region : String,
    val isAnniversary : String,
    val anniversary : Anniversary,
    val date : String,
    val images : List<String>,
    val postId : Int,
    val content : String,
    val author : String
)

data class Anniversary(
    val type : String,
    val day : Int
)