package com.example.composepractice.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composepractice.Navigation.Screen
import com.example.composepractice.R
import com.example.composepractice.ui.theme.cardGray


@Composable
fun NewsScreen(
    navController: NavController
) {
       Surface (
           modifier = Modifier.fillMaxSize(),
           color = if (isSystemInDarkTheme()) Color.Black else Color.White
       ){

           val scrollState = rememberScrollState()
           val uiColor = if (isSystemInDarkTheme()) Color.Gray else Color.Black

           Box(
               modifier = Modifier
                   .padding(horizontal = 10.dp, vertical = 30.dp)
                   .verticalScroll(scrollState),
           ) {
               Column(
                   modifier = Modifier,
                   horizontalAlignment = Alignment.CenterHorizontally,
                   verticalArrangement = Arrangement.Center
               ) {
                   TopPart( navController)
                   Spacer(modifier = Modifier.height(30.dp))
                   Newscard(navController)
                   Spacer(modifier = Modifier.height(10.dp))
                   Newscard(navController)
                   Spacer(modifier = Modifier.height(10.dp))
                   Newscard(navController)
                   Spacer(modifier = Modifier.height(10.dp))
                   Newscard(navController)
                   Spacer(modifier = Modifier.height(10.dp))
                   Newscard(navController)
                   Spacer(modifier = Modifier.height(10.dp))
                   Newscard(navController)
               }
           }
       }
}

@Composable
private fun Newscard(
    navController: NavController,
    ) {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Color.Black
    Card(
        modifier = Modifier
            .height(100.dp)
            .clip(RoundedCornerShape(30.dp)),
        colors = CardDefaults.cardColors(cardGray),
        elevation = CardDefaults.cardElevation(10.dp)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Card(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape),
                ) {
                    Image(
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.CenterHorizontally),
                        painter = painterResource(id = R.drawable.profile_pic),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = "Latest Hospital News",
                        color = uiColor
                    )
                    Text(
                        text = "New Hospital services ",
                        color = uiColor
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Card(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape),
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.CenterHorizontally),
                        painter = painterResource(id = R.drawable.ambulance),
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Composable
private fun TopPart(
    navController: NavController,
) {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Color.Black
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            modifier = Modifier
                .clickable {
                    navController.navigate(Screen.HomeScreen.route){
                        popUpTo(Screen.HomeScreen.route){
                            inclusive = true
                        }
                    }
                }
                .padding(horizontal = 10.dp),
            painter = painterResource(id = R.drawable.arrow_back),
            contentDescription = null
        )
        Card(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
        ) {
            Icon(
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.ambulance),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = "Latest Hospital News",
            style = MaterialTheme.typography.headlineSmall,
            color = uiColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NewsScreenPreview() {
    NewsScreen(navController = rememberNavController())
}