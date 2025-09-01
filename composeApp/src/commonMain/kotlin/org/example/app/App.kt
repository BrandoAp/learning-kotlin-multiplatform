package org.example.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import org.example.app.ui.screens.MainScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        Navigator(screen = MainScreen()){ navigator ->
            SlideTransition(navigator)
        }
    }
}