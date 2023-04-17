package com.najudoryeong.mineme.setting.fragment.ui

import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.najudoryeong.mineme.common_ui.BaseFragment
import com.najudoryeong.mineme.setting.*
import com.najudoryeong.mineme.setting.databinding.FragmentSettingBinding


class SettingFragment : BaseFragment<FragmentSettingBinding>(Setting) {
    override fun initView() {
        binding.apply {

            toAccountTV.setOnClickListener {
                findNavController().navigate(R.id.to_settingAccountFragment)
            }

            toNotificationTV.setOnClickListener {
                findNavController().navigate(R.id.to_settingNotificationFragment)

            }

            toSecurityTV.setOnClickListener {
                findNavController().navigate(R.id.to_settingSecurityFragment)
            }

            toNoticeTV.setOnClickListener {
                findNavController().navigate(R.id.to_settingNoticeFragment)
            }

            toInquiryTV.setOnClickListener {
                findNavController().navigate(R.id.to_settingInquiryFragment)
            }

        }
    }

}