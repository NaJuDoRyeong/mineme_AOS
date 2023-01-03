package com.najudoryeong.mineme.setting.fragment

import com.najudoryeong.mineme.common_ui.BaseFragment
import com.najudoryeong.mineme.common_ui.MainActivityUtil
import com.najudoryeong.mineme.setting.*
import com.najudoryeong.mineme.setting.databinding.FragmentSettingBinding


class SettingFragment : BaseFragment<FragmentSettingBinding>(Setting) {
    override fun initView() {
        binding.apply {

            toAccountTV.setOnClickListener {
                (activity as MainActivityUtil).run {
                    navigate(this@SettingFragment, SettingAccount)
                }
            }

            toNotificationTV.setOnClickListener {
                (activity as MainActivityUtil).run {
                    navigate(this@SettingFragment, SettingNotification)
                }
            }

            toSecurityTV.setOnClickListener {
                (activity as MainActivityUtil).run {
                    navigate(this@SettingFragment, SettingSecurity)
                }
            }

            toNoticeTV.setOnClickListener {
                (activity as MainActivityUtil).run {
                    navigate(this@SettingFragment, SettingNotice)
                }
            }

            toInquiryTV.setOnClickListener {
                (activity as MainActivityUtil).run {
                    navigate(this@SettingFragment, SettingInquiry)
                }
            }

        }
    }

}