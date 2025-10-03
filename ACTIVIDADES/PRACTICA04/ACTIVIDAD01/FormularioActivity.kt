/*
Descripción: FormularioActivity - pide nombre, edad, ciudad y correo y envía a ResumenActivity
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
import android.widget.Toast

class FormularioActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etEdad: EditText
    private lateinit var etCiudad: EditText
    private lateinit var etCorreo: EditText
    private lateinit var btnContinuar: Button

    companion object {
        const val KEY_USUARIO = "KEY_USUARIO"
        const val STATE_NOMBRE = "state_nombre"
        const val STATE_EDAD = "state_edad"
        const val STATE_CIUDAD = "state_ciudad"
        const val STATE_CORREO = "state_correo"
    }

    private val resumenLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK && result.data != null) {
                val confirmed = result.data!!.getBooleanExtra("CONFIRMADO", false)
                val returnedUsuario = result.data!!.getSerializableExtra(KEY_USUARIO) as? Usuario
                if (confirmed) {
                    Toast.makeText(this, "Perfil guardado correctamente", Toast.LENGTH_SHORT).show()
                    // Aquí podrías hacer más (guardar en prefs, BD, etc.)
                } else {
                    // Volver a editar: si viene Usuario, restaurar campos
                    returnedUsuario?.let {
                        etNombre.setText(it.nombre)
                        etEdad.setText(it.edad)
                        etCiudad.setText(it.ciudad)
                        etCorreo.setText(it.correo)
                    }
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        etNombre = findViewById(R.id.etNombre)
        etEdad = findViewById(R.id.etEdad)
        etCiudad = findViewById(R.id.etCiudad)
        etCorreo = findViewById(R.id.etCorreo)
        btnContinuar = findViewById(R.id.btnContinuar)

        btnContinuar.setOnClickListener {
            val usuario = Usuario(
                nombre = etNombre.text.toString(),
                edad = etEdad.text.toString(),
                ciudad = etCiudad.text.toString(),
                correo = etCorreo.text.toString()
            )
            val intent = Intent(this, ResumenActivity::class.java)
            intent.putExtra(KEY_USUARIO, usuario)
            resumenLauncher.launch(intent)
        }

        // Restaurar después de rotación si existe
        savedInstanceState?.let {
            etNombre.setText(it.getString(STATE_NOMBRE, ""))
            etEdad.setText(it.getString(STATE_EDAD, ""))
            etCiudad.setText(it.getString(STATE_CIUDAD, ""))
            etCorreo.setText(it.getString(STATE_CORREO, ""))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_NOMBRE, etNombre.text.toString())
        outState.putString(STATE_EDAD, etEdad.text.toString())
        outState.putString(STATE_CIUDAD, etCiudad.text.toString())
        outState.putString(STATE_CORREO, etCorreo.text.toString())
    }
}