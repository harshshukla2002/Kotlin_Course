package com.example.rockpaperscissor

fun main() {
    var computerChoice = ""
    var playerChoice = ""
    println("What is your choice?, Rock, Paper or Scissor!!")
    playerChoice = readln().lowercase()

    // to validate user input
    while (playerChoice != "rock" && playerChoice != "paper" && playerChoice != "scissor") {
        println("Invalid input!!, please enter valid input")
        playerChoice = readln().lowercase()
    }

    val randomNumber = (1..3).random()

    // we can use when in two types

    // first like this
    when (randomNumber) {
        1 -> {
            computerChoice = "rock"
        }

        2 -> {
            computerChoice = "paper"
        }

        3 -> {
            computerChoice = "scissor"
        }
    }

    println("Computer choice is $computerChoice")
    println("player choice is $playerChoice")

    // second like this
    val winner = when {
        playerChoice == computerChoice -> "Tie"
        playerChoice == "rock" && computerChoice == "scissor" -> "Player"
        playerChoice == "paper" && computerChoice == "rock" -> "Player"
        playerChoice == "scissor" && computerChoice == "paper" -> "Player"
        else -> "Computer"
    }

    println("Winner is $winner")
}