package com.example.miaplicacion

fun sumar(numero1: Int, numero2: Int) : Int {
    return numero1 + numero2
}

fun saludar() {
    print("Hola")
}

fun esMayor(a: Int, b: Int) : Boolean {
    val resultado = a > b
    return resultado
}

fun retornarMayor (a: Int, b: Int) = if (a > b) a else true

fun describir (objeto: Any): String =
    when (objeto) {
        1   -> "Uno"
        "Hola"  -> "Saludo"
        is Long ->  "Long"
        !is String  -> "No es un string"
        else    ->  "Desconocido"
    }

fun main() {
    val a = 1;
    val string1 = "la variable a es $a";
    val grupo = listOf("Daniel", "Juan", "Fernando", "Carlos")
    var cantGrupo = "el grupo tiene ${grupo.size} integrantes"
    //print(retornarMayor(3, 29))
}