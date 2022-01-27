package com.gmail.ivan.morozyk.mappy.navigation

sealed class Route(val name: String) {
    object Splash : Route("splash")
    object SignIn : Route("sign_in")
    object SignUp : Route("sign_up")
}
