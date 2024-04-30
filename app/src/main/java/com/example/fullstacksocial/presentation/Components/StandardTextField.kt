package com.example.fullstacksocial.presentation.Components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import com.example.fullstacksocial.R

@Composable
fun StandardTextField(
    text : String = "",
    hint : String = "",
    error: String = "",
    maxLength: Int = 50,
    showPasswordToggle: Boolean = false,
    onPasswordToggleClick : (Boolean) -> Unit = {},
    keyboardType: KeyboardType = KeyboardType.Text,
    onValueChanged: (String) -> Unit
) {

    val isPasswordToggleDisplayed by remember {
        mutableStateOf(keyboardType == KeyboardType.Password)
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = text,
            onValueChange = {
                if (it.length <= maxLength) {
                    onValueChanged(it)
                }
            },
            placeholder = {
                Text(text = hint, style = MaterialTheme.typography.bodyLarge)
            },
            isError = error != "",
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            visualTransformation = if (isPasswordToggleDisplayed && !showPasswordToggle){
                PasswordVisualTransformation()
            }else {
                VisualTransformation.None
            },
            singleLine = true,
            trailingIcon = {
                if (isPasswordToggleDisplayed) {
                    IconButton(onClick = {
                        onPasswordToggleClick(!showPasswordToggle)
                    }) {
                        Icon(
                            imageVector = if (showPasswordToggle) {
                                Icons.Filled.Visibility
                            }else {
                                Icons.Filled.VisibilityOff
                            },
                            contentDescription = if (showPasswordToggle) {
                                stringResource(id = R.string.password_visible_content_description)
                            }else{
                                stringResource(id = R.string.password_hidden_content_description   )
                            }
                        )
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
        if (error.isNotEmpty()) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = error,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.End
                )
        }
    }
}