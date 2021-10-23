package com.example.minutes_age

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker = findViewById(R.id.btnDatePicker) as Button

        btnDatePicker.setOnClickListener {view ->
            clickDatePicker(view)
            //Toast.makeText(this, "Button works", Toast.LENGTH_LONG).show()
        }


    }

    fun clickDatePicker(view: View){

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, day ->
            Toast.makeText(this, "Date picker works", Toast.LENGTH_LONG).show()

        }, year, month, day).show()



    }
}