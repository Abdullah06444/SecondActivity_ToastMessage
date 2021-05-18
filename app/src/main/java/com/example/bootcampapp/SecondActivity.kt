package com.example.bootcampapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    lateinit var textView : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_actibity)
        textView = findViewById(R.id.textView2)

        val getData = intent.getStringExtra("send")
        textView.setText(getData)
    }
}