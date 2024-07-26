package com.example.inheritance

open class Secondary : BaseClass() {
    override fun roles() {
        super.roles()
        println("Member of secondary")
    }
}