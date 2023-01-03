package com.najudoryeong.mineme

import androidx.navigation.NavDirections
import com.najudoryeong.mineme.setting.fragment.SettingFragmentDirections

enum class DirectionMapping(val layoutID : Int,val actionID : NavDirections){

    TO_SETTING_ACCOUNT(com.najudoryeong.mineme.setting.R.layout.fragment_setting_account, SettingFragmentDirections.actionSettingToSettingAccountFragment()),
    TO_SETTING_INQUIRY(com.najudoryeong.mineme.setting.R.layout.fragment_setting_inquiry, SettingFragmentDirections.actionSettingToSettingInquiryFragment()),
    TO_SETTING_NOTICE(com.najudoryeong.mineme.setting.R.layout.fragment_setting_notice, SettingFragmentDirections.actionSettingToSettingNoticeFragment()),
    TO_SETTING_NOTIFICATION(com.najudoryeong.mineme.setting.R.layout.fragment_setting_notification, SettingFragmentDirections.actionSettingToSettingNotificationFragment()),
    TO_SETTING_SECURITY(com.najudoryeong.mineme.setting.R.layout.fragment_setting_security, SettingFragmentDirections.actionSettingToSettingSecurityFragment())

}