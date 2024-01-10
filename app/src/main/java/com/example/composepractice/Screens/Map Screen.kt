package com.example.composepractice.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composepractice.Navigation.Screen
import com.example.composepractice.R
import java.util.Stack


@Composable
fun MapScreen(
    navController: NavController,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = if (isSystemInDarkTheme()) Color.Black else Color.White
    ) {
        val scrollState = rememberScrollState()
        val uiColor = if (isSystemInDarkTheme()) Color.Gray else Color.Black
        Box(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 30.dp)
                .verticalScroll(scrollState),
        ){
       Column(
           modifier = Modifier,
       ) {
           Row {
               Icon(
                   modifier = Modifier
                       .clickable {
                           navController.navigate(Screen.HomeScreen.route) {
                               popUpTo(Screen.HomeScreen.route) {
                                   inclusive = true
                               }
                           }
                       }
                       .padding(horizontal = 10.dp),
                   painter = painterResource(id = R.drawable.arrow_back),
                   contentDescription = null
               )
               Spacer(modifier = Modifier.width(10.dp))
               Text(
                   text = "Locate your Desired Hospital",
                   style = MaterialTheme.typography.headlineSmall,
                   color = uiColor
               )
           }
           Image(
               modifier = Modifier
                   .size(500.dp)
                   .fillMaxHeight(),
               painter = painterResource(id = R.drawable.map),
               contentDescription = null
           )
       }}
    }
}

@Preview
@Composable
fun MapScreenPreview() {
    MapScreen(navController = rememberNavController())
}