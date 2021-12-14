package com.gmail.ivan.morozyk.mappy.navigation

import androidx.navigation.NavController

interface NavigationProvider {

    fun attachNavController(navController: NavController)

    fun detachNavController()
}