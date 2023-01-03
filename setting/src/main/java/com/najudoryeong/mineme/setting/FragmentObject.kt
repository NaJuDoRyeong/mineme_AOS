package com.najudoryeong.mineme.setting

import android.view.View
import com.najudoryeong.mineme.common_ui.FragmentInfoUtil



object Setting : FragmentInfoUtil {
    override val layoutID: Int
        get() = R.layout.fragment_setting
    override val toolbarText: Int
        get() = R.string.setting
    override val menu: Int
        get() = -1
    override val bottomNavi_visibility: Int
        get() = View.VISIBLE
}