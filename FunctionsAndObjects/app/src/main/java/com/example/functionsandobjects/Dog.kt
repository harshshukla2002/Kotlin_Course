package com.example.functionsandobjects

class Dog(val name: String, val breed: String) {

    // when Dog class is firstly created
    init {
        println("class created")
    }

    fun bark() {
        println("${name} says Woof! Woof!")
    }
}