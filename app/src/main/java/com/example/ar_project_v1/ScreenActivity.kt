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
    private lateinit var bilgiButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen)

        spinnerMarka = findViewById(R.id.marka)
        spinnerModel = findViewById(R.id.model)
        goruntuleButton = findViewById(R.id.goruntule)
        bilgiButton = findViewById(R.id.bilgi)

        initializeMarkaModelMap()
        setupMarkaSpinner()

        goruntuleButton.setOnClickListener {
            val intent = Intent(this@ScreenActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initializeMarkaModelMap() {
        markaModelMap = mutableMapOf()

        val toyotaModels = mutableListOf("Corolla", "Yaris", "RAV4")
        val volkswagenModels = mutableListOf("Golf", "Passat", "Tiguan")
        val daciaModels = mutableListOf("Sandero", "Duster", "Logan")
        val opelModels = mutableListOf("Corsa", "Astra", "Crossland")

        markaModelMap["Toyota"] = toyotaModels
        markaModelMap["Volkswagen"] = volkswagenModels
        markaModelMap["Dacia"] = daciaModels
        markaModelMap["Opel"] = opelModels
    }

    private fun setupMarkaSpinner() {
        val markaAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ArrayList(markaModelMap.keys))
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
        val modelAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, markaModelMap.getValue(marka))
        modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerModel.adapter = modelAdapter
    }
}