package com.wilvelpinedanavarro.deliveryapp.signin.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RoundedButton(text: String, onClick: () -> Unit, enabled: Boolean){
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color(54,178,185),
            disabledContentColor = Color(31,38,54),
            containerColor = Color(221,87,61),
            disabledContainerColor = Color(154,167,171)
        )
    ) {
        Text(text = text)
    }
}