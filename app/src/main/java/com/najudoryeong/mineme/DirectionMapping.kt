package com.najudoryeong.mineme

import androidx.navigation.NavDirections
import com.najudoryeong.mineme.home.HomeFragmentDirections
import com.najudoryeong.mineme.onboarding.InputCodeFragmentDirections
import com.najudoryeong.mineme.onboarding.InputUserInfoFragmentDirections
import com.najudoryeong.mineme.onboarding.LoginFragmentDirections
import com.najudoryeong.mineme.onboarding.OnBoardingViewPagerFragmentDirections
import com.najudoryeong.mineme.setting.fragment.SettingFragmentDirections

enum class DirectionMapping(val layoutID : Int,val actionID : NavDirections){

    TO_SETTING_ACCOUNT(com.najudoryeong.mineme.setting.R.layout.fragment_setting_account, SettingFragmentDirections.actionSettingToSettingAccountFragment()),
    TO_SETTING_INQUIRY(com.najudoryeong.mineme.setting.R.layout.fragment_setting_inquiry, SettingFragmentDirections.actionSettingToSettingInquiryFragment()),
    TO_SETTING_NOTICE(com.najudoryeong.mineme.setting.R.layout.fragment_setting_notice, SettingFragmentDirections.actionSettingToSettingNoticeFragment()),
    TO_SETTING_NOTIFICATION(com.najudoryeong.mineme.setting.R.layout.fragment_setting_notification, SettingFragmentDirections.actionSettingToSettingNotificationFragment()),
    TO_SETTING_SECURITY(com.najudoryeong.mineme.setting.R.layout.fragment_setting_security, SettingFragmentDirections.actionSettingToSettingSecurityFragment()),
    TO_LOGIN(com.najudoryeong.mineme.onboarding.R.layout.fragment_login,OnBoardingViewPagerFragmentDirections.actionOnBoardingViewPagerFragmentToLoginFragment()),
    TO_INPUT_USER_INFO(com.najudoryeong.mineme.onboarding.R.layout.fragment_input_user_info,LoginFragmentDirections.actionLoginToInputUserInfoFragment()),
    TO_INPUT_CODE(com.najudoryeong.mineme.onboarding.R.layout.fragment_input_code,InputUserInfoFragmentDirections.actionInputUserInfoFragmentToInputCodeFragment()),
    TO_HOME(com.najudoryeong.mineme.home.R.layout.fragment_home,InputCodeFragmentDirections.actionInputCodeFragmentToHome()),
    TO_ONBOARDING(com.najudoryeong.mineme.home.R.layout.fragment_home,HomeFragmentDirections.actionHomeToNavigation())
}