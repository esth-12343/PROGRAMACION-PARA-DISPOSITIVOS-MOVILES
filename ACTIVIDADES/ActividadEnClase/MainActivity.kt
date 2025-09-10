package com.example.ciclodevidaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var contador = 0
    private lateinit var textViewContador: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewContador = findViewById(R.id.textViewContador)
        val btnAumentar = findViewById<Button>(R.id.btnAumentar)

        btnAumentar.setOnClickListener {
            contador++ // cada vez que se pulsa aumenta 1
            textViewContador.text = "Contador: $contador"
        }

        // mensaje para saber si se llamo onCreat
        Log.d("CICLO", "onCreat llamado")
        Toast.makeText(this, "onCreat()", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        Log.d("CICLO", "onStart lalmado")
        Toast.makeText(this, "onStart()", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.d("CICLO", "onResume llamdo")
        Toast.makeText(this, "onResume()", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d("CICLO", "onPaus llamdo")
        Toast.makeText(this, "onPause()", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.d("CICLO", "onStop lamado")
        Toast.makeText(this, "onStop()", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        // este metodo se ejecuta cuando se destrulle la activity
        Log.d("CICLO", "onDestroy lamado")
        Toast.makeText(this, "onDestroy()", Toast.LENGTH_SHORT).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("CONTADOR", contador)
        // aqui guardo el contador sino se pierde
        Log.d("CICLO", "onSaveInstanceState: guardando contadr = $contador")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        contador = savedInstanceState.getInt("CONTADOR")
        textViewContador.text = "Contador: $contador"
        // restaurar el valor del contadr
        Log.d("CICLO", "onRestoreInstanceState: restaurando contadr = $contador")
    }
}
