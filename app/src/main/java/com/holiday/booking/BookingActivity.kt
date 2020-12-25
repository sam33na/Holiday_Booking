package com.holiday.booking

import android.app.DatePickerDialog
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var destination: Spinner
    private lateinit var checkin:EditText
    private lateinit var checkout:EditText
    private lateinit var adult:EditText
    private lateinit var child: EditText
    private lateinit var book: Button
    private var date:String=" "
    private val places= arrayOf("Bali(5000 per day)", "Malaysia(300 per day)", "Singapore(6000 per day)")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        destination=findViewById(R.id.destination)
        checkin=findViewById(R.id.checkin)
        checkout=findViewById(R.id.checkout)
        adult=findViewById(R.id.adult)
        child=findViewById(R.id.child)
        book=findViewById(R.id.book)

        spinner()
        checkin.setOnClickListener()
        {
            checkIn()
        }
        checkout.setOnClickListener()
        {
            checkOut()
        }
    }
    private fun spinner()
    {
        val adapter=ArrayAdapter(this, android.R.layout.simple_list_item_1,places)
        destination.adapter=adapter
        destination.onItemSelectedListener=object :AdapterView.OnItemSelectedListener
        {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem=parent?.getItemAtPosition(position).toString()
                Toast.makeText(applicationContext,"Select Destination: $selectedItem", Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }
    private fun checkIn()
    {
        val c=Calendar.getInstance()
        val year=c.get(Calendar.YEAR)
        val month=c.get(Calendar.MONTH)
        val day=c.get(Calendar.DAY_OF_MONTH)
        var format:String
        val datePickerDialog=DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener{
                    view,Year,Month,dayOfMonth->
                    checkin.setText("Check-In: $Year/${Month+ 1}/$dayOfMonth")
                },
                year,
                month,
                day
        )
        datePickerDialog.show()
    }
    private fun checkOut()
    {
        val c= Calendar.getInstance()
        val year=c.get(Calendar.YEAR)
        val month=c.get(Calendar.MONTH)
        val day=c.get(Calendar.DAY_OF_MONTH)
        var format:String
        val datePickerDialog=DatePickerDialog(this, DatePickerDialog.OnDateSetListener
        { view, Year, Month, dayOfMonth ->
            checkout.setText("Check-out:$Year/${Month+1}/$dayOfMonth")
        },
        year,
        month,
        day)
        datePickerDialog.show()
    }
}


// android:background="#6276E1"