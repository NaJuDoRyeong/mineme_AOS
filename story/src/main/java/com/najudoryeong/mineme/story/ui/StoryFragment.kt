package com.najudoryeong.mineme.story.ui

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.najudoryeong.mineme.common_ui.BaseFragment
import com.najudoryeong.mineme.common_ui.CalendarUtil
import com.najudoryeong.mineme.common_ui.DialogForDateNoDay
import com.najudoryeong.mineme.story.CalendarAdapter
import com.najudoryeong.mineme.story.R
import com.najudoryeong.mineme.story.databinding.FragmentStoryBinding
import com.najudoryeong.mineme.story.StoryOutAdapter
import com.najudoryeong.mineme.story.domain.entity.CalendarData
import com.najudoryeong.mineme.story.domain.entity.CalendarItemData
import com.najudoryeong.mineme.story.util.StoryFoundationInfo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.*

@AndroidEntryPoint
class StoryFragment : BaseFragment<FragmentStoryBinding>(StoryFoundationInfo) {
    var dateList = getDatesInMonth(CalendarUtil.getTodayDate().substring(0,4).toInt(),CalendarUtil.getTodayDate().substring(5,6).toInt()) // 2023년 3월의 경우 month에 2를 전달해야 함.
    private val storyViewModel: StoryViewModel by viewModels()
    private val storyOutAdapter: StoryOutAdapter by lazy { StoryOutAdapter(this) }
    private var nowView: Int = 0

    override fun initView() {
        (activity as AppCompatActivity).run {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setHomeAsUpIndicator(R.drawable.img_story_menu)
        }


        binding.apply {

            this.lifecycleOwner = viewLifecycleOwner
            this.adapter = storyOutAdapter
            this.viewModel = storyViewModel

            this.swiperefreshlayout.setOnRefreshListener {
                storyViewModel.raedStory {
                    swiperefreshlayout.isRefreshing = false
                }
            }

            this.calendarDate.text = CalendarUtil.getTodayDateNoDay()
            this.calendarDate.setOnClickListener {
                DialogForDateNoDay.Builder(requireContext())
                    .setInitDate(CalendarUtil.parseStringToDateNoDay(it as TextView)!!)
                    .setOnClickPositiveButton {
                        newDate->
                        binding.calendarDate.text = newDate
                        dateList = getDatesInMonth(newDate.substring(0,4).toInt(), newDate.substring(5).toInt())
                        initCalendarView()
                    }.build().show()
            }
        }

        storyViewModel.raedStory()
        toastObserve()

    }

    private fun changeView() {

        val resource = if (nowView == 0) {
            nowView = 1
            initCalendarView()
            R.drawable.img_calender_menu
        } else {
            nowView = 0
            initStoryView()
            R.drawable.img_story_menu
        }

        (activity as AppCompatActivity).run {
            supportActionBar?.setHomeAsUpIndicator(resource)
        }

    }

    private fun initCalendarView() {
        binding.apply {
            calendarRecyclerView.visibility = View.VISIBLE
            calendarDate.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
            calendarRecyclerView.layoutManager = GridLayoutManager(context, 7)
            calendarRecyclerView.adapter = CalendarAdapter(dateList)
        }

    }


    private fun initStoryView() {
        binding.apply {
            calendarRecyclerView.visibility = View.GONE
            calendarDate.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        }

    }

    override fun backClick(): Boolean {
        changeView()
        return true
    }

    override fun menuClick() {
        findNavController().navigate(R.id.next)
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


    private fun getDatesInMonth(year: Int, month: Int): Array<CalendarData> {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.DAY_OF_MONTH, 1)


        val firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        val lastDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

        val firstArraySize = 49
        val dataList = Array(firstArraySize) { CalendarData("", null) }
        val arrayOfWeek = arrayOf("일", "월", "화", "수", "목", "금", "토")

        (0..6).forEach {
            dataList[it] = CalendarData(arrayOfWeek[it], null)
        }

        for (i in 1..lastDayOfMonth) {
            dataList[firstDayOfWeek + i + 5] = CalendarData(i.toString(), null)
        }

        val tmp = dummy.find { it.year.toInt() == year && it.month.toInt() == month }

        tmp?.posts?.forEach {
            val day = it.date.takeLast(2).toInt()
            dataList[firstDayOfWeek + day + 5] =
                CalendarData(day.toString(), CalendarItemData(it.postId, it.thumbnailImage))
        }

        return dataList
    }


}