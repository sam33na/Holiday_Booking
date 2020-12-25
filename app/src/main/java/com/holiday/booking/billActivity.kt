package com.holiday.booking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class billActivity : AppCompatActivity() {

    private lateinit var adultDis: TextView
    private lateinit var childDis: TextView
    private lateinit var total: TextView
    private lateinit var totalDis: TextView
    private lateinit var grandT: TextView
    private lateinit var tax: TextView
    private lateinit var book: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bill)

        adultDis=findViewById(R.id.adultEdit)
        childDis=findViewById(R.id.childrenEdit)
        totalDis=findViewById(R.id.totalDisplay)
        total=findViewById(R.id.total)
        grandT=findViewById(R.id.grandTotal)
        tax=findViewById(R.id.tax)

        val intent=intent
        if(intent!=null)
        {
            val adult=intent.getStringExtra("adult")
            val child=intent.getStringExtra("child")
            adultDis.text="$adult"
            childDis.text="$child"
        }
        else
        {
            adultDis.text="No values received"
            childDis.text="No values received"
        }
    }
}