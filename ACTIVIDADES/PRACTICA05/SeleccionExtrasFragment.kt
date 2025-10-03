/*
Descripción: Selección de extras para el pedido.
Autor: Esther Mariana Chunga Pacheco.
Fecha creación: 12/09/2025
Fecha última modificación: 12/09/2025
*/

package com.example.practica5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SeleccionExtrasFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_extras, container, false)

        val cbBebida = view.findViewById<CheckBox>(R.id.cbBebida)
        val cbPapas = view.findViewById<CheckBox>(R.id.cbPapas)
        val cbPostre = view.findViewById<CheckBox>(R.id.cbPostre)
        val btnSiguiente = view.findViewById<Button>(R.id.btnSiguienteExtras)

        btnSiguiente.setOnClickListener {
            val comida = arguments?.getString("comida") ?: ""
            val extras = mutableListOf<String>()
            if (cbBebida.isChecked) extras.add("Bebida")
            if (cbPapas.isChecked) extras.add("Papas")
            if (cbPostre.isChecked) extras.add("Postre")

            val bundle = Bundle().apply {
                putString("comida", comida)
                putStringArrayList("extras", ArrayList(extras))
            }
            findNavController().navigate(R.id.action_extras_to_resumen, bundle)
        }
        return view
    }
}
