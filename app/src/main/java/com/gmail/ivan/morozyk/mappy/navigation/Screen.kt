package com.gmail.ivan.morozyk.mappy.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object SignIn : Screen("sign_in")
    object SignUp : Screen("sign_up")
}
