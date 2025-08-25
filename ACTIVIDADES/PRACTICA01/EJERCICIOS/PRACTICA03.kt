/*
    Problema planteado: Calculadora básica que realiza suma, resta, multiplicación y división.
    Autor: Esther Mariana Chunga Pacheco
    Fecha creación: 25/08/2025
    Última modificación: 25/08/2025
*/

fun mostrarMenu() {
    println("==== Menú ====")
    println("1. Suma")
    println("2. Resta")
    println("3. Multiplicación")
    println("4. División")
    println("5. Salir")
}

fun suma(a: Double, b: Double) = a + b
fun resta(a: Double, b: Double) = a - b
fun multiplicacion(a: Double, b: Double) = a * b
fun division(a: Double, b: Double): Double? = if (b != 0.0) a / b else null

fun main() {
    var opcion: Int

    do {
        mostrarMenu()
        print("Seleccione una opción: ")
        opcion = readLine()?.toIntOrNull() ?: 0

        if (opcion in 1..4) {
            print("Ingrese el primer número: ")
            val num1 = readLine()?.toDoubleOrNull() ?: 0.0

            print("Ingrese el segundo número: ")
            val num2 = readLine()?.toDoubleOrNull() ?: 0.0

            val resultado = when (opcion) {
                1 -> suma(num1, num2)
                2 -> resta(num1, num2)
                3 -> multiplicacion(num1, num2)
                4 -> division(num1, num2) ?: run {
                    println("Error: División entre cero")
                    continue
                }
                else -> 0.0
            }

            println("Resultado: $resultado")
        } else if (opcion != 5) {
            println("Opción inválida, intenta de nuevo.")
        }
    } while (opcion != 5)

    println("Saliendo de la calculadora...")
}
