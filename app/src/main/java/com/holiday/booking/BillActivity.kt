package com.holiday.booking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class BillActivity : AppCompatActivity() {

    private lateinit var adultDis: TextView
    private lateinit var childDis: TextView
    private lateinit var totalDis: TextView
    private lateinit var grandT: TextView
    private lateinit var taxCalc: TextView
    private lateinit var book: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bill)

        adultDis=findViewById(R.id.adultEdit)
        childDis=findViewById(R.id.childrenEdit)
        totalDis=findViewById(R.id.totalDisplay)
        grandT=findViewById(R.id.grandTotal)
        taxCalc=findViewById(R.id.tax)

        val intent=intent
        if(intent!=null)
        {
            val adult=intent.getStringExtra("adult")!!.toInt()
            val child=intent.getStringExtra("child")!!.toInt()
            val totalDays = intent.getIntExtra("dateCalc", 0)
            val expenditure = intent.getIntExtra("total", 0)

            val adultAmount = adultCalc(adult, totalDays, expenditure)
            val childrenAmount = childrenCalc(child, totalDays, expenditure)

            val tax = (  (adultAmount + childrenAmount) * 0.13)

            val total = (adultAmount + childrenAmount + tax)

            adultDis.text = adultAmount.toString()
            childDis.text = childrenAmount.toString()
            totalDis.text = (adultAmount + childrenAmount).toString()
            taxCalc.text = tax.toString()
            grandT.text = total.toString()
        }
        else
        {
            adultDis.text="No values received"
            childDis.text="No values received"
        }
    }
    private fun adultCalc(adult: Int, days: Int, amt: Int): Float {
        return (adult * days * amt).toFloat()
    }

    private fun childrenCalc(child: Int, days: Int, amt: Int): Float {
        return (child * days * amt / 2).toFloat()
    }
}

