package com.example.ar_project_v1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Bmw_i8_Activity : AppCompatActivity() {
    private lateinit var İ8Button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmw_i8)

        İ8Button = findViewById(R.id.i8Button)

        İ8Button.setOnClickListener {
            val intent = Intent(this, Bmw_i8_Camera_Activity::class.java)
            startActivity(intent)
        }
    }
}