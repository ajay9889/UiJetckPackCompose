package com.asystechs.uijetckpackcompose.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.asystechs.uijetckpackcompose.R

sealed class NavItem (
     @StringRes val title: Int,
     @DrawableRes val icon: Int,
    val navRoute : String
){
    object home: NavItem(R.string.home , android.R.drawable.ic_input_add ,  navigation.NAV_HOME.toString())
    object Fave: NavItem(R.string.fav , android.R.drawable.ic_dialog_info ,  navigation.NAV_FAV.toString())
    object Feed: NavItem(R.string.feed , android.R.drawable.ic_input_get ,  navigation.NAV_FEED.toString())
    object Profile: NavItem(R.string.profile , android.R.drawable.ic_secure ,  navigation.NAV_PROFILE.toString())

}

enum class navigation{
    NAV_FAV,
    NAV_FEED,
    NAV_HOME,
    NAV_PROFILE
}