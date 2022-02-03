package com.gmail.ivan.morozyk.mappy.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.DisposableEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gmail.ivan.morozyk.mappy.navigation.NavigationProvider
import com.gmail.ivan.morozyk.mappy.navigation.Route
import com.gmail.ivan.morozyk.mappy.ui.screen.MapListScreen
import com.gmail.ivan.morozyk.mappy.ui.screen.SignInScreen
import com.gmail.ivan.morozyk.mappy.ui.screen.SignUpScreen
import com.gmail.ivan.morozyk.mappy.ui.screen.SplashScreen
import com.gmail.ivan.morozyk.mappy.ui.theme.MappyTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationProvider: NavigationProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MappyTheme {

                val navController = rememberNavController()

                navigationProvider.attachNavController(navController)

                NavHost(navController = navController, startDestination = Route.Splash.name) {
                    composable(Route.Splash.name) {
                        SplashScreen(splashViewModel = hiltViewModel())
                    }
                    composable(Route.SignIn.name) {
                        SignInScreen(signInViewModel = hiltViewModel())
                    }
                    composable(Route.SignUp.name) {
                        SignUpScreen(signUpViewModel = hiltViewModel())
                    }
                    composable(Route.MapList.name) {
                        MapListScreen(viewModel = hiltViewModel())
                    }
                }
            }

            DisposableEffect(null) {
                onDispose {
                    navigationProvider.detachNavController()
                }
            }
        }
    }
}