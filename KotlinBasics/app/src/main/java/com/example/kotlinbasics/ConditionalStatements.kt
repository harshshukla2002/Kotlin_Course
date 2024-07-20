package com.example.kotlinbasics

fun main() {
    // if statement only executed when given condition is true
    val age = 18

    if (age == 18) {
        println("hey my age is 18 i can go club")
    }

    /* when the given condition is true then if block is executed and if this is not
       true then else block is executed */
    println("enter your age")
    val userAge = readln().toInt();

    if (userAge > 18) {
        println("you can go club")
    } else {
        println("you can't go club")
    }

    /* we can add extra condition using else-if, when we want to satisfy 2 or 3
       conditions */

    if (userAge > 40) {
        println("You are too old please go home")
    } else if (userAge > 18) {
        print("you can enter")
    } else {
        println("you are too young for this")
    }
}
