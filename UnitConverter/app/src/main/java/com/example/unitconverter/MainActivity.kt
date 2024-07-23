package com.example.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import com.example.unitconverter.ui.theme.UnitConverterTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter() {
    var inputValue by remember {
        mutableStateOf("")
    }
    var outputValue by remember {
        mutableStateOf("")
    }
    var inputUnit by remember {
        mutableStateOf("Centimeters")
    }
    var outputUnit by remember {
        mutableStateOf("Meters")
    }
    var iExpanded by remember {
        mutableStateOf(false)
    }
    var oExpanded by remember {
        mutableStateOf(false)
    }
    val iconversionFactor = remember {
        mutableDoubleStateOf(1.0)
    }

    val oconversionFactor = remember {
        mutableDoubleStateOf(1.0)
    }

    val customStyles = TextStyle(
        fontFamily = FontFamily.Serif,
        fontSize = 25.sp,
        color = Color.Red
    )

    fun unitConverter() {
        // ?: <- this is called elvish operator which is used when we have dynamic values which
        // should be null or undefined then return default value
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result =
            (inputValueDouble * iconversionFactor.doubleValue * 100.0 / oconversionFactor.doubleValue)
                .roundToInt() / 100.0
        outputValue = result.toString()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Unit Converter", style = customStyles)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = inputValue, onValueChange = {
            inputValue = it
            unitConverter()
        }, label = { Text(text = "Enter Value") })
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.padding(5.dp)) {

            Box {
                Button(onClick = {
                    iExpanded = true
                }) {
                    Text(text = inputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "")
                }

                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {
                    DropdownMenuItem(text = { Text(text = "Centimeters") }, onClick = {
                        iExpanded = false
                        inputUnit = "Centimeters"
                        iconversionFactor.doubleValue = 0.01
                        unitConverter()
                    })
                    DropdownMenuItem(text = { Text(text = "Meters") }, onClick = {
                        iExpanded = false
                        inputUnit = "Meters"
                        iconversionFactor.doubleValue = 1.0
                        unitConverter()
                    })
                    DropdownMenuItem(text = { Text(text = "Feet") }, onClick = {
                        iExpanded = false
                        inputUnit = "Feet"
                        iconversionFactor.doubleValue = 0.3048
                        unitConverter()
                    })
                    DropdownMenuItem(text = { Text(text = "Millimeters") }, onClick = {
                        iExpanded = false
                        inputUnit = "Millimeters"
                        iconversionFactor.doubleValue = 0.001
                        unitConverter()
                    })
                }
            }
            Spacer(modifier = Modifier.width(20.dp))
            Box {
                Button(onClick = {
                    oExpanded = true
                }) {
                    Text(text = outputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "")
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {
                    DropdownMenuItem(text = { Text(text = "Centimeters") }, onClick = {
                        oExpanded = false
                        outputUnit = "Centimeters"
                        oconversionFactor.doubleValue = 0.01
                        unitConverter()
                    })
                    DropdownMenuItem(text = { Text(text = "Meters") }, onClick = {
                        oExpanded = false
                        outputUnit = "Meters"
                        oconversionFactor.doubleValue = 1.0
                        unitConverter()
                    })
                    DropdownMenuItem(text = { Text(text = "Feet") }, onClick = {
                        oExpanded = false
                        outputUnit = "Feet"
                        oconversionFactor.doubleValue = 0.3048
                        unitConverter()
                    })
                    DropdownMenuItem(text = { Text(text = "Millimeters") }, onClick = {
                        oExpanded = false
                        outputUnit = "Millimeters"
                        oconversionFactor.doubleValue = 0.001
                        unitConverter()
                    })
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Result: $outputValue $outputUnit",
            style = MaterialTheme.typography.headlineSmall
        )
    }
}
