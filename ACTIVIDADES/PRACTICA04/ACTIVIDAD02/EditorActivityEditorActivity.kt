/*
Descripción: EditorActivity - permite escribir una nota y enviarla a OpcionesActivity
Autor: Esther Mariana Chunga Pacheco
Fecha creación: 12/09/2025
Fecha última modificación: 12/09/2025
*/

package com.example.practica4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class EditorActivity : AppCompatActivity() {

    private lateinit var etNota: EditText
    private lateinit var btnCompartir: Button

    companion object {
        const val EXTRA_NOTA = "EXTRA_NOTA"
        const val STATE_NOTA = "state_nota"
    }

    private val opcionesLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK && result.data != null) {
                val volverAEditar = result.data!!.getBooleanExtra("EDITAR", false)
                val texto = result.data!!.getStringExtra(EXTRA_NOTA)
                if (volverAEditar && texto != null) {
                    etNota.setText(texto)
                } else {
                    // si no editar, se puede mostrar un Toast o limpiar - aquí no hacemos nada
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)

        etNota = findViewById(R.id.etNota)
        btnCompartir = findViewById(R.id.btnCompartir)

        btnCompartir.setOnClickListener {
            val texto = etNota.text.toString()
            val intent = Intent(this, OpcionesActivity::class.java)
            intent.putExtra(EXTRA_NOTA, texto)
            opcionesLauncher.launch(intent)
        }

        savedInstanceState?.let {
            etNota.setText(it.getString(STATE_NOTA, ""))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_NOTA, etNota.text.toString())
    }
}