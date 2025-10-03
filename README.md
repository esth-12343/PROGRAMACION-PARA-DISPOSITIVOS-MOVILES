# PROGRAMACIÓN PARA DISPOSITIVOS MÓVILES

## 🚀 Proyectos en Kotlin

### 👩‍💻 Autora
**Esther Chunga Pacheco**  
📧 [esth-12343](https://github.com/esth-12343)

### 👨‍🏫 Profesor
**Josue Miguel Flores Parra**  
*Programación para Dispositivos Móviles*

---

## 📋 Programas Incluidos

### 1. EvaluacionEmpleados.kt 
**Sistema de evaluación de empleados**  
Calcula el nivel de rendimiento y bonificación según puntuación.

### 2. PiedraPapelTijera.kt 
**Juego interactivo**  
Juego clásico de Piedra, Papel o Tijera contra la computadora.

### 3. Calculadora.kt 
**Calculadora básica**  
Realiza operaciones aritméticas fundamentales.

### 4. AdivinaNumero.kt 
**Juego de adivinanza**  
Adivina un número aleatorio con intentos limitados.

1. Práctica 4 – Comunicación entre Activities

Objetivo: Enviar y recibir datos entre pantallas usando Intent y registerForActivityResult.

Parte A: Editor de perfil (Nombre, Edad, Ciudad, Correo).

Parte B: Editor de notas rápidas con opción de compartir.

Aprendizaje: Uso de Serializable, onSaveInstanceState, y paso de resultados entre Activities.

2. Práctica 5 – Fragments y Navegación

Objetivo: Configurador de pedidos paso a paso con NavHostFragment.

Fragments usados:

InicioFragment → botón "Nuevo pedido".

SeleccionComidaFragment → elegir comida.

SeleccionExtrasFragment → elegir extras.

ResumenPedidoFragment → mostrar pedido y confirmar/editar.

Aprendizaje: Paso de datos con Bundle, navegación con navigate(), comunicación de regreso con setFragmentResult().

3. Práctica Guiada – RecyclerView con Edición y Long Click

Objetivo: Mostrar y editar una lista de usuarios con RecyclerView.

Funciones implementadas:

LongClick para abrir menú de opciones (Editar/Eliminar).

Diálogo personalizado para modificar nombre, edad y correo.

Actualización de la lista con notifyItemChanged() y notifyItemRemoved().

---

## 🛠️ Cómo Ejecutar

### Compilación:
```bash
kotlinc archivo.kt -include-runtime -d archivo.jar
