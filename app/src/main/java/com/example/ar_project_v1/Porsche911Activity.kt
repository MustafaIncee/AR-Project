package com.example.ar_project_v1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Porsche911Activity : AppCompatActivity() {

    private lateinit var porscheButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_porsche911)

        porscheButton = findViewById(R.id.porscheButton)

        porscheButton.setOnClickListener {
            val intent = Intent(this, Porsche911CameraActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
