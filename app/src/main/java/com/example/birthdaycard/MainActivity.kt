package com.example.birthdaycard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import java.time.LocalDate
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val submitBtn: Button = findViewById(R.id.submit_details)
        val nameCheck: EditText = findViewById(R.id.persons_name)
        val setMaxDate: DatePicker = findViewById(R.id.birthday)
        val today = Calendar.getInstance()
        setMaxDate.maxDate = today.timeInMillis

        submitBtn.setOnClickListener {
            //Check if a name was entered
            if (nameCheck.text.toString() == "") {

                // Display message to user if name is not entered
                val msg = "Please enter a name"
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            } else {

                callActivity()
            }
        }
    }

    private fun callActivity() {

        val userDb: DatePicker = findViewById(R.id.birthday) // Capture calendar input from user
        val age = calculateAge(userDb).toString() //Call function to calculate age
        val nameEntered: EditText = findViewById(R.id.persons_name) //Capture name entered by user
        val message = nameEntered.text.toString()

        // Create message to pass to second activity and pass in age
        val messageAge = "You Are $age Years Old"
        val messageMonth = userDb.month.toString()
        val messageYear = userDb.year.toString()


        //Creating the instance of the bundle
        val bundle = Bundle()
        //Storing the string value in the bundle
        bundle.putString("Name_Message", message)
        bundle.putString("Age_Message", messageAge)
        bundle.putString("Month_Message", messageMonth)
        bundle.putString("Year_Message", messageYear)

        //Creating a intent
        val intent = Intent(this, SecondActivity::class.java)
        // passing a bundle to the intent
        intent.putExtras(bundle)

        // Starting the activity by passing the intent to it
        startActivity(intent)
    }

    // Function to calculate Age
    private fun calculateAge(userDb: DatePicker): Int {

        var age = 0 // Local variable to store calculated age

        //val userDb: DatePicker = findViewById(R.id.birthday)

        // Capture Year, day and mth for age calculation from user input
        val year = userDb.year
        val day = userDb.dayOfMonth.toString()
        val mth = userDb.month.toString()
        val currentYr = LocalDate.now().year // Capture current year from Android

        // If statement is use to check if users day and month of birth has passed for current year.
        age =
            if (mth <= LocalDate.now().month.toString() && day <= LocalDate.now().dayOfMonth.toString()) {
                currentYr - year - 1

            } else {
                currentYr - year
            }
        return age
    }
}


