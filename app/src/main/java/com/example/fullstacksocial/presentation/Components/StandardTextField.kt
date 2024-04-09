package com.example.fullstacksocial.presentation.Components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.widget.Placeholder

@Composable
fun StandarTextField(
    text : String,
    hint : String,
    onValueChanged: (String) -> Unit
) {
    TextField(
        value = text,
        onValueChange = onValueChanged,
        placeholder = {
            Text(text = hint, style = MaterialTheme.typography.bodyLarge)
        },
        modifier = Modifier.fillMaxWidth()
    )
}