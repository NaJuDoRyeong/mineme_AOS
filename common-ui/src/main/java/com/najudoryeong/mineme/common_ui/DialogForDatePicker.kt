package com.najudoryeong.mineme.common_ui

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import com.najudoryeong.mineme.common_ui.CalendarUtil.Companion.getDate
import com.najudoryeong.mineme.common_ui.databinding.DialogForDatepickerBinding
import java.util.*

class DialogForDatePicker(
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
            datePicker.init(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH),null)
            positiveButton.setOnClickListener {
                onClickPositiveButton.invoke(datePicker.getDate())
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