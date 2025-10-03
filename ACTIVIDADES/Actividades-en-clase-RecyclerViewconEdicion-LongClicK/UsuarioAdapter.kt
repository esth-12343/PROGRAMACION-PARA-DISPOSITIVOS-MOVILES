/*
Descripción: Adapter del RecyclerView con long click para Editar/Eliminar
Autor: Esther Mariana Chunga Pacheco
Fecha creación: 12/09/2025
Fecha última modificación: 12/09/2025
*/
package com.example.recyclerviewapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView

class UsuarioAdapter(
    private val usuarios: MutableList<Usuario>,
    private val onEditClick: (Int, Usuario) -> Unit,
    private val onDeleteClick: (Int) -> Unit
) : RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>() {

    inner class UsuarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        private val tvEdad: TextView = itemView.findViewById(R.id.tvEdad)
        private val tvCorreo: TextView = itemView.findViewById(R.id.tvCorreo)

        fun bind(usuario: Usuario) {
            tvNombre.text = usuario.nombre
            tvEdad.text = "Edad: ${usuario.edad}"
            tvCorreo.text = usuario.correo

            // Long click para mostrar menú Editar / Eliminar
            itemView.setOnLongClickListener {
                val pos = bindingAdapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    AlertDialog.Builder(itemView.context)
                        .setTitle("Acción")
                        .setItems(arrayOf("Editar", "Eliminar")) { _, which ->
                            when (which) {
                                0 -> showEditDialog(usuario)
                                1 -> onDeleteClick(pos)
                            }
                        }
                        .show()
                }
                true
            }
        }

        private fun showEditDialog(usuario: Usuario) {
            val context = itemView.context
            val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_edit_usuario, null)

            val editNombre = dialogView.findViewById<EditText>(R.id.editNombre)
            val editEdad = dialogView.findViewById<EditText>(R.id.editEdad)
            val editCorreo = dialogView.findViewById<EditText>(R.id.editCorreo)

            // Valores actuales
            editNombre.setText(usuario.nombre)
            editEdad.setText(usuario.edad.toString())
            editCorreo.setText(usuario.correo)

            AlertDialog.Builder(context)
                .setTitle("Editar usuario")
                .setView(dialogView)
                .setPositiveButton("Guardar") { _, _ ->
                    val pos = bindingAdapterPosition
                    if (pos != RecyclerView.NO_POSITION) {
                        usuario.nombre = editNombre.text.toString()
                        usuario.edad = editEdad.text.toString().toIntOrNull() ?: usuario.edad
                        usuario.correo = editCorreo.text.toString()
                        onEditClick(pos, usuario)
                    }
                }
                .setNegativeButton("Cancelar", null)
                .show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_usuario, parent, false)
        return UsuarioViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        holder.bind(usuarios[position])
    }

    override fun getItemCount(): Int = usuarios.size
}
