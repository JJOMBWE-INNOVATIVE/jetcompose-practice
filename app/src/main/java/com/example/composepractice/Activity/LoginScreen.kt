package com.example.composepractice.Activity

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepractice.R
import com.example.composepractice.States.rememberImeState
import com.example.composepractice.Util.LoginTextField
import com.example.composepractice.Util.SocialMediaLogIn
import com.example.composepractice.ui.theme.Black
import com.example.composepractice.ui.theme.BlueGray
import com.example.composepractice.ui.theme.ComposePracticeTheme
import com.example.composepractice.ui.theme.Roboto
import com.example.composepractice.ui.theme.ScreenOrientation
import com.example.composepractice.ui.theme.dimens


@Composable
fun LoginScreen() {
    Surface{
        if(ScreenOrientation == Configuration.ORIENTATION_PORTRAIT){
            PortraitLoginScreen()
        }
        else{
            LandScapeLoginScreen()
        }
    }
}

@Composable
private fun LandScapeLoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),
        verticalArrangement = Arrangement.Center
    ) {
        LogInSection()
        Spacer(modifier = Modifier.height(MaterialTheme.dimens.medium1))
        SocialMediaSection()
    }
}

@Composable
private fun PortraitLoginScreen() {
    val imeState = rememberImeState()
    val scrollState = rememberScrollState()
    LaunchedEffect(
        key1 = imeState.value,
    ){
        if (imeState.value){
            scrollState.animateScrollTo(scrollState.maxValue, tween(300) )
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),


    ) {
        TopSection()
        Spacer(modifier = Modifier.height(MaterialTheme.dimens.medium2))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {
            LogInSection()
            Spacer(modifier = Modifier.height(MaterialTheme.dimens.medium1))
            SocialMediaSection()

        }
        Spacer(modifier = Modifier.weight(0.8f))
        CreateAccount()
        Spacer(modifier = Modifier.weight(0.8f))
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
private fun ColumnScope.CreateAccount() {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Color.Black
        Text(
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color(0xFF64748B),
                    fontSize = MaterialTheme.typography.labelMedium.fontSize,
                    fontWeight = FontWeight.Normal,
                    fontFamily = Roboto

                )
            ) {
                append("Don't have an account? ")
            }
            withStyle(
                style = SpanStyle(
                    color = uiColor,
                    fontSize = MaterialTheme.typography.labelMedium.fontSize,
                    fontWeight = FontWeight.Medium,
                    fontFamily = Roboto

                )
            ) {
                append("")
                append("Create Now ")
            }
        })

}

@Composable
private fun SocialMediaSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "or Continue with",
            style = MaterialTheme.typography
                .labelMedium.copy(color = Color(0xFF64748B))
        )
        Spacer(modifier = Modifier.height(MaterialTheme.dimens.small3))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SocialMediaLogIn(
                modifier = Modifier.weight(1f),
                icon = R.drawable.facebook,
                text = "Facebook",
                onClick = { /*TODO*/ }
            )
            Spacer(modifier = Modifier.width(20.dp))
            SocialMediaLogIn(
                modifier = Modifier.weight(1f),
                icon = R.drawable.google,
                text = "Google",
                onClick = { /*TODO*/ }
            )
        }

    }
}

@Composable
private fun LogInSection() {
    LoginTextField(
        modifier = Modifier.fillMaxWidth(),
        label = "Email",
        trailing = ""
    )
    Spacer(modifier = Modifier.height(MaterialTheme.dimens.small2))
    LoginTextField(
        modifier = Modifier.fillMaxWidth(),
        label = "Password",
        trailing = "Forgot?"
    )
    Spacer(modifier = Modifier.height(MaterialTheme.dimens.small3))
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(MaterialTheme.dimens.buttonHeight),
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSystemInDarkTheme()) BlueGray else Black,
            contentColor = Color.White,
        ),
        shape = RoundedCornerShape(size = 4.dp)
    ) {
        Text(
            text = stringResource(id = R.string.login),
            style =
            MaterialTheme.typography
                .labelMedium.copy(fontWeight = FontWeight.Medium),
        )

    }
}

@Composable
private fun TopSection() {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Color.Black
    val screenHeight = LocalConfiguration.current.screenHeightDp
    Box(
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            modifier = Modifier
                .height((screenHeight / 2.12).dp)
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.shape),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Row(
            modifier = Modifier.padding(top = (screenHeight/9).dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(MaterialTheme.dimens.logoSize),
                painter = painterResource(id = R.drawable.locator),
                contentDescription = stringResource(id = R.string.app_logo),
                tint = uiColor
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text(
                    text = stringResource(id = R.string.JNORIGINS),
                    style = MaterialTheme.typography.headlineMedium,
                    color = uiColor
                )
                Text(
                    text = stringResource(id = R.string.Find),
                    style = MaterialTheme.typography.titleMedium,
                    color = uiColor
                )
            }

        }

    Text(
        modifier = Modifier
            .padding(bottom = 10.dp)
            .align(alignment = Alignment.BottomCenter),
        text = stringResource(id = R.string.login),
        style = MaterialTheme.typography.headlineLarge,
        color = uiColor
    )
}
}


@Preview
@Composable
fun LoginScreenPreview() {
    ComposePracticeTheme {
        LoginScreen()
    }
}