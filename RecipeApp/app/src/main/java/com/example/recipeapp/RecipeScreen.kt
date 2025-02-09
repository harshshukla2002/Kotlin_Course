package com.example.recipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun RecipeScreen(
    modifier: Modifier = Modifier,
    navigationToDetail: (Category) -> Unit,
    viewState: MainViewModel.RecipeState
) {
    val recipeViewModel: MainViewModel = viewModel()

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            viewState.loading -> {
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }

            viewState.error != null -> {
                Text(
                    text = "ERROR OCCURRED ${viewState.error}",
                    color = Color.Red,
                    modifier = Modifier
                        .padding(top = 60.dp)
                        .fillMaxSize()
                )
            }

            else -> {
                CategoryScreen(categories = viewState.list, navigationToDetail)
            }
        }

    }

}

@Composable
fun CategoryScreen(categories: List<Category>, navigationToDetail: (Category) -> Unit) {
    LazyVerticalGrid(
        GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 22.dp),
    ) {
        items(categories) { category ->
            CategoryItem(category = category, navigationToDetail)
        }
    }
}

@Composable
fun CategoryItem(category: Category, navigationToDetail: (Category) -> Unit) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .clickable { navigationToDetail(category) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        )

        Text(
            text = category.strCategory,
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}