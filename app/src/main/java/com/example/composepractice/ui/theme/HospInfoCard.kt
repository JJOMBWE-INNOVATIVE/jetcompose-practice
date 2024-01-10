package com.example.composepractice.ui.theme


import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice.R


@Composable
fun HospCard(
    modifier: Modifier = Modifier,
    @DrawableRes  image: Int,
    text: String,

    ) {
    Column(
    ) {
        Card(
            modifier = Modifier
                .width(150.dp)
                .height(150.dp)
                .padding(10.dp)
                .align(Alignment.CenterHorizontally)
                .shadow(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (isSystemInDarkTheme()) Color.Black else Color.White
            ),

            ) {

            Card(
                modifier = Modifier
                    .size(150.dp)
                    .padding(10.dp)
                    .align(Alignment.CenterHorizontally),
                colors = CardDefaults.cardColors(
                    containerColor = if (isSystemInDarkTheme()) Color.Black else cardGray
                ),


                ) {
                Image(
                    modifier = Modifier
                        .size(200.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .align(Alignment.CenterHorizontally)
                        .padding(15.dp),

                    painter = painterResource(id = image),
                    contentDescription = null
                )

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

@Preview(showBackground = true)
@Composable
fun HospCardPreview() {
    HospCard(
        image = R.drawable.spc,
        text = "Contact Us"
    )
}