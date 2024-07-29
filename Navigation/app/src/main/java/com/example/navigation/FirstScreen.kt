package com.example.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FirstScreen(navigateToSecondScreen: (String, String) -> Unit) {
    val name = remember {
        mutableStateOf("")
    }
    val age = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "This is the First Screen", fontSize = 25.sp)
        Spacer(modifier = Modifier.height(6.dp))
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            OutlinedTextField(value = name.value, onValueChange = {
                name.value = it
            }, modifier = Modifier.width(180.dp), placeholder = {
                Text(text = "enter name")
            })
            Spacer(modifier = Modifier.width(16.dp))
            OutlinedTextField(value = age.value.toString(), onValueChange = {
                age.value = it
            }, modifier = Modifier.width(180.dp), placeholder = {
                Text(text = "enter age")
            })
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navigateToSecondScreen(name.value, age.value.toString()) },
            shape = RoundedCornerShape(
                4.dp
            )
        ) {
            Text(text = "Go to First Screen")
        }
    }
}
