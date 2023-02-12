package com.example.common.data.entity

data class StoryWithDate(
    val year : String,
    val month : String,
    val posts : List<Story>
)