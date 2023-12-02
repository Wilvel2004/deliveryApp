package com.wilvelpinedanavarro.deliveryapp.signup.ui.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldEmail(
    value: String,
    onTextChanged: (String) -> Unit,
    placeholder: String
) {
    TextField(value = value,
        onValueChange = {onTextChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = placeholder) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(221,87,61),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            containerColor = Color(244,154,67)
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldName(
    value: String,
    onTextChanged: (String) -> Unit,
    placeholder: String
) {
    TextField(value = value,
        onValueChange = {onTextChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = placeholder) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(221,87,61),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            containerColor = Color(244,154,67)
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldPassword(
    value: String,
    onTextChanged: (String) -> Unit,
    placeholder: String
) {
    TextField(value = value,
        onValueChange = {onTextChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = placeholder) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(54,178,185),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            containerColor = Color(244,154,67)
        )
    )
}