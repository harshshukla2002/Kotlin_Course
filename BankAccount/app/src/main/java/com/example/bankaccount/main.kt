package com.example.bankaccount

fun main() {
    val myAccount = BankAccount("Harsh", 2000.45)

    println("Account owner is ${myAccount.accountHolder}")

    myAccount.deposit(300.00)

    myAccount.availableBalance()

    myAccount.withdraw(500.00)

    myAccount.availableBalance()

    myAccount.displayHistory()

}