package com.example.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.counterapp.ui.theme.CounterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: CounterViewModel by viewModels()
            CounterAppTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                ) {
                    Counter(viewModel)
                }
            }
        }
    }
}

@Composable
fun Counter(viewModel: CounterViewModel) {
    Column(
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = viewModel.count.value.toString(),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif
        )

        Row(
            modifier = Modifier.padding(top = 20.dp),
        ) {
            Button(onClick = { viewModel.increment() }, modifier = Modifier.padding(end = 20.dp)) {
                Text(text = "Increment", fontFamily = FontFamily.Serif)
            }

            Button(onClick = { viewModel.decrement() }) {
                Text(text = "Decrement", fontFamily = FontFamily.Serif)
            }
        }
    }
}
