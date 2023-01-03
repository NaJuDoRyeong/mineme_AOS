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

object SettingAccount : FragmentInfoUtil {
    override val layoutID: Int
        get() = R.layout.fragment_setting_account
    override val toolbarText: Int
        get() = R.string.account
    override val menu: Int
        get() = -1
    override val bottomNavi_visibility: Int
        get() = View.VISIBLE
}


object SettingInquiry : FragmentInfoUtil {
    override val layoutID: Int
        get() = R.layout.fragment_setting_inquiry
    override val toolbarText: Int
        get() = R.string.inquiry
    override val menu: Int
        get() = -1
    override val bottomNavi_visibility: Int
        get() = View.VISIBLE
}

object SettingNotice : FragmentInfoUtil {
    override val layoutID: Int
        get() = R.layout.fragment_setting_notice
    override val toolbarText: Int
        get() = R.string.notice
    override val menu: Int
        get() = -1
    override val bottomNavi_visibility: Int
        get() = View.VISIBLE
}

object SettingNotification : FragmentInfoUtil {
    override val layoutID: Int
        get() = R.layout.fragment_setting_notification
    override val toolbarText: Int
        get() = R.string.notification

    override val menu: Int
        get() = -1
    override val bottomNavi_visibility: Int
        get() = View.VISIBLE
}

object SettingSecurity : FragmentInfoUtil {
    override val layoutID: Int
        get() = R.layout.fragment_setting_security
    override val toolbarText: Int
        get() = R.string.security
    override val menu: Int
        get() = -1
    override val bottomNavi_visibility: Int
        get() = View.VISIBLE
}