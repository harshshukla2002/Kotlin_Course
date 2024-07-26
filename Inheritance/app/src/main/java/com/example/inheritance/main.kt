package com.example.inheritance

fun main() {
    val basicClassObj = BaseClass()
    basicClassObj.coreValues()

    val secondaryClassObj = Secondary()
    secondaryClassObj.coreValues()
    secondaryClassObj.roles()

    val frank = OffSpring()

    frank.archery()
    frank.singing()
}