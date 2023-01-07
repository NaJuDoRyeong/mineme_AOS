package com.najudoryeong.mineme.common_ui

import androidx.navigation.NavController


interface MainViewModelUtil{
    fun setToolbarTitle(newTitle: String)
    fun setVisibilityBottomAppbar(visibilityMode : Int)
    fun setVisibilityTopAppBar(visibilityMode: Int)
}