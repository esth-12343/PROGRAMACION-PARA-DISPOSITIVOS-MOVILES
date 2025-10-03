/*
Descripción: Muestra resumen del pedido con opciones para confirmar o editar
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
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController

class ResumenPedidoFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_resumen, container, false)

        val tvResumen = view.findViewById<TextView>(R.id.tvResumen)
        val btnConfirmar = view.findViewById<Button>(R.id.btnConfirmar)
        val btnEditar = view.findViewById<Button>(R.id.btnEditar)

        val comida = arguments?.getString("comida") ?: ""
        val extras = arguments?.getStringArrayList("extras") ?: arrayListOf()

        val resumen = "Comida: $comida\nExtras: ${extras.joinToString(", ")}"
        tvResumen.text = resumen

        btnConfirmar.setOnClickListener {
            Toast.makeText(requireContext(), "Pedido confirmado", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.inicioFragment)
        }

        btnEditar.setOnClickListener {
            val bundle = Bundle().apply {
                putString("comida", comida)
                putStringArrayList("extras", extras)
            }
            setFragmentResult("pedidoEditado", bundle)
            findNavController().popBackStack(R.id.seleccionComidaFragment, false)
        }

        return view
    }
}
