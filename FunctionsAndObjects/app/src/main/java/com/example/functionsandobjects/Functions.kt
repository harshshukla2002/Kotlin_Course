package com.example.functionsandobjects

data class CoffeeDetails(
    val sugarCount: Int,
    val name: String,
)

fun main() {
    val myCoffee = CoffeeDetails(0, "harsh")
    makeCoffee(myCoffee)
}

fun add(num1: Int, num2: Int): Int {
    return num1 + num2
}


//fun askCoffee() {
//    // we call that function
//    var name = ""
//    var sugarCount = 0
//    println("enter your name: ")
//    name = readln()
//
//    println("enter how much sugar you want: ")
//    sugarCount = readln().toInt()
//
//    makeCoffee(myCoffee)
//}

// we define a function and we can pass the parameter also
fun makeCoffee(coffeeDetails: CoffeeDetails) {
    if (coffeeDetails.sugarCount > 0) {
        println(
            "${coffeeDetails.name} your coffee is ready with ${coffeeDetails.sugarCount} ${
                if (coffeeDetails.sugarCount == 1) "spoon" else "spoons"
            } sugar"
        )
    } else {
        println("${coffeeDetails.name} your coffee is ready with no sugar")
    }
}