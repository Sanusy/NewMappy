package com.gmail.ivan.morozyk.mappy.navigation

import androidx.navigation.NavController

interface ComposeNavigationProvider {

    fun attachNavController(navController: NavController)

    fun detachNavController()
}