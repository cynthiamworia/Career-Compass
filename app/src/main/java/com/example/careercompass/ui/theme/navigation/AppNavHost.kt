package com.example.careercompass.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.careercompass.ui.theme.screens.events.AddEventsScreen
import com.example.careercompass.ui.theme.screens.events.ViewEventsScreen
import com.example.careercompass.ui.theme.screens.homepage.homescreen
import com.example.careercompass.ui.theme.screens.invites.AddInvitesScreen
import com.example.careercompass.ui.theme.screens.invites.ViewInvitesScreen
import com.example.careercompass.ui.theme.screens.login.LoginScreen
import com.example.careercompass.ui.theme.screens.register.SignupScreen
import com.example.careercompass.ui.theme.screens.resourcess.AddResourcesScreen
import com.example.careercompass.ui.theme.screens.resourcess.ViewResourcesScreen
import com.example.careercompass.ui.theme.screens.splash.SplashScreen

@Composable
fun AppNavhost(modifier: Modifier = Modifier,
               navController: NavHostController = rememberNavController(),
               startDestination: String= ROUTE_SPLASH)
{
    NavHost(navController=navController, modifier = Modifier, startDestination =startDestination){
        composable(ROUTE_SPLASH){
            SplashScreen(navController )


        }
        composable(HOME_URL){
            homescreen(navController )


        }
        composable(LOGIN_URL){
            LoginScreen(navController )
        }
        composable(SIGNUP_URL){
            SignupScreen(navController )
        }
        composable(EVENTA_URL){
            AddEventsScreen(navController )
        }
        composable(EVENTV_URL){
            ViewEventsScreen(navController )
        }
        composable(ROUTE_RESOURCESA){
            AddResourcesScreen(navController )
        }
        composable(ROUTE_RESOURCESV){
            ViewResourcesScreen(navController )
        }
        composable(ROUTE_INVITEA){
            AddInvitesScreen(navController )
        }
        composable(ROUTE_INVITEV){
            ViewInvitesScreen(navController )
        }}}
