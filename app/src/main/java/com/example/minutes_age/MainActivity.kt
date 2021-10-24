package com.example.minutes_age

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
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
            Toast.makeText(this, "Chosen month is " + selectedMonth, Toast.LENGTH_SHORT).show()

            //findViewById(R.id.tvSelectedDate).text : String = "hello" //"$selectedDay/${selectedMonth+1}/$selectedYear"
            val selectedDate = "$selectedDay/${selectedMonth+1}/$selectedYear"
            //val currentDate = "$day/${month+1}/$year"
            //val currentDate = Date()
            val textViewSelectedDate : TextView = findViewById(R.id.tvSelectedDate)
            textViewSelectedDate.text = selectedDate

            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val theDate = sdf.parse(selectedDate)
            val selectedDateInMinutes = theDate!!.time / 60000
            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateInMinutes = currentDate!!.time / 60000
            val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes

            Toast.makeText(this, "Difference is " + differenceInMinutes, Toast.LENGTH_LONG).show()

            val textViewDifferenceInMinutes : TextView = findViewById(R.id.tvSelectedDateInMinutes)
            textViewDifferenceInMinutes.text = differenceInMinutes.toString()
           // textViewSelectedDate.text = selectedDate
            //val oldDate = sdf.parse(currentDate)
            //val diffDate =

            //val sdfNew = SimpleDateFormat (day, month, year)
            //val currentDate = sdfNew.parse(day, month, year)

        }, year, month, day)

        dpd.datePicker.setMaxDate(Date().time - 86400000)
        dpd.show()

    }

}
