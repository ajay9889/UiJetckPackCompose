@file:OptIn(ExperimentalMaterial3Api::class)

package com.asystechs.uijetckpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.asystechs.uijetckpackcompose.main.AppBottomNavigation
import com.asystechs.uijetckpackcompose.main.NavItem
import com.asystechs.uijetckpackcompose.main.navigation
import com.asystechs.uijetckpackcompose.ui.theme.UiJetckPackComposeTheme

//https://www.youtube.com/watch?v=_9eriTPdwsk&list=PLk7v1Z2rk4hiqKRfuVyhkdwNJ3bniUMJf&index=4
//https://developer.android.com/jetpack/compose/tutorial

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UiJetckPackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface (modifier = Modifier.fillMaxSize()) {
                    MainBottomNavigation( )
                }
            }
        }
    }
}

@Composable
fun MainBottomNavigation(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { AppBottomNavigation(navController = navController) },
    ){
        NavHost(navController = navController, startDestination = navigation.NAV_HOME.toString() ){
            composable(navigation.NAV_HOME.toString()){
                AppScreen("Home Screen")
            }
            composable(navigation.NAV_FAV.toString()){
                AppScreen("Fav Screen")
            }
            composable(navigation.NAV_FEED.toString()){
                AppScreen("Feed Screen")
            }
            composable(navigation.NAV_PROFILE.toString()){
                AppScreen("Profile Screen")
            }
        }
    }
}

@Composable
fun AppScreen(text : String) = Surface (modifier = Modifier.fillMaxSize()){
    Text(text, fontSize =32.sp)
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Surface (modifier = Modifier.fillMaxSize()) {
        MainBottomNavigation( )
    }
}