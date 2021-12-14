package com.gmail.ivan.morozyk.mappy.navigation

interface NavigationManager {

    fun navigate(screen: Screen, singleTop: Boolean = false)
}