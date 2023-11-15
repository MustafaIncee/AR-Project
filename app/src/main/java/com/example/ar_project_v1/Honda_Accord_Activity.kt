package com.example.ar_project_v1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Honda_Accord_Activity : AppCompatActivity() {
    private lateinit var accordButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_honda_accord)

        accordButton = findViewById(R.id.accordButton)

        accordButton.setOnClickListener {
            val intent = Intent(this, Honda_Accord_Camera_Activity::class.java)
            startActivity(intent)
            finish()
        }
    }
}