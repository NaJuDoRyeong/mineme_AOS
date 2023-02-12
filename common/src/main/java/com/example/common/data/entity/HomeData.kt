package com.example.common.data.entity

data class HomeData(
    val couple: Couple,
    val newStory: NewStory,
    val widgets: List<Widget>
)


data class Couple(
    val me: Me,
    val mine: Mine,
    val name: String,
    val startDate: String
)


data class NewStory(
    val date: String,
    val postId: Int,
    val region: String,
    val thumbnailImage: String
)


data class Mine(
    val birthday: String,
    val description: String,
    val gender: String,
    val instaId: String,
    val nickname: String,
    val profileImage: String
)


data class Me(
    val birthday: String,
    val description: String,
    val gender: String,
    val instaId: String,
    val nickname: String,
    val profileImage: String
)


data class Widget(
    val Id: Int,
    val color: String,
    val heigth: Int,
    val name: String,
    val order: Int,
    val type: String,
    val widget: WidgetX,
    val width: Int
)

class WidgetX