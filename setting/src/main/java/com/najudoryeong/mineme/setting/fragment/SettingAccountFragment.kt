package com.najudoryeong.mineme.setting.fragment


import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import com.najudoryeong.mineme.common_ui.BaseFragment
import com.najudoryeong.mineme.setting.R
import com.najudoryeong.mineme.setting.SettingAccount
import com.najudoryeong.mineme.setting.databinding.FragmentSettingAccountBinding


class SettingAccountFragment : BaseFragment<FragmentSettingAccountBinding>(SettingAccount), OnClickListener {

    override fun initView() {
        binding.apply {
            myCode.setOnClickListener(this@SettingAccountFragment)
            targetCode.setOnClickListener(this@SettingAccountFragment)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.my_code -> {
                val text = binding.myCode.text.toString()
                clipText(text)
            }
            R.id.target_code -> {
                val text = binding.targetCode.text.toString()
                clipText(text)
            }
        }
    }

    fun clipText(text: String) {
        val clipboard = activity?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip: ClipData = ClipData.newPlainText("AccountCode", text)
        clipboard.setPrimaryClip(clip)
        Toast.makeText(context, "클립보드에 복사되었습니다.", Toast.LENGTH_SHORT).show()
    }

}