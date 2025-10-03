/*
Descripción: OpcionesActivity - muestra la nota y permite compartir por correo o editar de nuevo
Autor: Esther Mariana Chunga Pacheco
Fecha creación: 12/09/2025
Fecha última modificación: 12/09/2025
*/

package com.example.practica4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OpcionesActivity : AppCompatActivity() {

    private lateinit var tvNota: TextView
    private lateinit var btnCorreo: Button
    private lateinit var btnEditar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones)

        tvNota = findViewById(R.id.tvNota)
        btnCorreo = findViewById(R.id.btnCorreo)
        btnEditar = findViewById(R.id.btnEditar)

        val nota = intent.getStringExtra(EditorActivity.EXTRA_NOTA) ?: ""
        tvNota.text = nota

        btnCorreo.setOnClickListener {
            Toast.makeText(this, "Compartido por correo", Toast.LENGTH_SHORT).show()
            // Retornar resultado sin editar
            val data = Intent()
            data.putExtra("EDITAR", false)
            data.putExtra(EditorActivity.EXTRA_NOTA, nota)
            setResult(Activity.RESULT_OK, data)
            finish()
        }

        btnEditar.setOnClickListener {
            // Retornar indicando que se desea editar y devolver el texto
            val data = Intent()
            data.putExtra("EDITAR", true)
            data.putExtra(EditorActivity.EXTRA_NOTA, nota)
            setResult(Activity.RESULT_OK, data)
            finish()
        }
    }
}