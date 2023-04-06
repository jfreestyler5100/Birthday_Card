package com.example.birthdaycard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Call function on activity launch to
        displayAll()

        // Capture button object from second activity
        val backBtn: Button = findViewById(R.id.go_back)

        // Listen for button click to perform task to move to activity_main
        backBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }


    private fun displayAll(){
        // Get bundle back from Android
        val message = intent.extras

        // Check if null
        var name:String? = null
        var age:String? = null
        var mnth:String? = null
        var yr:String? = null

        // getting the string back
        name = message!!.getString("Name_Message", "Name Required")
        age = message.getString("Age_Message", "Age Required")
        mnth = message.getString("Month_Message", "0")
        yr = message.getString("Year_Message", "0")
        val displayPerson : TextView = findViewById(R.id.name_display)
        displayPerson.text = name // Display name entered by user to textview on secondActivity
        val displayAge: TextView = findViewById(R.id.age_display)
        displayAge.text = age // Display calculated age on secondActivity
        stoneDisplay(mnth.toInt()) // Call function to display stop and pass in month value
        zodiacDisplay(yr.toInt()) // Call function to display zodiac sing and pass in yr value

    }

    //Function to select and display zodiac image based on the year passed in
    private fun zodiacDisplay(zodiac: Int) {
        val displayZod: ImageView = findViewById(R.id.zodiac_display)

        // When statement to display the image appropriate to the year
        when (zodiac){
            1912,1924,1936,1948,1960,1972,1984,1996,2008,2020,2032 -> displayZod.setImageResource(R.drawable.rat)
            1913,1925,1937,1949,1961,1973,1985,1997,2009,2021,2033 -> displayZod.setImageResource(R.drawable.ox)
            1914,1926,1938,1950,1962,1974,1986,1998,2010,2022,2034 -> displayZod.setImageResource(R.drawable.tiger)
            1915,1927,1939,1951,1963,1975,1987,1999,2011,2023,2035 -> displayZod.setImageResource(R.drawable.rabbit)
            1916,1928,1940,1952,1964,1976,1988,2000,2012,2024,2036 -> displayZod.setImageResource(R.drawable.dragon)
            1917,1929,1941,1953,1965,1977,1989,2001,2013,2025,2037 -> displayZod.setImageResource(R.drawable.snake)
            1918,1930,1942,1954,1966,1978,1990,2002,2014,2026,2038 -> displayZod.setImageResource(R.drawable.horse)
            1919,1931,1943,1955,1967,1979,1991,2003,2015,2027,2039 -> displayZod.setImageResource(R.drawable.goat)
            1920,1932,1944,1956,1968,1980,1992,2004,2016,2028,2040 -> displayZod.setImageResource(R.drawable.monkey)
            1921,1933,1945,1957,1969,1981,1993,2005,2017,2029,2041 -> displayZod.setImageResource(R.drawable.rooster)
            1922,1934,1946,1958,1970,1982,1994,2006,2018,2030,2042 -> displayZod.setImageResource(R.drawable.dog)
            1923,1935,1947,1959,1971,1983,1995,2007,2019,2031,2043 -> displayZod.setImageResource(R.drawable.pig)
        }
    }

    // Function to display stone image that corresponds to the month
    private fun stoneDisplay(stone: Int){
        val displayStone: ImageView = findViewById(R.id.stone_display)

        // When statement used to select the image that relates to the month
        when (stone+1){
            1 -> displayStone.setImageResource(R.drawable.january)
            2 -> displayStone.setImageResource(R.drawable.february)
            3 -> displayStone.setImageResource(R.drawable.march)
            4 -> displayStone.setImageResource(R.drawable.april)
            5 -> displayStone.setImageResource(R.drawable.may)
            6 -> displayStone.setImageResource(R.drawable.june)
            7 -> displayStone.setImageResource(R.drawable.july)
            8 -> displayStone.setImageResource(R.drawable.august)
            9 -> displayStone.setImageResource(R.drawable.september)
            10 -> displayStone.setImageResource(R.drawable.october)
            11 -> displayStone.setImageResource(R.drawable.november)
            12 -> displayStone.setImageResource(R.drawable.december)
        }
    }
}