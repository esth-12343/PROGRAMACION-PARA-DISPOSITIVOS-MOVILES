/*
Descripción: Sistema de gestión de biblioteca con materiales, usuarios y operaciones
Autor: Esther Chunga
Fecha creación: 02/09/2025
Fecha última modificación: 02/09/2025
*/

abstract class Material(
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int
) {
    abstract fun mostrarDetalles()
}

class Libro(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val genero: String,
    val paginas: Int
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Libro: $titulo, Autor: $autor, Año: $anioPublicacion, Género: $genero, Páginas: $paginas")
    }
}

class Revista(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val issn: String,
    val volumen: Int,
    val numero: Int,
    val editorial: String
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Revista: $titulo, Autor: $autor, Año: $anioPublicacion, ISSN: $issn, Volumen: $volumen, Número: $numero, Editorial: $editorial")
    }
}

data class Usuario(val nombre: String, val apellido: String, val edad: Int)

interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestarMaterial(usuario: Usuario, material: Material)
    fun devolverMaterial(usuario: Usuario, material: Material)
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesUsuario(usuario: Usuario)
}

class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val prestamos = mutableMapOf<Usuario, MutableList<Material>>()

    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
    }

    override fun registrarUsuario(usuario: Usuario) {
        prestamos[usuario] = mutableListOf()
    }

    override fun prestarMaterial(usuario: Usuario, material: Material) {
        if (materialesDisponibles.contains(material)) {
            materialesDisponibles.remove(material)
            prestamos[usuario]?.add(material)
            println("${usuario.nombre} ha prestado ${material.titulo}")
        } else {
            println("El material no está disponible.")
        }
    }

    override fun devolverMaterial(usuario: Usuario, material: Material) {
        prestamos[usuario]?.remove(material)
        materialesDisponibles.add(material)
        println("${usuario.nombre} ha devuelto ${material.titulo}")
    }

    override fun mostrarMaterialesDisponibles() {
        println("Materiales disponibles:")
        materialesDisponibles.forEach { it.mostrarDetalles() }
    }

    override fun mostrarMaterialesUsuario(usuario: Usuario) {
        println("Materiales prestados a ${usuario.nombre}:")
        prestamos[usuario]?.forEach { it.mostrarDetalles() }
    }
}

// Prueba
fun main() {
    val biblioteca = Biblioteca()

    val libro = Libro("El Quijote", "Cervantes", 1605, "Novela", 863)
    val revista = Revista("National Geographic", "Varios", 2023, "1234-5678", 45, 7, "NatGeo")

    val usuario = Usuario("Ana", "Pérez", 25)

    biblioteca.registrarMaterial(libro)
    biblioteca.registrarMaterial(revista)
    biblioteca.registrarUsuario(usuario)

    biblioteca.mostrarMaterialesDisponibles()
    biblioteca.prestarMaterial(usuario, libro)
    biblioteca.mostrarMaterialesUsuario(usuario)
    biblioteca.devolverMaterial(usuario, libro)
    biblioteca.mostrarMaterialesDisponibles()
}
