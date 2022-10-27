package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton : Button = findViewById(R.id.roll_btn)
        val countUpButton : Button = findViewById(R.id.countup_btn)

        rollButton.setOnClickListener {
            rollDice()
        }

        countUpButton.setOnClickListener {
            countUp()
        }

    }

    private fun rollDice() {
        val resultText : TextView = findViewById(R.id.result_tv)

        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()

        val randomInt = (1..6).random()
        resultText.text = randomInt.toString()
    }


    private fun countUp() {
        val resultText : TextView = findViewById(R.id.result_tv)

        Toast.makeText(this, "count up clicked", Toast.LENGTH_SHORT).show()

        // If text is the default "Hello World!" set that text to 1.
        if (resultText.text == "Hello World!") {
            resultText.text = "1"
        } else {
            // Otherwise, increment the number up to 6.
            // it needs to be converted to a String object before it can be converted to an int.
            var resultInt = resultText.text.toString().toInt()

            if (resultInt < 6) {
                resultInt++
                resultText.text = resultInt.toString()
            }
        }
    }
}