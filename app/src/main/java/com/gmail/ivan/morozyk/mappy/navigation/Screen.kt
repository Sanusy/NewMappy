package com.gmail.ivan.morozyk.mappy.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
}
