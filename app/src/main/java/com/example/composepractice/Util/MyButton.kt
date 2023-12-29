package com.example.composepractice.Util

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice.R
import com.example.composepractice.ui.theme.Black
import com.example.composepractice.ui.theme.BlueGray
import com.example.composepractice.ui.theme.dimens


@Composable
fun MyButton(
    modifier: Modifier = Modifier,
    text: String,
    color: Color,
    colors: Color
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(MaterialTheme.dimens.buttonHeight),
        onClick = { /* TODO */ },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSystemInDarkTheme()) color else colors,
            contentColor = Color.White,
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            )
        )
    }
}