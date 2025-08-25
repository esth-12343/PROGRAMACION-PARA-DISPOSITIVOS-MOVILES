/*
    Problema planteado : Calcula el nivel de rendimiento y el dinero extra que recibirá un empleado según su puntuación.
    Autor: Esther Mariana Chunga Pacheco
    Fecha creación: 25/08/2025
    Última modificación: 25/08/2025
*/

fun calcularNivel(puntuacion: Double): String {
    return when {
        puntuacion in 0.0..3.0 -> "Inaceptable"
        puntuacion in 4.0..6.0 -> "Aceptable"
        puntuacion in 7.0..10.0 -> "Meritorio"
        else -> "Puntuación inválida"
    }
}

fun calcularDineroExtra(salario: Double, puntuacion: Double): Double {
    return salario * (puntuacion / 10)
}

fun main() {
    print("Ingrese su salario mensual: ")
    val salario = readLine()?.toDoubleOrNull() ?: 0.0

    print("Ingrese su puntuación (0 a 10): ")
    val puntuacion = readLine()?.toDoubleOrNull() ?: 0.0

    val nivel = calcularNivel(puntuacion)
    if (nivel == "Puntuación inválida") {
        println("Error: la puntuación debe estar entre 0 y 10.")
    } else {
        val dineroExtra = calcularDineroExtra(salario, puntuacion)
        println("Nivel de Rendimiento: $nivel")
        println("Cantidad de dinero recibido: \$${"%.2f".format(dineroExtra)}")
    }
}
