package com.gmail.ivan.morozyk.mappy.viewmodel

import androidx.lifecycle.ViewModel
import com.gmail.ivan.morozyk.mappy.model.UserRepository
import com.gmail.ivan.morozyk.mappy.navigation.NavigationManager
import com.gmail.ivan.morozyk.mappy.navigation.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MapListViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val userRepository: UserRepository,
) : ViewModel() {

    fun signOut() {
        userRepository.signOut()
        navigationManager.navigate(Route.Splash)
    }
}
