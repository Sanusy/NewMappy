package com.gmail.ivan.morozyk.mappy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gmail.ivan.morozyk.mappy.navigation.ComposeNavigationProvider
import com.gmail.ivan.morozyk.mappy.navigation.Screen
import com.gmail.ivan.morozyk.mappy.ui.theme.MappyTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationProvider: ComposeNavigationProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MappyTheme {

                val navController = rememberNavController()
                navigationProvider.attachNavController(navController)

                NavHost(navController = navController, startDestination = Screen.Login.route) {
                    composable(Screen.Login.route) {
                        LoginScreen()
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

@Composable
fun LoginScreen() {
    Text("Login Screen")
}