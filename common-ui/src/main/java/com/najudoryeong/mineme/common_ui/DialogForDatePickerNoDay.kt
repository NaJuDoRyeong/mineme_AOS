package com.najudoryeong.mineme.common_ui

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.NumberPicker
import com.najudoryeong.mineme.common_ui.CalendarUtil.Companion.getDateNoDay
import com.najudoryeong.mineme.common_ui.databinding.DialogForDatepickerBinding
import java.util.*

class DialogForDatePickerNoDay(
    context: Context,
    private val initDate: Date,
    private val onClickPositiveButton: (String) -> Unit
) : Dialog(context) {
    private lateinit var binding: DialogForDatepickerBinding
    private var calendar: Calendar = Calendar.getInstance()

    init {
        calendar.time = initDate
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DialogForDatepickerBinding.inflate(layoutInflater).apply {
            datePicker.init(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),1,null)

            val daySpinnerId = Resources.getSystem().getIdentifier("day", "id", "android")
            val daySpinner = datePicker.findViewById<NumberPicker>(daySpinnerId)
            daySpinner.visibility = View.GONE
            positiveButton.setOnClickListener {
                onClickPositiveButton.invoke(datePicker.getDateNoDay())
                dismiss()
            }
            negativeButton.setOnClickListener {
                dismiss()
            }
        }
        setContentView(binding.root)

        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    class Builder(private val context: Context) {
        private lateinit var initDate: Date
        private var onClickPositiveButton : (String) -> Unit = {}


        fun setInitDate(initDate: Date) = apply {
            this.initDate = initDate
        }

        fun setOnClickPositiveButton(onClickPositiveButton: (String) -> Unit) = apply {
            this.onClickPositiveButton = onClickPositiveButton
        }


        fun build() = DialogForDatePicker(
            context,
            initDate,
            onClickPositiveButton
        )
    }
}