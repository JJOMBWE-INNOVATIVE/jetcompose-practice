package com.example.composepractice.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepractice.R
import com.example.composepractice.Util.MyButton
import com.example.composepractice.ui.theme.BlueGray
import com.example.composepractice.ui.theme.Roboto


@Composable
fun WelcomeScreen()
 {
 Surface {
     Column(
         modifier = Modifier
             .padding(horizontal = 10.dp, vertical = 30.dp)
             .fillMaxSize(),
         verticalArrangement = Arrangement.Top,
         horizontalAlignment = Alignment.Start
     ) {
         val uiColor = if (isSystemInDarkTheme()) Color.White else Color.Black
         Text(
             text = stringResource(id = R.string.Hospital),
             style = MaterialTheme.typography.headlineMedium,
             color = uiColor
         )
         Text(
             text = stringResource(id = R.string.Finder),
             style = MaterialTheme.typography.headlineSmall,
             color = uiColor
         )
         Spacer(modifier = Modifier.height(10.dp))
         Image(
             modifier = Modifier
                 .clip(CircleShape),
             painter = painterResource(id = R.drawable.hosp_building),
             contentDescription = null
         )
         Spacer(modifier = Modifier.height(10.dp))
         Text(
             text = "Find Hospitals",
             style = MaterialTheme.typography.headlineSmall,
             color = uiColor
         )
         Text(
             text = "Hospital Finder is the ultimate app for finding hospitals in your area." +
                     "It provides detailed information about the location, services and " +
                     "contact information of the hospitals around you ",
             style = MaterialTheme.typography.bodyLarge,
             color = uiColor
         )
         Spacer(modifier = Modifier.height(50.dp))
         MyButton(
             modifier = Modifier,
             text = "Find Hospitals",
             color = BlueGray,
             colors = Color(0xFF7801D5)

         )
         Spacer(modifier = Modifier.height(30.dp))
         CreateAccountWelcome()
     }
 }
}

@Composable
private fun ColumnScope.CreateAccountWelcome() {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Color.Black
    Text(
        modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color(0xFF64748B),
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Normal,
                    fontFamily = Roboto

                )
            ) {
                append("Already have an account? ")
            }
            withStyle(
                style = SpanStyle(
                    color = uiColor,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Medium,
                    fontFamily = Roboto

                )
            ) {
                append("")
                append("Sign in ")
            }
        })

}

@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen()
}
