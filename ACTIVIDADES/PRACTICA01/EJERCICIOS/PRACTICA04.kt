/*
    Problema planteado: Juego para adivinar un número aleatorio entre 1 y 30 con máximo 5 intentos.
    Autor: Esther Mariana Chunga Pacheco
    Fecha creación: 25/08/2025
    Última modificación: 25/08/2025
*/

import kotlin.random.Random

fun main() {
    val numeroSecreto = Random.nextInt(1, 31)
    var intentos = 5
    var adivinaste = false

    println("Adivina el número entre 1 y 30. Tienes 5 intentos.")

    while (intentos > 0) {
        print("Ingresa tu número: ")
        val intento = readLine()?.toIntOrNull() ?: 0

        if (intento == numeroSecreto) {
            println("¡Felicidades! Adivinaste el número.")
            adivinaste = true
            break
        } else if (intento < numeroSecreto) {
            println("El número secreto es mayor.")
        } else {
            println("El número secreto es menor.")
        }

        intentos--
        println("Te quedan $intentos intentos.")
    }

    if (!adivinaste) {
        println("Game Over. El número era $numeroSecreto.")
    }
}
