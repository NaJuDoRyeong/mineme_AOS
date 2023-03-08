package com.najudoryeong.mineme.story.ui

import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.najudoryeong.mineme.common_ui.BaseFragment
import com.najudoryeong.mineme.common_ui.CalendarUtil.Companion.getTodayDate
import com.najudoryeong.mineme.common_ui.CalendarUtil.Companion.parseStringToDate
import com.najudoryeong.mineme.common_ui.DialogForDatePicker
import com.najudoryeong.mineme.common_ui.R.layout.item_dropdown
import com.najudoryeong.mineme.story.ImageAdapter
import com.najudoryeong.mineme.story.databinding.FragmentWriteStoryBinding
import com.najudoryeong.mineme.story.util.WriteStoryFoundationInfo
import dagger.hilt.android.AndroidEntryPoint
import gun0912.tedimagepicker.builder.TedImagePicker
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


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


@AndroidEntryPoint
class WriteStoryFragment : BaseFragment<FragmentWriteStoryBinding>(WriteStoryFoundationInfo){

    private val storyViewModel: StoryViewModel by viewModels()
    override fun initView() {

        val doAdapter = ArrayAdapter(requireContext(), item_dropdown, doItems)
        val siAdapter = ArrayAdapter(requireContext(), item_dropdown, siItems)
        binding.apply {
            viewModel = storyViewModel
            adapter = ImageAdapter()
            lifecycleOwner = viewLifecycleOwner
            doSpinner.adapter = doAdapter
            siSpinner.adapter = siAdapter
            date.text = getTodayDate()
            date.setOnClickListener {
                DialogForDatePicker.Builder(requireContext())
                    .setInitDate(parseStringToDate(it as TextView)!!)
                    .setOnClickPositiveButton { newDate ->
                        binding.date.text = newDate }
                    .build().show()
            }
            picture.setOnClickListener {
                TedImagePicker.with(requireContext())
                    .errorListener { storyViewModel.setToastMessage("권한 실패") }
                    .startMultiImage {  storyViewModel.setImage(it) }
            }
            pictureViewPager.setOnClickListener {
                menuClick()
            }
        }
        toastObserve()
    }

    override fun menuClick() {
        Toast.makeText(context, "클릭메뉴", Toast.LENGTH_SHORT).show()
    }

    private fun toastObserve() {
        lifecycleScope.launch {
            storyViewModel.toastMessage.collectLatest {
                if (it.isNotEmpty()) {
                    Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}