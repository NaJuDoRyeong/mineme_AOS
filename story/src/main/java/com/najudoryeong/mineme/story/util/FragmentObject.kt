package com.najudoryeong.mineme.story.util

import android.view.View
import com.najudoryeong.mineme.common_ui.FragmentInfoUtil
import com.najudoryeong.mineme.story.R


object Story_Foundation_Info : FragmentInfoUtil {
    override val layoutID: Int
        get() = R.layout.fragment_story
    override val toolbarText: Int
        get() = R.string.story
    override val menu: Int
        get() = com.najudoryeong.mineme.common_ui.R.menu.story_menu
    override val bottomNavi_visibility: Int
        get() = View.VISIBLE
}