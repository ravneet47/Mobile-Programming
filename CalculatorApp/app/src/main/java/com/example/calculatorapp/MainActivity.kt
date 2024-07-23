package com.example.calculatorapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private var currentInput: String = ""
    private var operator: String = ""
    private var firstOperand: Double = 0.0
    private var secondOperand: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = intent.getStringExtra("USER_NAME")
        val age = intent.getIntExtra("USER_AGE", -1)

        Toast.makeText(this, "Name: $name, Age: $age", Toast.LENGTH_LONG).show()

        resultTextView = findViewById(R.id.resultTextView)
    }

    fun onDigit(view: View) {
        val button = view as Button
        currentInput += button.text
        resultTextView.text = currentInput
    }

    fun onOperator(view: View) {
        val button = view as Button
        operator = button.text.toString()
        firstOperand = currentInput.toDouble()
        currentInput = ""
    }

    fun onEqual(view: View) {
        secondOperand = currentInput.toDouble()
        val result = when (operator) {
            "+" -> firstOperand + secondOperand
            "-" -> firstOperand - secondOperand
            "*" -> firstOperand * secondOperand
            "/" -> firstOperand / secondOperand
            else -> 0.0
        }
        resultTextView.text = result.toString()
        currentInput = result.toString()
    }

    fun onClear(view: View) {
        currentInput = ""
        operator = ""
        firstOperand = 0.0
        secondOperand = 0.0
        resultTextView.text = "0"
    }
}