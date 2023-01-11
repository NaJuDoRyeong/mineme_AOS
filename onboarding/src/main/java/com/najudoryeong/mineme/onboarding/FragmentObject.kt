package com.najudoryeong.mineme.onboarding

import android.view.View
import com.najudoryeong.mineme.common_ui.FragmentInfoUtil

//todo
object Login : FragmentInfoUtil {
    override val layoutID: Int
        get() = R.layout.fragment_login
    override val toolbarText: Int
        get() = 0
    override val menu: Int
        get() = -1
    override val bottomNavi_visibility: Int
        get() = View.VISIBLE
}

object InputUserInfo : FragmentInfoUtil {
    override val layoutID: Int
        get() = R.layout.fragment_input_user_info
    override val toolbarText: Int
        get() = 0
    override val menu: Int
        get() = -1
    override val bottomNavi_visibility: Int
        get() = View.VISIBLE
}

object InputCode : FragmentInfoUtil {
    override val layoutID: Int
        get() = R.layout.fragment_input_code
    override val toolbarText: Int
        get() = 0
    override val menu: Int
        get() = -1
    override val bottomNavi_visibility: Int
        get() = View.VISIBLE
}