package com.example.quiz1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets}
        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        val buttonSub: Button = findViewById(R.id.buttonSub)
        val buttonMul: Button = findViewById(R.id.buttonMul)
        val buttonDiv: Button = findViewById(R.id.buttonDiv)
        val edtxt1: EditText = findViewById(R.id.editTextNumber1)
        val edtxt2: EditText = findViewById(R.id.editTextNumber2)
        val resultTV: TextView = findViewById(R.id.result)
        buttonAdd.setOnClickListener { view ->
            var x: Int = edtxt1.text.toString().toInt();
            var y: Int = edtxt2.text.toString().toInt();
            resultTV.text = sum(x,y).toString();}
        buttonSub.setOnClickListener { view ->
            var x: Int = edtxt1.text.toString().toInt();
            var y: Int = edtxt2.text.toString().toInt();
            resultTV.text = sub(x,y).toString();}
        buttonMul.setOnClickListener { view ->
            var x: Int = edtxt1.text.toString().toInt();
            var y: Int = edtxt2.text.toString().toInt();
            resultTV.text = mul(x,y).toString();}
        buttonDiv.setOnClickListener { view ->
            var x: Int = edtxt1.text.toString().toInt();
            var y: Int = edtxt2.text.toString().toInt();
            resultTV.text = div(x,y).toString();}
    }
}

public fun sum(a:Int, b:Int):Int{
    return a+b;
}
public fun sub(a:Int, b:Int):Int{
    return a-b;
}
public fun mul(a:Int, b:Int):Int{
    return a*b;
}
public fun div(a:Int, b:Int):Int{
    return a/b;
}