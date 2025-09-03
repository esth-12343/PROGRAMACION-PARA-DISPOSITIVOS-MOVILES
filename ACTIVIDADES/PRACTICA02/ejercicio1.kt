/*
Descripción: Clase CuentaBancaria con saldo, límite de retiro y validaciones con set/get
Autor: Esther Chunga
Fecha creación: 02/09/2025
Fecha última modificación: 02/09/2025
*/

class CuentaBancaria(private var _saldo: Double, private var _limiteRetiro: Double) {

    var saldo: Double
        get() = _saldo
        set(value) {
            if (value >= 0) _saldo = value
            else println("El saldo no puede ser negativo.")
        }

    var limiteRetiro: Double
        get() = _limiteRetiro
        set(value) {
            if (value > 0) _limiteRetiro = value
            else println("El límite de retiro debe ser positivo.")
        }

    fun retirar(monto: Double) {
        if (monto > limiteRetiro) {
            println("El monto excede el límite de retiro.")
        } else if (monto > saldo) {
            println("Fondos insuficientes.")
        } else {
            saldo -= monto
            println("Retiro exitoso. Nuevo saldo: $saldo")
        }
    }
}

// Prueba
fun main() {
    val cuenta = CuentaBancaria(1000.0, 500.0)
    cuenta.retirar(600.0)
    cuenta.retirar(200.0)
}
