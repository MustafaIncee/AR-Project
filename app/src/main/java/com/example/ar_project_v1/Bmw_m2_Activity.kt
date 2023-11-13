package com.example.ar_project_v1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Bmw_m2_Activity : AppCompatActivity() {
    private lateinit var m2Button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmw_m2)

        m2Button = findViewById(R.id.m2Button)

        m2Button.setOnClickListener {
            val intent = Intent(this, Bmw_m2_Camera_Activity::class.java)
            startActivity(intent)
        }
    }
}