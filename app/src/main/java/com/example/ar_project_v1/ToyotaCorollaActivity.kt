package com.example.ar_project_v1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ToyotaCorollaActivity : AppCompatActivity() {
    private lateinit var corolla: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toyota_corolla)

        corolla= findViewById(R.id.tcrllButton)

        corolla.setOnClickListener {
            val intent = Intent(this, Toyota_Corolla_Camera_Activity::class.java)
            startActivity(intent)
            finish()
        }
    }
}