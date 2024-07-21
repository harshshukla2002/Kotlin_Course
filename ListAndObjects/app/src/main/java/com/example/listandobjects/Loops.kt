package com.example.listandobjects

fun main() {
    val names = mutableListOf("Rakesh", "Ajay", "Pawan", "Sumit", "Harsh", "Ankush")

    for (name in names) {
        println(name)
    }

    // if we want index
    for (index in 0 until names.size) {
        println(index)
    }
}