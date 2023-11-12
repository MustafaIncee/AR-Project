package com.example.ar_project_v1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class NissanSkylineActivity : AppCompatActivity() {

    private lateinit var nissanButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nissan_skyline)


        nissanButton = findViewById(R.id.nissanButton)

        nissanButton.setOnClickListener {
            val intent = Intent(this, NissanSkylineCameraActivity::class.java)
            startActivity(intent)
        }
    }
}