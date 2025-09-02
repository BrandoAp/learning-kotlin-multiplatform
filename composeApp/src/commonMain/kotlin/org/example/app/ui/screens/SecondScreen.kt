package org.example.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.example.app.ui.components.CustomButton
import org.example.app.ui.components.ErrorDialog
import org.example.app.ui.components.InputText

class SecondScreen : Screen {
    @Composable
    override fun Content() {
        var name by remember { mutableStateOf("") }
        var showError by remember { mutableStateOf(false)}

        val navigator = LocalNavigator.currentOrThrow
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                "Segunda Pantalla",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
            InputText(
                value = name,
                onValueChange = { name = it},
                label = "Ingrese su nombre",
                placeholder = "Nombre",
                modifier = Modifier
                    .width(200.dp)
                    .border(2.dp, color = Color.Black, shape = RoundedCornerShape(16.dp))
            )
            Spacer(Modifier.height(20.dp))
            CustomButton(
                "Siguiente",
                onClick = {
                    if (name.isEmpty()){
                        showError = true
                    } else
                        navigator.pop()
                },
                modifier = Modifier
                    .width(200.dp)
            )
            if (showError){
                ErrorDialog(
                    message = "El campo no puede estar vacio.",
                    onDismiss = { showError = false }
                )
            }
        }
    }
}