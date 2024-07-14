package com.example.assignment1

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var button: Button
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        window.statusBarColor = resources.getColor(android.R.color.black)

        spinner = findViewById(R.id.spinner)
        button = findViewById(R.id.button)
        progressBar = findViewById(R.id.progressBar)

        val items = arrayOf("Item 1", "Item 2", "Item 3", "Item 4")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                progressBar.visibility = View.VISIBLE
                Handler(Looper.getMainLooper()).postDelayed({
                    progressBar.visibility = View.GONE

                    val selectedItem = parent.getItemAtPosition(position).toString()
                    Toast.makeText(this@MainActivity, "$selectedItem selected", Toast.LENGTH_SHORT).show()
                }, 1000)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        button.setOnClickListener {
            val selectedItem = spinner.selectedItem.toString()
            Toast.makeText(this, "$selectedItem selected", Toast.LENGTH_SHORT).show()
        }
    }
}