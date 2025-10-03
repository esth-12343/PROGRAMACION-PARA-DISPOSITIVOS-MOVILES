/*
Descripción: MainActivity que muestra RecyclerView de usuarios
Autor: Esther Mariana Chunga Pacheco
Fecha creación: 12/09/2025
Fecha última modificación: 12/09/2025
*/
package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UsuarioAdapter
    private val usuarios = mutableListOf(
        Usuario("Carlos", 22, "carlos@mail.com"),
        Usuario("María", 25, "maria@mail.com"),
        Usuario("Juan", 30, "juan@mail.com")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerUsuarios)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = UsuarioAdapter(
            usuarios,
            onEditClick = { pos, usuario ->
                usuarios[pos] = usuario
                adapter.notifyItemChanged(pos) // 🔑 refresca solo ese item
            },
            onDeleteClick = { pos ->
                usuarios.removeAt(pos)
                adapter.notifyItemRemoved(pos)
            }
        )

        recyclerView.adapter = adapter
    }
}
