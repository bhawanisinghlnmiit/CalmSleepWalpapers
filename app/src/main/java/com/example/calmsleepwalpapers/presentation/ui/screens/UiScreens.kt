package com.example.calmsleepwalpapers.presentation.ui.screens

sealed class UiScreens(val route : String){
    object Welcome : UiScreens(route = "welcome_screen")
    object Home : UiScreens(route = "home_screen")
}
