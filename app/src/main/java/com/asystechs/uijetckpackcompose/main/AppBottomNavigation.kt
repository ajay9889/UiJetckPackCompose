package com.asystechs.uijetckpackcompose.main

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.asystechs.uijetckpackcompose.R

@Composable
fun AppBottomNavigation(
    navController: NavController
) {
    val navItem = listOf(
        NavItem.home,
        NavItem.Fave,
        NavItem.Feed,
        NavItem.Profile,
    )
    BottomNavigation(backgroundColor = colorResource(id = R.color.teal_200)) {
        navItem.forEach { item->
            val navBarStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute =navBarStackEntry?.destination?.route
            BottomNavigationItem(selected =  currentRoute == item.navRoute, onClick = {
              navController?.navigate(item.navRoute)
            }, icon = {
                Icon(painter = painterResource(id =item.icon) , contentDescription = "image")
            },
            label = {
                Text(text = stringResource(id = item.title))
            },
            selectedContentColor = Color.White,
            unselectedContentColor = Color.White.copy(0.4f)
            )
        }
    }
}