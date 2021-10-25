package com.example.minutes_age

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        }

    fun clickDatePicker(view: android.view.View) {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDay ->

            val selectedDate = "$selectedDay/${selectedMonth+1}/$selectedYear"

            val textViewSelectedDate : TextView = findViewById(R.id.tvSelectedDate)
            textViewSelectedDate.text = selectedDate

            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

            val selectedDateInMinutes = (sdf.parse(selectedDate))!!.time / 60000//theDate!!.time / 60000
            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

            val currentDateInMinutes = currentDate!!.time / 60000
            val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes

            val textViewDifferenceInMinutes : TextView = findViewById(R.id.tvSelectedDateInMinutes)
            textViewDifferenceInMinutes.text = differenceInMinutes.toString()

        }, year, month, day)

        dpd.datePicker.setMaxDate(Date().time - 86400000)
        dpd.show()

    }

}
