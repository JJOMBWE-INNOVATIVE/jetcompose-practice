package com.example.composepractice.Util


import androidx.annotation.DrawableRes
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice.R
import com.example.composepractice.ui.theme.MutedBlack
import com.example.composepractice.ui.theme.cardGray


@Composable
fun MyHomeScreenCard(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    title: String,


    ) {


    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .shadow(10.dp)
            .animateContentSize(),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(
        containerColor = if (isSystemInDarkTheme()) MutedBlack else cardGray,
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Column(
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(10.dp)
                    .clip(MaterialTheme.shapes.extraLarge),
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .padding(
                        vertical = 20.dp,
                        horizontal = 15.dp
                    )
            ){
                Text(
                    text = title,
                    color = if(isSystemInDarkTheme()) White else Black,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium
                )


            }
        }
    }
}

@Preview
@Composable
fun MyHomeScreenCardPreview(){
    MyHomeScreenCard(
        image = R.drawable.elephant,
        title = "Find The Best Hospitals Near"
    )
}