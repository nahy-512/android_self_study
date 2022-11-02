package com.example.colormyview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var boxThreeText : TextView
    lateinit var boxFourText : TextView
    lateinit var boxFiveText : TextView

    lateinit var redButton : Button
    lateinit var yellowButton : Button
    lateinit var greenButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boxThreeText = findViewById(R.id.box_three_text)
        boxFourText = findViewById(R.id.box_four_text)
        boxFiveText = findViewById(R.id.box_five_text)

        redButton = findViewById(R.id.red_button)
        yellowButton = findViewById(R.id.yellow_button)
        greenButton = findViewById(R.id.green_button)

        setListeners()
    }

    private fun makeColored(view: View) {
        when (view.id) {
            // Boxes using Color class colors for the background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)
            R.id.box_three_text -> view.setBackgroundColor(Color.BLUE)
            R.id.box_four_text -> view.setBackgroundColor(Color.MAGENTA)
            R.id.box_five_text -> view.setBackgroundColor(Color.BLUE)

            // Boxes using custom colors for background
            R.id.red_button -> boxThreeText.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> boxFourText.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> boxFiveText.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY) // 사용자가 배경 클릭
        }
    }

    private fun setListeners() {

        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
//        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
//        val boxFourText = findViewById<TextView>(R.id.box_four_text)
//        val boxFiveText = findViewById<TextView>(R.id.box_five_text)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)

        //  add all the view instances to the list
        val clickableViews: List<View> = listOf(boxOneText, boxTwoText, boxThreeText, boxFourText, boxFiveText, rootConstraintLayout,
            redButton, greenButton, yellowButton)

        // set the listener for each view
        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }

    }
}