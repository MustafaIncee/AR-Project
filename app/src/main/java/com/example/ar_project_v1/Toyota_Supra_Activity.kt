package com.example.ar_project_v1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Toyota_Supra_Activity : AppCompatActivity() {
    private lateinit var supra: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toyota_supra)

        supra= findViewById(R.id.suprAButton)

        supra.setOnClickListener {
            val intent = Intent(this, Toyota_Supra_Camera_Activity::class.java)
            startActivity(intent)
            finish()
        }
    }
}