package com.example.bankaccount

class BankAccount(var accountHolder: String, var balance: Double) {
    private val transactionHistory = mutableListOf<String>()

    fun deposit(amount: Double) {
        balance += amount
        println("$accountHolder deposited $amount")
        transactionHistory.add("deposited $amount")
    }

    fun availableBalance() {
        println("Available balance is $balance")
    }

    fun withdraw(amount: Double) {
        if (amount <= balance) {
            balance -= amount
            println("$accountHolder withdrew $amount")
            transactionHistory.add("withdrew $amount")
        } else {
            println("Insufficient Balance")
        }
    }

    fun displayHistory() {
        println("\n History of $accountHolder: ")
        for (transaction in transactionHistory) {
            println(transaction)
        }
    }
}