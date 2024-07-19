package com.example.kotlinbasics

fun main() {
    println("Hello World")

    // - if we declare variable using val we can't re assign the new value again to it
    val myAge1 = 23
//    myAge1 = 24
    println(myAge1)

    // - if we use var we can reassign a new value to it
    var myAge = 22;
    myAge = 24
    println(myAge)

    // we want to define type so we can define like this
    val mySecondAge: Byte = 23
    println(mySecondAge)

    /* we first assign value and confirmed as a one type next we cannot again add value
     more than that type limit */
    val myFixedAge = 4444444444
//    myFixedAge = 343434237892748739874
    println(myFixedAge)

    /* we can assign the float(decimal) value and we have two type in this one is float ans
     second is double by default kotlin uses double but we can override this */
    val pi = 3.14
    println(pi)

    // we can add 'f' at the end to make this as a float
    val newPi = 3.14f
    println(newPi)

    /* we have unsigned integer types also that never be negative so if we assign a variable and
     define type as unsigned that value should never be negative */
    val myPositiveAge: UByte = 23u
    println(myPositiveAge)

    // we can define boolean values also
    val myTrue: Boolean = false
    println(myTrue)
}
