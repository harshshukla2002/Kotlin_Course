package com.example.statemanagment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.statemanagment.ui.theme.StateManagmentTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StateManagmentTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    CaptainGame()
                }
            }
        }
    }
}

@Composable
fun CaptainGame() {
//    val treasureFound = remember {
//        mutableStateOf(0)
//    }

    var treasureFound by remember {
        mutableStateOf(0)
    }
    val direction = remember {
        mutableStateOf("North")
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Text(text = "Treasure Found: ${treasureFound}")
        Text(text = "Current Direction: ${direction.value}")

        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            direction.value = "East"

            if (Random.nextBoolean()) {
                treasureFound += 1
            }
        }) {
            Text(text = "Sail East")
        }

        Button(onClick = {
            direction.value = "West"

            if (Random.nextBoolean()) {
                treasureFound += 1
            }
        }) {
            Text(text = "Sail West")
        }

        Button(onClick = {
            direction.value = "North"

            if (Random.nextBoolean()) {
                treasureFound += 1
            }
        }) {
            Text(text = "Sail North")
        }

        Button(onClick = {
            direction.value = "South"

            if (Random.nextBoolean()) {
                treasureFound += 1
            }
        }) {
            Text(text = "Sail South")
        }
    }
}