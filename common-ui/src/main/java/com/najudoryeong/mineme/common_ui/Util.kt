package com.najudoryeong.mineme.common_ui

import android.widget.DatePicker
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class CalendarUtil {
    companion object {
        private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.KOREA)

        fun getTodayDate(): String = Calendar.getInstance().let {
            return "${it.getYear()}-${it.getMonth()}-${it.getDay()}"
        }

        // private fun getDateFormat(year : String, month: String, day: String) : String = "${year} ${getMonthFormat(month)}"

        private fun Calendar.getYear() = get(Calendar.YEAR)
        private fun Calendar.getMonth() = get(Calendar.MONTH)+1
        private fun Calendar.getDay() = get(Calendar.DAY_OF_MONTH)

        fun DatePicker.getDate() = "$year-${month+1}-$dayOfMonth"

        fun parseStringToDate(textView: TextView): Date? =
            dateFormat.parse(textView.text.toString())

        fun getMonthFormat(month: String): String {
            return when (month.toInt()) {
                Calendar.FEBRUARY -> "Feb"
                Calendar.MARCH -> "Mar"
                Calendar.APRIL -> "Apr"
                Calendar.MAY -> "May"
                Calendar.JUNE -> "Jun"
                Calendar.JULY -> "Jul"
                Calendar.AUGUST -> "Aug"
                Calendar.SEPTEMBER -> "Sep"
                Calendar.OCTOBER -> "Oct"
                Calendar.NOVEMBER -> "Nov"
                Calendar.DECEMBER -> "Dec"
                else -> throw IllegalArgumentException("Invalid month: $month")
            }
        }


    }


}