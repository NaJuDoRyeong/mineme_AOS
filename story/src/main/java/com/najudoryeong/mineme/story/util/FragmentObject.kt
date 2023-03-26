package com.najudoryeong.mineme.story.util

import android.view.View
import com.najudoryeong.mineme.common_ui.FragmentInfoUtil
import com.najudoryeong.mineme.story.R


// todo hilt?
object StoryFoundationInfo : FragmentInfoUtil {
    override val layoutID: Int
        get() = R.layout.fragment_story
    override val toolbarText: Int
        get() = R.string.diary
    override val menu: Int
        get() = R.menu.story_menu
    override val bottomNavi_visibility: Int
        get() = View.VISIBLE
}

object WriteStoryFoundationInfo : FragmentInfoUtil {

    override val layoutID: Int
        get() = R.layout.fragment_write_story
    override val toolbarText: Int
        get() = R.string.write_story
    override val menu: Int
        get() = R.menu.write_story_menu
    override val bottomNavi_visibility: Int
        get() = View.GONE

}


object DetailStoryFoundationInfo : FragmentInfoUtil {

    override val layoutID: Int
        get() = R.layout.fragment_story_detail
    override val toolbarText: Int
        get() = R.string.story
    override val menu: Int
        get() = R.menu.story_menu
    override val bottomNavi_visibility: Int
        get() = View.VISIBLE

}