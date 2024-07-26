package com.example.inheritance

class OffSpring : Secondary(), Archery, Singer {

    override fun archery() {
        super.archery()
        println("Archery from OffSpring File")
    }

    override fun singing() {
        super.singing()
        println("Singer from OffSpring File")
    }
}