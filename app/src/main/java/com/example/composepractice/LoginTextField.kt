package com.example.composepractice

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.composepractice.ui.theme.focusedTextFieldText
import com.example.composepractice.ui.theme.textFieldContainer
import com.example.composepractice.ui.theme.unfocusedTextFieldText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginTextField(
    modifier: Modifier = Modifier,
    label: String,
    trailing: String
) {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    val textFieldColors = TextFieldDefaults.textFieldColors(
        unfocusedLabelColor = MaterialTheme.colorScheme.unfocusedTextFieldText,
        focusedLabelColor = MaterialTheme.colorScheme.focusedTextFieldText,
        unfocusedIndicatorColor = MaterialTheme.colorScheme.textFieldContainer,
        focusedIndicatorColor = MaterialTheme.colorScheme.textFieldContainer,
    )

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = "",
        onValueChange = {},
        label = {
            Text(text = label, color = uiColor, style = MaterialTheme.typography.labelMedium)
        },
        colors = textFieldColors,
        trailingIcon = {
            TextButton(onClick = { /*TODO*/ }) {
                Text(
                    text = trailing,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium),
                    color = uiColor
                )
            }
        }
    )
}
