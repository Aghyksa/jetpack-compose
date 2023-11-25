package com.genshin.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Profile : Screen("profile")
    object DetailCharacter : Screen("home/{name}") {
        fun createRoute(name:String) = "home/$name"
    }
}