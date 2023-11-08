package com.asystechs.uijetckpackcompose.ui.theme

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun MainContent( ) {
    val navController  = rememberNavController()
    Surface (
        modifier =  Modifier.fillMaxSize()
    ) {
        NavHost(navController = navController,
            startDestination ="home"){
            composable("home"){
                Home("task", navController )
            }

            // medetory argument
//                .. default argument
            composable("task?item={item}" ,
                arguments = listOf(navArgument("item"){
                    type = NavType.StringType
                    defaultValue = "Not Found"
                })
            ){
                it.arguments?.getString("item")?.let{
                    Task(it)
                }

            }
        }
    }

}
@Preview
@Composable
fun MainContentPreview() {
    MainContent()
}