package com.example.ar_project_v1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Mercedes_A_Activity : AppCompatActivity() {
    private lateinit var MercedesButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mercedes_aactivity)

        MercedesButton = findViewById(R.id.mercedesButton)

        MercedesButton.setOnClickListener {
            val intent = Intent(this, Mercedes_A_Camera_Activity::class.java)
            startActivity(intent)
        }
    }
}