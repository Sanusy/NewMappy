package com.gmail.ivan.morozyk.mappy.navigation

interface NavigationManager {

    fun navigate(route: Route, singleTop: Boolean = false)
}