package com.example.composepractice.Screens

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composepractice.Navigation.Screen
import com.example.composepractice.R
import com.example.composepractice.ui.theme.ActivityCard
import com.example.composepractice.ui.theme.HospCard
import com.example.composepractice.ui.theme.MutedBlack
import com.example.composepractice.ui.theme.cardGray


@Composable
fun HospitalInfo(
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
              modifier = Modifier
              ,
              horizontalAlignment = Alignment.CenterHorizontally,
              verticalArrangement = Arrangement.Center
          ) {

          Row(
              modifier = Modifier.fillMaxWidth(),
              verticalAlignment = Alignment.CenterVertically,
              ) {
                  Icon(
                      modifier = Modifier.clickable {
                          navController.navigate(Screen.HomeScreen.route) {
                              popUpTo(Screen.HomeScreen.route) {
                                  inclusive = true
                              }
                          }
                      },
                      painter = painterResource(id = R.drawable.arrow_back),
                      contentDescription = null
                  )
                  Spacer(modifier = Modifier.width(10.dp))
                  Text(
                      text = "Hospital Information",
                      style = MaterialTheme.typography.headlineSmall,
                      color = uiColor
                  )
              }
              Spacer(modifier = Modifier.height(20.dp))
              HospitalCard(navController)
              Spacer(modifier = Modifier.height(20.dp))
              Text(
                  text = "Services Available",
                  color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                  fontSize = 22.sp,
                  fontWeight = FontWeight.Medium
              )
              Spacer(modifier = Modifier.height(20.dp))
              HopspitalInfoCards(navController)
          }
        }
    }
}

@Composable
fun HopspitalInfoCards( navController: NavController,) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        HospCard(
            image = R.drawable.spc,
            text = "Speciality Clinics"
        )
        Spacer(modifier = Modifier.width(10.dp))
        HospCard(
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
        HospCard(
            image = R.drawable.appoint,
            text = "Appointments"
        )
        Spacer(modifier = Modifier.width(10.dp))
        HospCard(
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
        HospCard(
            image = R.drawable.counselling,
            text = "Counselling Centers"
        )
        Spacer(modifier = Modifier.width(10.dp))
        HospCard(
            image = R.drawable.laboratories,
            text = "Speciality Laboratories"
        )

    }
}

@Composable

 private fun HospitalCard(
    navController: NavController,
 ) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(10.dp)
            .padding(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSystemInDarkTheme()) MutedBlack else cardGray
        ),
        // elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Column(
            modifier = Modifier.height(130.dp)
        ) {
            Text(
                text = "Current Hospital:",
                color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium
            )
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .height(100.dp),

                ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Column(

                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(
                                    text = "St John Hospital",
                                    color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Medium
                                )
                                Spacer(modifier = Modifier.height(20.dp))
                                Button(onClick = { /*TODO*/ }) {
                                    Text(text = "Find More")
                                }
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Image(
                                modifier = Modifier.clip(RoundedCornerShape(10.dp)),
                                painter = painterResource(id = R.drawable.hosp),
                                contentDescription = null
                            )

                        }

                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun HospitalInfoPreview() {
    HospitalInfo( navController = rememberNavController() )
}