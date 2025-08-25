/*
    Problema planteado: Juego de piedra, papel o tijera contra la computadora.
    Autor: Esther Mariana Chunga Pacheco
    Fecha creación: 25/08/2025
    Última modificación: 25/08/2025
*/

import kotlin.random.Random

fun obtenerOpcionComputadora(): String {
    val opciones = listOf("piedra", "papel", "tijera")
    return opciones[Random.nextInt(opciones.size)]
}

fun determinarGanador(usuario: String, computadora: String): String {
    return if (usuario == computadora) {
        "Empate"
    } else if (
        (usuario == "piedra" && computadora == "tijera") ||
        (usuario == "papel" && computadora == "piedra") ||
        (usuario == "tijera" && computadora == "papel")
    ) {
        "Ganaste"
    } else {
        "Perdiste"
    }
}

fun main() {
    println("Elige piedra, papel o tijera: ")
    val usuario = readLine()?.lowercase() ?: ""
    val computadora = obtenerOpcionComputadora()

    if (usuario !in listOf("piedra", "papel", "tijera")) {
        println("Opción inválida.")
    } else {
        println("Computadora eligió: $computadora")
        println(determinarGanador(usuario, computadora))
    }
}
