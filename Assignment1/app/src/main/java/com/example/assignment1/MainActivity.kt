package com.example.assignment1

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var button: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        window.statusBarColor = resources.getColor(android.R.color.black)

        spinner = findViewById(R.id.spinner)
        button = findViewById(R.id.button)
        progressBar = findViewById(R.id.progressBar)
        imageView = findViewById(R.id.imageView)

        val items = arrayOf("Select Item", "T-Shirt", "Jeans", "Jacket")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                if (position > 0) {
                    progressBar.visibility = View.VISIBLE
                    Handler(Looper.getMainLooper()).postDelayed({
                        progressBar.visibility = View.GONE
                        imageView.visibility = View.VISIBLE

                        // Update the imageView based on the selected item
                        when (position) {
                            1 -> imageView.setImageResource(R.drawable.tshirt)
                            2 -> imageView.setImageResource(R.drawable.jeans)
                            3 -> imageView.setImageResource(R.drawable.jacket)
                        }

                        val selectedItem = parent.getItemAtPosition(position).toString()
                        Toast.makeText(this@MainActivity, "$selectedItem selected", Toast.LENGTH_SHORT).show()
                    }, 1000)
                } else {
                    imageView.visibility = View.GONE
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        button.setOnClickListener {
            val selectedItem = spinner.selectedItem.toString()
            if (spinner.selectedItemPosition > 0) {
                Toast.makeText(this, "$selectedItem selected", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please select an item", Toast.LENGTH_SHORT).show()
            }
        }
    }
}