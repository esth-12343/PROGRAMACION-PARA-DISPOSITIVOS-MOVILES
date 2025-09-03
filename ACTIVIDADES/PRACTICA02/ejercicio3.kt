/*
Descripción: Clase abstracta Shape con subclases Cuadrado, Círculo y Rectángulo
Autor: Esther Chunga
Fecha creación: 02/09/2025
Fecha última modificación: 02/09/2025
*/

abstract class Shape {
    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double

    fun imprimirResultados() {
        println("Área: ${calcularArea()}")
        println("Perímetro: ${calcularPerimetro()}")
    }
}

class Cuadrado(private val lado: Double) : Shape() {
    override fun calcularArea() = lado * lado
    override fun calcularPerimetro() = 4 * lado
}

class Rectangulo(private val base: Double, private val altura: Double) : Shape() {
    override fun calcularArea() = base * altura
    override fun calcularPerimetro() = 2 * (base + altura)
}

class Circulo(private val radio: Double) : Shape() {
    override fun calcularArea() = Math.PI * radio * radio
    override fun calcularPerimetro() = 2 * Math.PI * radio
}

// Prueba
fun main() {
    val cuadrado = Cuadrado(5.0)
    cuadrado.imprimirResultados()

    val rectangulo = Rectangulo(4.0, 6.0)
    rectangulo.imprimirResultados()

    val circulo = Circulo(3.0)
    circulo.imprimirResultados()
}
