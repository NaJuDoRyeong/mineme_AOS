package com.najudoryeong.mineme.story

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.najudoryeong.mineme.story.databinding.ItemCalendarBinding
import com.najudoryeong.mineme.story.domain.entity.CalendarData

class CalendarAdapter(private val dataList: Array<CalendarData>) :
    RecyclerView.Adapter<CalendarAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCalendarBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        Log.d("datasize", dataList.size.toString())
        return dataList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item)
    }

    inner class ViewHolder(private val binding: ItemCalendarBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(calendarData: CalendarData) {

            if (calendarData.day.toIntOrNull() == null) {
                // 날짜가 아니라면
                binding.image.visibility = View.GONE
            } else {
                // 날짜 표시 가능한 부분이라면
                binding.date.setTextColor(Color.parseColor("#FFFFFF"))
                if (calendarData.data != null) {
                    binding.imgUrl = calendarData.data.imageUrl
                }
            }
            binding.date.text = calendarData.day
        }
    }

}