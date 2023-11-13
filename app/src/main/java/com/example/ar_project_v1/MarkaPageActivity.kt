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
    private lateinit var BMWSpinner: Spinner
    private lateinit var PorscheSpinner: Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marka_page)

        mercedesSpinner = findViewById(R.id.spinnerMercedes)
        toyotaSpinner = findViewById(R.id.spinnerToyota)
        BMWSpinner = findViewById(R.id.spinnerBMW)
        PorscheSpinner = findViewById(R.id.spinnerPorsche)



        //MERCEDES SPINNER
        val itemsMercedes = arrayOf("MERCEDES", "A45 AMG", "C200", "S600 Maybach")
        // ArrayAdapter oluşturma ve öğeleri Spinner'a bağlama

        // ArrayAdapter oluşturma ve öğeleri Spinner'a bağlama
        val adapterMercedes =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, itemsMercedes)
        adapterMercedes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mercedesSpinner.setAdapter(adapterMercedes)

        //**************************************************************************************************************************

        //TOYOTA SPINNER
        val itemsToyota = arrayOf("TOYOTA", "Corolla", "Yaris", "RAV4")

        // ArrayAdapter oluşturma ve öğeleri Spinner'a bağlama
        val adapterToyota = ArrayAdapter(this, android.R.layout.simple_spinner_item, itemsToyota)
        adapterToyota.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        toyotaSpinner.setAdapter(adapterToyota)

        //**************************************************************************************************************************

        //BMW SPINNER
        val itemsBWM = arrayOf("BMW", "BMW I8", "BMW M2")

        // ArrayAdapter oluşturma ve öğeleri Spinner'a bağlama
        val adapterBMW = ArrayAdapter(this, android.R.layout.simple_spinner_item, itemsBWM)
        adapterBMW.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        BMWSpinner.setAdapter(adapterBMW)

        //**************************************************************************************************************************

        //Porsche SPINNER
        val itemsPorsche = arrayOf("PORSCHE", "911", "Cayenne", "Panamera")

        // ArrayAdapter oluşturma ve öğeleri Spinner'a bağlama
        val adapterPorsche = ArrayAdapter(this, android.R.layout.simple_spinner_item, itemsPorsche)
        adapterPorsche.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        PorscheSpinner.setAdapter(adapterPorsche)


        mercedesSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                // Seçilen öğe değiştikçe buraya kod ekleyebilirsiniz.
                val selectedValue = itemsMercedes[position]
                if (selectedValue.equals("A45 AMG")){
                    Toast.makeText(applicationContext, "Seçilen öğe: $selectedValue", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@MarkaPageActivity, Mercedes_A_Activity::class.java))
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }
        BMWSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                // Seçilen öğe değiştikçe buraya kod ekleyebilirsiniz.
                val selectedValue = itemsBWM[position]

                if (selectedValue.equals("BMW I8")){
                    Toast.makeText(applicationContext, "Seçilen öğe: $selectedValue", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@MarkaPageActivity, Bmw_i8_Activity::class.java))
                }
                else if (selectedValue.equals("BMW M2")){
                    Toast.makeText(applicationContext, "Seçilen öğe: $selectedValue", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@MarkaPageActivity, Bmw_m2_Activity::class.java))
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }


    }
}