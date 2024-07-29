package com.example.recipeapp

sealed class Screen(val route: String) {
    data object RecipeScreen : Screen("recipe-screen")
    data object DetailScreen : Screen("detail-screen")
}