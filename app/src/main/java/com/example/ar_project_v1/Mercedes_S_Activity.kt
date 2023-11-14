package com.example.ar_project_v1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Mercedes_S_Activity : AppCompatActivity() {

    private lateinit var Mercedes_S_Button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mercedes_sactivity)

        Mercedes_S_Button = findViewById(R.id.mercedes_S_Button)

        Mercedes_S_Button.setOnClickListener {
            val intent = Intent(this, Mercedes_S_Camera_Activity::class.java)
            startActivity(intent)
        }
    }
}