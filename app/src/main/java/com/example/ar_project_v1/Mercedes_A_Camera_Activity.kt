package com.example.ar_project_v1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.github.sceneview.ar.ArSceneView
import io.github.sceneview.ar.localRotation
import io.github.sceneview.ar.node.ArModelNode

class Mercedes_A_Camera_Activity : AppCompatActivity() {
    lateinit var sceneView: ArSceneView
    lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var modelNode: ArModelNode

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nissan_skyline_camera)

        sceneView = findViewById(R.id.sceneView)
        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        sceneView.requestFocus()

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_nissan -> loadModel("models/mercedes-benz_a45_amg_2018.glb")
            }
            true
        }

        modelNode = ArModelNode().apply {
            loadModelGlbAsync(glbFileLocation = "models/mercedes-benz_a45_amg_2018.glb") {
                sceneView.planeRenderer.isVisible = true
            }
        }
    }

    private fun loadModel(modelPath: String) {
        sceneView.removeChild(modelNode) // Önceki modeli kaldır
        modelNode = ArModelNode().apply {
            loadModelGlbAsync(glbFileLocation = modelPath) {
                sceneView.planeRenderer.isVisible = true
            }
        }
        placeModel() // Yeni modeli yerleştir
    }

    private fun placeModel() {
        sceneView.removeChild(modelNode) // Önceki modeli kaldır
        modelNode.anchor() // Modeli kameranın algıladığı yere yerleştir
        sceneView.addChild(modelNode) // Yeni modeli ekle
        modelNode.localRotation = modelNode.localRotation.copy(y = 0f) // Yatay eksende dönmeyi sıfırla
    }
}
