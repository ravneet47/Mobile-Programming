package com.example.callerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val ageEditText = findViewById<EditText>(R.id.ageEditText)
        val launchApp1Button = findViewById<Button>(R.id.launchApp1Button)
        val launchApp2Button = findViewById<Button>(R.id.launchApp2Button)

        launchApp1Button.setOnClickListener {
            val name = nameEditText.text.toString()
            val age = ageEditText.text.toString().toIntOrNull()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.type = "text/plain"
            intent.putExtra("USER_NAME", name)
            intent.putExtra("USER_AGE", age)
            intent.setClassName("com.example.calculatorapp", "com.example.calculatorapp.MainActivity")
            startActivity(intent)
        }

        launchApp2Button.setOnClickListener {
            val name = nameEditText.text.toString()
            val age = ageEditText.text.toString().toIntOrNull()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.type = "text/plain"
            intent.putExtra("USER_NAME", name)
            intent.putExtra("USER_AGE", age)
            intent.setClassName("com.example.spinnerapp", "com.example.spinnerapp.MainActivity")
            startActivity(intent)
        }
    }
}