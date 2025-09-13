/*
Descripción: Mostrar un mensaje al tocar la imagen
Autor: Esther Mariana Chunga Pacheco
Fecha creación: 12/09/2025
Fecha última modificación: 12/09/2025
*/

package com.example.practica3

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ImageClickActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_click)

        val img = findViewById<ImageView>(R.id.miImagen)
        img.setOnClickListener {
            Toast.makeText(this, "Clic en la imagen!", Toast.LENGTH_SHORT).show()
        }
    }
}
