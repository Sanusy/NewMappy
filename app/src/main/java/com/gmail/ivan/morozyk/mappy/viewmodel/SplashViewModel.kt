package com.gmail.ivan.morozyk.mappy.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gmail.ivan.morozyk.mappy.model.UserRepository
import com.gmail.ivan.morozyk.mappy.navigation.NavigationManager
import com.gmail.ivan.morozyk.mappy.navigation.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val userRepository: UserRepository,
) : ViewModel() {

    fun checkAuthorization() {
        viewModelScope.launch {

            val user = userRepository.getCurrentUser()

            when (user) {
                null -> navigationManager.navigate(Route.SignIn, singleTop = true)
                else -> Log.d("TAG", "checkAuthorization: Logged in: $user")
            }
        }
    }
}