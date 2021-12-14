package com.gmail.ivan.morozyk.mappy.navigation

import androidx.navigation.NavController
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator @Inject constructor() : NavigationManager, NavigationProvider {

    private var navController: NavController? = null

    override fun attachNavController(navController: NavController) {
        this.navController = navController
    }

    override fun detachNavController() {
        navController = null
    }

    override fun navigate(screen: Screen, singleTop: Boolean) {
        navController?.navigate(screen.route) {
            launchSingleTop = singleTop
        }
    }
}