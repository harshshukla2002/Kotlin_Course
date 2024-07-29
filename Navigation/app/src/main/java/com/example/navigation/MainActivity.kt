package com.example.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigation.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    NavigationContainer()
                }
            }
        }
    }
}


@Composable
fun NavigationContainer() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "first-screen") {
        composable("first-screen") {
            FirstScreen { name, age ->
                navController.navigate("second-screen/$name/$age")
            }
        }
        composable("second-screen/{name}/{age}") {
            val name = it.arguments?.getString("name") ?: "no-name"
            val age = it.arguments?.getString("age") ?: ""
            SecondScreen(name, age) {
                navController.navigate("first-screen")
            }
        }
    }
}