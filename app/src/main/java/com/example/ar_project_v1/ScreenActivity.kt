package com.example.ar_project_v1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class ScreenActivity : AppCompatActivity() {
    private lateinit var markaModelMap: MutableMap<String, MutableList<String>>
    private lateinit var spinnerMarka: Spinner
    private lateinit var spinnerModel: Spinner
    private lateinit var goruntuleButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen)

        spinnerMarka = findViewById(R.id.marka)
        spinnerModel = findViewById(R.id.model)
        goruntuleButton = findViewById(R.id.goruntule)

        initializeMarkaModelMap()
        setupMarkaSpinner()

        goruntuleButton.setOnClickListener {
            val selectedMarka = spinnerMarka.selectedItem as String
            val selectedModel = spinnerModel.selectedItem as String

            val activityName = "com.example.ar_project_v1.${selectedMarka}${selectedModel}Activity"

            try {
                val activityClass = Class.forName(activityName)
                val intent = Intent(this@ScreenActivity, activityClass)
                startActivity(intent)
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
                // Eğer aktivite bulunamazsa veya oluşturulamazsa buraya düşer
            }
        }
    }

    private fun initializeMarkaModelMap() {
        markaModelMap = mutableMapOf()

        val toyotaModels = mutableListOf("Corolla", "Supra")
        val volkswagenModels = mutableListOf("Polo", "Amarok")
        val nissanModels = mutableListOf("Skyline")
        val porscheModels = mutableListOf("911")



        markaModelMap["Toyota"] = toyotaModels
        markaModelMap["Volkswagen"] = volkswagenModels
        markaModelMap["Nissan"] = nissanModels
        markaModelMap["Porsche"] = porscheModels


    }

    private fun setupMarkaSpinner() {
        val markaAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, ArrayList(markaModelMap.keys))
        markaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerMarka.adapter = markaAdapter

        spinnerMarka.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedMarka = markaAdapter.getItem(position) as String
                setupModelSpinner(selectedMarka)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun setupModelSpinner(marka: String) {
        val modelAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, markaModelMap.getValue(marka))
        modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerModel.adapter = modelAdapter
    }
}