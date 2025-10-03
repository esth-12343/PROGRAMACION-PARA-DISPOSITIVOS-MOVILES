/*
Descripción: Fragmento inicial con botón para comenzar un nuevo pedido.
Autor: Esther Mariana Chunga Pacheco
Fecha creación: 12/09/2025
Fecha última modificación: 12/09/2025
*/

package com.example.practica5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class InicioFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_inicio, container, false)
        val btnNuevoPedido = view.findViewById<Button>(R.id.btnNuevoPedido)
        btnNuevoPedido.setOnClickListener {
            findNavController().navigate(R.id.action_inicio_to_comida)
        }
        return view
    }
}
