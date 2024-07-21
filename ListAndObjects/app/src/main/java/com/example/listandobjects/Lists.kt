package com.example.listandobjects

fun main() {

    // creating list using listof and this is immutable
    var shoppingList = listOf("Processor", "RAM", "Graphic Card", "SSD", "MotherBoard")

    // if we want dynamic list which is mutable we use mutableListOf
    val mutableList = mutableListOf("Processor", "RAM", "Graphic Card", "SSD", "MotherBoard")

    mutableList.add("ROM") // we can add element

    mutableList.remove("RAM") // remove element

    mutableList.removeAt(2) // remove at given index

    mutableList.add(2, "RAM") // add element at specific position

    mutableList[3] = "Mother Board" // we can modify element like this

    mutableList.set(1, "Graphic Card RTX500") // use to modify item using set()

    println(mutableList.contains("RAM")) // check if given item is present or not

    println(mutableList)
}