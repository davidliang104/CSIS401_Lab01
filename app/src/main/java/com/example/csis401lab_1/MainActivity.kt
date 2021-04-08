/*
    CSIS-401 Lab-01
    by David Liang  (S00049751)
 */

package com.example.csis401lab_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var choice: Double? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun setSize(v: View) {
        // Choose the size of the photos
       choice = when (v) {
            option1 -> 0.19
            option2 -> 0.49
            option3 -> 0.79
            else -> 0.0
        }
    }

    fun displayPrice(v:View) {
        // Get number entered by user
        val num = numOfPrints.text.toString().toDoubleOrNull()
        // Check if either the input is invalid, or if no size was selected
        if (num == null) {
            textResult.text = ""
            Toast.makeText(this, "Enter a valid number", Toast.LENGTH_SHORT).show()
        } else if (choice == null) {
            textResult.text = ""
            Toast.makeText(this, "Select a photo size", Toast.LENGTH_SHORT).show()
        } else {
            val displayText = "The order cost is $ " + String.format("%.2f", num * choice!!)
            textResult.text = displayText
        }
    }
}