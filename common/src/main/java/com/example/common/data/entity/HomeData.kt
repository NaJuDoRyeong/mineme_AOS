package com.example.common.data.entity

import com.kakao.sdk.user.model.User

data class HomeData(
    val couple: Couple,
    val newStory: Story,
    val widgets: List<Widget>
)


data class Couple(
    val me: UserInfo,
    val mine: UserInfo,
    val name: String,
    val startDate: String
)


data class Story(
    val date: String,
    val postId: Int,
    val region: String,
    val thumbnailImage: String
)


data class UserInfo(
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