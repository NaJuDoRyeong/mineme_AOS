package com.najudoryeong.mineme.common_ui

import java.util.Calendar

class Util {
    companion object {
        private fun getTodayDate() : String = Calendar.getInstance().let {
            return it.getYear()
        }

        private fun Calendar.getYear() = get(Calendar.YEAR)
        private fun Calendar.getMonth() = get(Calendar.MONTH)
        private fun Calendar.getDay() = get(Calendar.DAY_OF_MONTH)


        fun getMonthAbbreviation(month: Int): String {
            return when (month) {
                Calendar.JANUARY -> "Jan"
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