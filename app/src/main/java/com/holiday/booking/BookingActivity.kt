package com.holiday.booking

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.ArrayAdapter
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var destination: Spinner
    private lateinit var checkin:EditText
    private lateinit var checkout:EditText
    private lateinit var adult:EditText
    private lateinit var child: EditText
    private lateinit var book: Button
    private var inDate=0
    private var outDate = 0
    private var selectedItem = " "
    private val places= mapOf(
            "Select Your Destination" to 0,"Bali" to 5000 , "Malaysia" to 300, "Singapore" to 6000)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        destination=findViewById(R.id.destination)
        checkin=findViewById(R.id.checkin)
        checkout=findViewById(R.id.checkout)
        adult=findViewById(R.id.adult)
        child=findViewById(R.id.children)
        book=findViewById(R.id.book)

        checkin.setOnClickListener()
        {
            checkIn()
        }
        checkout.setOnClickListener()
        {
            checkOut()
        }

        val adapter= ArrayAdapter(this, android.R.layout.simple_list_item_1, places.keys.toTypedArray())
        destination.adapter = adapter

        destination.onItemSelectedListener = object : AdapterView.OnItemSelectedListener
        {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedItem=parent?.getItemAtPosition(position).toString()
                //Toast.makeText(applicationContext,"Select Destination: $selectedItem", Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        book.setOnClickListener{Intent (this,BillActivity::class.java).also {
            it.putExtra("total",places[selectedItem])
            it.putExtra("adult",adult.text.toString())
            it.putExtra("child",child.text.toString())
            it.putExtra("dateCalc",(outDate-inDate))
            startActivity(it)
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
                    inDate=dayOfMonth
                },
                year,
                month,
                day
        ).show()
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
            outDate=dayOfMonth
        },
        year,
        month,
        day).show()
    }
}


// android:background="#6276E1"