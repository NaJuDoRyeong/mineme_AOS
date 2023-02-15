package com.najudoryeong.mineme.home

import android.view.View
import com.najudoryeong.mineme.common_ui.FragmentInfoUtil



object Home : FragmentInfoUtil {
    override val layoutID: Int
        get() = R.layout.fragment_home
    override val toolbarText: Int
        get() = R.string.home
    override val menu: Int
        get() = com.najudoryeong.mineme.common_ui.R.menu.home_menu
    override val bottomNavi_visibility: Int
        get() = View.VISIBLE
}