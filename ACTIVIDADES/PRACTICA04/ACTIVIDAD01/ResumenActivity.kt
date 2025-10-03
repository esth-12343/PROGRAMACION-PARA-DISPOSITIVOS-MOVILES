/*
Descripción: ResumenActivity - muestra los datos del usuario y permite confirmar o volver a editar
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
import androidx.appcompat.app.AppCompatActivity

class ResumenActivity : AppCompatActivity() {

    private lateinit var tvResumen: TextView
    private lateinit var btnConfirmar: Button
    private lateinit var btnVolverEditar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        tvResumen = findViewById(R.id.tvResumen)
        btnConfirmar = findViewById(R.id.btnConfirmar)
        btnVolverEditar = findViewById(R.id.btnVolverEditar)

        val usuario = intent.getSerializableExtra(FormularioActivity.KEY_USUARIO) as? Usuario
        usuario?.let {
            val texto = """
                Nombre: ${it.nombre}
                Edad: ${it.edad}
                Ciudad: ${it.ciudad}
                Correo: ${it.correo}
            """.trimIndent()
            tvResumen.text = texto
        }

        btnConfirmar.setOnClickListener {
            val data = Intent()
            data.putExtra("CONFIRMADO", true)
            data.putExtra(FormularioActivity.KEY_USUARIO, usuario)
            setResult(Activity.RESULT_OK, data)
            finish()
        }

        btnVolverEditar.setOnClickListener {
            val data = Intent()
            data.putExtra("CONFIRMADO", false)
            data.putExtra(FormularioActivity.KEY_USUARIO, usuario)
            setResult(Activity.RESULT_OK, data)
            finish()
        }
    }
}