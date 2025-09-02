package org.example.app.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.Placeholder

@Composable
fun InputText(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    modifier: Modifier

){
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label)},
        placeholder = { Text(placeholder) },
        modifier = modifier,
        shape = RoundedCornerShape(50)
    )
}