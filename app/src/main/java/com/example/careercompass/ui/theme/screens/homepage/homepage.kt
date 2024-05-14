package com.example.careercompass.ui.theme.screens.homepage

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.careercompass.R


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.careercompass.ui.theme.navigation.EVENTA_URL
import com.example.careercompass.ui.theme.navigation.EVENTV_URL
import com.example.careercompass.ui.theme.navigation.HOME_URL
import com.example.careercompass.ui.theme.navigation.ROUTE_INVITEA
import com.example.careercompass.ui.theme.navigation.ROUTE_INVITEV
import com.example.careercompass.ui.theme.navigation.ROUTE_RESOURCESA
import com.example.careercompass.ui.theme.navigation.ROUTE_RESOURCESV
import com.google.ai.client.generativeai.Chat
val Gensans= FontFamily(Font(R.font.gensans))

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun homescreen(navController: NavHostController) {
    Box(modifier =Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.homeback1),contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop

        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CenterAlignedTopAppBar(
            title = { Text("WELCOME",
                color = Color(0xF7F000FF),
                fontFamily = Gensans)
            },


            navigationIcon = {
                IconButton(onClick = { /* Handle profile icon click */ }) {
                    Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = "Profile")
                }
            },
            actions = {
                IconButton(onClick = { /* Handle chat icon click */ }) {
                    Icon(imageVector = Icons.Filled.Send, contentDescription = "Chat")

                }
            }

        )
        Spacer(modifier = Modifier.height(40.dp))

        Button(onClick = {
            navController.navigate(ROUTE_INVITEV)
        }, modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)) {
            Text(text = "AVAILABLE JOBS",
                color = Color(0xF7F000FF),
                fontFamily = Gensans,
                fontSize = 25.sp
            )
        }
        Spacer(modifier = Modifier.height(40.dp))

        Button(onClick = {
            navController.navigate(HOME_URL)
        }, modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)) {
            Text(text = "DISCOVER NEW PROFILES",
                color = Color(0xF7F000FF),
                fontFamily = Gensans,
                fontSize = 25.sp

            )
        }
        Spacer(modifier = Modifier.height(40.dp))

        Button(onClick = {
            navController.navigate(EVENTV_URL)
        }, modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
        ) {
            Text(text = "WEBINARS AND SEMINARS",
                color = Color(0xF7F000FF),
                fontFamily = Gensans,
                fontSize = 25.sp

            )
        }
        Spacer(modifier = Modifier.height(40.dp))

        Button(onClick = {
            navController.navigate(ROUTE_RESOURCESV)
        }, modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)) {
            Text(text = "AVAILABLE RESOURCES",
                color = Color(0xF7F000FF),
                fontFamily = Gensans,
                fontSize = 25.sp

            )
        }
        Spacer(modifier = Modifier.height(20.dp))





    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun home() {
    homescreen(navController = rememberNavController())}
