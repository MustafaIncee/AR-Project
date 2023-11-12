package com.example.ar_project_v1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MarkaPageActivity : AppCompatActivity() {

    private lateinit var mercedesSpinner: Spinner
    private lateinit var toyotaSpinner: Spinner
    private lateinit var mercedesImageButton: ImageButton
    private lateinit var toyotaImageButton: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marka_page)

        mercedesSpinner = findViewById(R.id.spinnerMercedes)
        toyotaSpinner = findViewById(R.id.spinnerToyota)
        mercedesImageButton = findViewById(R.id.MercedesImageButton)
        toyotaImageButton = findViewById(R.id.ToyotaImageButton)


        //MERCEDES SPINNER
        val itemsMercedes = arrayOf("...", "A Serisi", "C Serisi", "E Serisi")
        // ArrayAdapter oluşturma ve öğeleri Spinner'a bağlama

        // ArrayAdapter oluşturma ve öğeleri Spinner'a bağlama
        val adapterMercedes =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, itemsMercedes)
        adapterMercedes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mercedesSpinner.setAdapter(adapterMercedes)

        //**************************************************************************************************************************

        //TOYOTA SPINNER
        val itemsToyota = arrayOf("...", "Corolla", "Yaris", "RAV4")

        // ArrayAdapter oluşturma ve öğeleri Spinner'a bağlama
        val adapterToyota = ArrayAdapter(this, android.R.layout.simple_spinner_item, itemsToyota)
        adapterToyota.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        toyotaSpinner.setAdapter(adapterToyota)


        mercedesSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                // Seçilen öğe değiştikçe buraya kod ekleyebilirsiniz.
                val selectedValue = itemsMercedes[position]
                if (selectedValue.equals("A Serisi")){
                    Toast.makeText(applicationContext, "Seçilen öğe: $selectedValue", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@MarkaPageActivity, ToyotaCorollaActivity::class.java))
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }


    }
}