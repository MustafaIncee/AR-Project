package com.example.ar_project_v1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Honda_Civic_Activity : AppCompatActivity() {

    private lateinit var civicButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_honda_civic)

        civicButton = findViewById(R.id.civicButton)

            civicButton.setOnClickListener {
            val intent = Intent(this, Honda_Civic_Camera_Activity::class.java)
            startActivity(intent)
            finish()
        }
    }
}