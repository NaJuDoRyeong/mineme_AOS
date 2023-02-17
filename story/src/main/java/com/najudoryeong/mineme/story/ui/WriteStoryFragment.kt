package com.najudoryeong.mineme.story.ui

import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.najudoryeong.mineme.common_ui.BaseFragment
import com.najudoryeong.mineme.common_ui.CalendarUtil.Companion.getTodayDate
import com.najudoryeong.mineme.common_ui.CalendarUtil.Companion.parseStringToDate
import com.najudoryeong.mineme.common_ui.DialogForDatePicker
import com.najudoryeong.mineme.common_ui.R.layout.item_dropdown
import com.najudoryeong.mineme.story.databinding.FragmentWriteStoryBinding
import com.najudoryeong.mineme.story.util.WriteStoryFoundationInfo


class WriteStoryFragment : BaseFragment<FragmentWriteStoryBinding>(WriteStoryFoundationInfo) {

    override fun initView() {
        val doItems = listOf(
            "위치 없음",
            "경상북도",
            "강원도",
            "무신사",
            "제주도",
            "울릉도",
            "경상남도",
            "경상북도",
            "강원도",
            "무신사",
            "제주도",
            "울릉도",
            "경상남도",
            "경상북도",
            "강원도",
            "무신사",
            "제주도",
            "울릉도",
            "경상남도",
            "경상북도",
            "강원도",
            "무신사",
            "제주도",
            "울릉도"
        )
        val siItems = listOf("위치 없음", "마산시1", "마산시4", "마산시2", "마산시3", "마산시6")
        val doAdapter = ArrayAdapter(requireContext(), item_dropdown, doItems)
        val siAdapter = ArrayAdapter(requireContext(), item_dropdown, siItems)
        binding.apply {
            doSpinner.adapter = doAdapter
            siSpinner.adapter = siAdapter
            date.text = getTodayDate()
            date.setOnClickListener {
                DialogForDatePicker.Builder(requireContext())
                    .setInitDate(parseStringToDate(it as TextView)!!)
                    .setOnClickPositiveButton { newDate ->
                        binding.date.text = newDate
                    }
                    .build().show()
            }
        }
    }

    override fun menuClick() {
        Toast.makeText(context, "클릭메뉴", Toast.LENGTH_SHORT).show()
    }

}