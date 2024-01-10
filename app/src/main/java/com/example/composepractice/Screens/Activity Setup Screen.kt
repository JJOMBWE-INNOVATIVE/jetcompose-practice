package com.example.composepractice.Screens

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composepractice.Navigation.Screen
import com.example.composepractice.R
import com.example.composepractice.States.rememberImeState
import com.example.composepractice.ui.theme.ActivityCard


@Composable
fun ActivityScreen(
    navController: NavController
) {
      Surface(
          modifier = Modifier.fillMaxSize(),
          color = if (isSystemInDarkTheme()) Color.Black else Color.White
      ) {
          val scrollState = rememberScrollState()
         Box(
             modifier = Modifier
                 .padding(horizontal = 10.dp, vertical = 30.dp)
                 .verticalScroll(scrollState),
         )
         {
            Column(
                modifier = Modifier
                        ,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                searchFields(navController)
                Spacer(modifier = Modifier.height(30.dp))
                ActivityCards(navController)
            }
         }
      }
}

@Composable
private fun searchFields(
    navController: NavController
) {
    val uiColor = if (isSystemInDarkTheme()) Color.Gray else Color.Black
    var text by rememberSaveable {
        mutableStateOf("")
    }


    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
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
        Text(
            text = "Find a Hospital",
            style = MaterialTheme.typography.headlineLarge,
            color = uiColor
        )
    }
    Spacer(modifier = Modifier.height(50.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = {text = it},
            shape = RoundedCornerShape(20.dp),
            placeholder = { Text(
                text = "Search For Hospital",
                style = MaterialTheme.typography.bodyLarge,
                color = uiColor
            ) },
            modifier = Modifier
                .height(55.dp)
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary, shape = CircleShape)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null
            )
        }
    }
}

@Composable
private fun ActivityCards(
    navController: NavController
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ActivityCard(
            image = R.drawable.spc,
            text = "Speciality Clinics"
        )
        Spacer(modifier = Modifier.width(10.dp))
        ActivityCard(
            image = R.drawable.pham,
            text = "Pharmacies"
        )
    }
    Spacer(modifier = Modifier.height(10.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ActivityCard(
            image = R.drawable.appoint,
            text = "Appointments"
        )
        Spacer(modifier = Modifier.width(10.dp))
        ActivityCard(
            image = R.drawable.wellness,
            text = "Wellness Centers"
        )

    }
    Spacer(modifier = Modifier.height(10.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ActivityCard(
            image = R.drawable.counselling,
            text = "Counselling Centers"
        )
        Spacer(modifier = Modifier.width(10.dp))
        ActivityCard(
            image = R.drawable.laboratories,
            text = "Speciality Laboratories"
        )

    }
}


@Preview
@Composable
fun ActivityScreenPreview(){
    ActivityScreen(navController = rememberNavController())
}