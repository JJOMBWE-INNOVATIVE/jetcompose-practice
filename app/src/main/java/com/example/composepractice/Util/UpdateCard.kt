package com.example.composepractice.Util

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice.R


@Composable
fun UpdateCard(
    modifier: Modifier = Modifier,
    @DrawableRes  image: Int,
    text: String,

) {
    Column(
    ) {
        Card(
            modifier = Modifier
                .shadow(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (isSystemInDarkTheme()) Color.Black else Color.White
            ),

            ) {

            Card(
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (isSystemInDarkTheme()) Color.Black else Color.White
                ),


                ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(
                            color = if (isSystemInDarkTheme()) Color.Black else Color.White,
                            shape = CircleShape
                        )
                        .shadow(50.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier
                            .size(100.dp)
                            .padding(15.dp),
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = image),
                        contentDescription = null
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = text,
            color = if (isSystemInDarkTheme()) Color.White else Color.Black,
            fontSize = 17.sp,
            fontWeight = FontWeight.Medium
        )
    }
}