package com.example.composablecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import buttons.ButtonCalculator
import com.example.composablecalculator.ui.theme.ComposableCalculatorTheme
import styles.DeleteButtonColor
import styles.EqualButtonColor
import styles.NumberButtonColor
import styles.OperatorButtonColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposableCalculatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Screen()
                }
            }
        }
    }
}

@Composable
fun Screen() {
    val symbols = listOf(
        listOf("AC", "( )", "%", "/"),
        listOf("7", "8", "9", "x"),
        listOf("4", "5", "6", "-"),
        listOf("1", "2", "3", "+"),
        listOf("0", ".", "<-", "=")
    )

    Column(
        Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        for (i in symbols.indices) {
            ButtonRow(symbols = symbols[i])
        }
    }
}

@Composable
fun ButtonRow(symbols: List<String>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        for (symbol in symbols) {
            val (color, fontSize) = when (symbol) {
                "AC", "<-" -> Pair(DeleteButtonColor, 15.sp)
                "+", "-", "x", "/", "%" -> Pair(OperatorButtonColor, 45.sp)
                "=" -> Pair(EqualButtonColor, 40.sp)
                "( )" -> Pair(OperatorButtonColor, 25.sp)
                else -> Pair(NumberButtonColor, 45.sp)
            }

            ButtonCalculator(
                text = symbol,
                onClick = {},
                color = color,
                fontSize = fontSize
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Calculator() {
    ComposableCalculatorTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Screen()
        }
    }
}