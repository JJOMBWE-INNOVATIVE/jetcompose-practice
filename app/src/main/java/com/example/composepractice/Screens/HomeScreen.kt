    package com.example.composepractice.Screens

    import android.annotation.SuppressLint
    import androidx.compose.foundation.Image
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
    import androidx.compose.material3.Badge
    import androidx.compose.material3.BadgedBox
    import androidx.compose.material3.Button
    import androidx.compose.material3.Card
    import androidx.compose.material3.CardDefaults
    import androidx.compose.material3.ExperimentalMaterial3Api
    import androidx.compose.material3.Icon
    import androidx.compose.material3.MaterialTheme
    import androidx.compose.material3.NavigationBar
    import androidx.compose.material3.NavigationBarItem
    import androidx.compose.material3.Scaffold
    import androidx.compose.material3.Surface
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.saveable.rememberSaveable
    import androidx.compose.runtime.setValue
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.draw.clip
    import androidx.compose.ui.draw.shadow
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.graphics.Color.Companion.White
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import androidx.navigation.NavController
    import androidx.navigation.compose.rememberNavController
    import com.example.composepractice.Navigation.Screen
    import com.example.composepractice.R
    import com.example.composepractice.Util.MyHomeScreenCard
    import com.example.composepractice.Util.SocialMediaLogIn
    import com.example.composepractice.Util.UpdateCard
    import com.example.composepractice.Util.items
    import com.example.composepractice.ui.theme.MutedBlack
    import com.example.composepractice.ui.theme.cardGray

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun HomeScreen( navController : NavController) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = if (isSystemInDarkTheme()) Color.Black else Color.White
        ) {
            val scrollState = rememberScrollState()

            Box(
                modifier = Modifier
                    .fillMaxSize()


            ) {
                Column(

                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .padding(horizontal = 10.dp)
                            .verticalScroll(scrollState)

                        ,
                        horizontalAlignment = Alignment.Start
                    ) {
                        TopHome(navController)
                        Spacer(modifier = Modifier.height(10.dp))
                        ExploreServices(navController)
                        Spacer(modifier = Modifier.height(10.dp))
                        LatestNewsUpdates(navController)
                        Spacer(modifier = Modifier.height(10.dp))
                        ContactUs(navController)
                    }
                    BottomNavBar(navController)
                }

            }
        }
    }







    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    fun BottomNavBar(
        navController: NavController
    ) {
        var selectedItemIndex by rememberSaveable {
            mutableStateOf(0)
        }

        Box {
            NavigationBar(
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                            when (index) {
                                0 -> navController.navigate(Screen.HomeScreen.route)
                                1 -> navController.navigate(Screen.ActivityScreen.route)
                                2 -> navController.navigate(Screen.NewsScreen.route)
                                3 -> navController.navigate(Screen.MapScreen.route)
                                4 -> navController.navigate(Screen.HospitalInfo.route)
                            }
                        },
                        label = { Text(text = item.title) },
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (item.badgeCount != null) {
                                        Badge {
                                            Text(text = item.badgeCount.toString())
                                        }
                                    } else if (item.hasNews) {
                                        Badge()
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = if (selectedItemIndex == index)
                                        item.selectedIcon else item.unselectedIcon,
                                    contentDescription = item.title
                                )
                            }
                        }
                    )
                }
            }
        }
    }




    @Composable
    private fun ContactUs(
        navController : NavController
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
                    text = "Contact Us",
                    color = if (isSystemInDarkTheme()) White else Color.Black,
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
                                        text = "24/7 Support",
                                        color = if (isSystemInDarkTheme()) White else Color.Black,
                                        fontSize = 17.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                    Spacer(modifier = Modifier.height(20.dp))
                                    Button(onClick = { /*TODO*/ }) {
                                        Text(text = "Call")
                                    }
                                }
                                Spacer(modifier = Modifier.width(10.dp))
                                Image(
                                    painter = painterResource(id = R.drawable.contact_mail),
                                    contentDescription = null
                                )
                            }

                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun LatestNewsUpdates(
        navController : NavController
    ) {
        Text(
            text = "Latest News & Updates",
            color = if (isSystemInDarkTheme()) White else Color.Black,
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            UpdateCard(
                image = R.drawable.hospital_events,
                text = "Hospital\n Events"
            )
            UpdateCard(
                image = R.drawable.hospital_annnouncements,
                text = "Hospital \n Announcements"
            )

        }
    }


    @Composable
    private fun ExploreServices(
        navController : NavController
    ) {
        Text(
            text = "Explore Our Services",
            color = if (isSystemInDarkTheme()) Color.White else Color.Black,
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SocialMediaLogIn(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .weight(1f),
                icon = R.drawable.medical_services,
                text = "Medical \n Services",
                onClick = { /*TODO*/ }
            )
            Spacer(modifier = Modifier.width(20.dp))
            SocialMediaLogIn(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .weight(1f),
                icon = R.drawable.ambulance,
                text = "Emergency \n Services",
                onClick = { /*TODO*/ }
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SocialMediaLogIn(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .weight(1f),
                icon = R.drawable.accident,
                text = "Accident \n Services",
                onClick = { /*TODO*/ }
            )
            Spacer(modifier = Modifier.width(20.dp))
            SocialMediaLogIn(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .weight(1f),
                icon = R.drawable.special_services,
                text = "Speciality \n Services",
                onClick = { /*TODO*/ }
            )
        }
    }

    @Composable
    private fun TopHome(
        navController : NavController
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val uiColor = if (isSystemInDarkTheme()) Color.Gray else Color.Black
            Text(
                text = "Welcome To HospitalFinder,",
                style = MaterialTheme.typography.headlineMedium,
                color = uiColor
            )
            Spacer(modifier = Modifier.height(20.dp))
            MyHomeScreenCard(
                image = R.drawable.elephant,
                modifier = Modifier.padding(10.dp),
                title = "Find The Best Hospitals Near"
            )
        }
    }

    @Preview
    @Composable
    fun HomeScreenPreview(){
        HomeScreen(navController = rememberNavController())
    }
