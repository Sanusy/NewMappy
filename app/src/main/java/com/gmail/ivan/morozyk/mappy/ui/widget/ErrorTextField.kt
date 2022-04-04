package com.gmail.ivan.morozyk.mappy.ui.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun ErrorTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    leadingIcon: (@Composable () -> Unit)? = null,
    label: (@Composable () -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    singleLine: Boolean = false,
    errorText: String? = null
) {
    Column {
        TextField(
            modifier = modifier,
            value = value,
            onValueChange = onValueChange,
            leadingIcon = leadingIcon,
            label = label,
            keyboardOptions = keyboardOptions,
            visualTransformation = visualTransformation,
            singleLine = singleLine,
            isError = errorText != null
        )
        errorText?.let {
            Text(text = it, modifier = modifier, color = Color.Red)
        }
    }
}