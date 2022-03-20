package com.gmail.ivan.morozyk.mappy.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gmail.ivan.morozyk.mappy.model.UserRepository
import com.gmail.ivan.morozyk.mappy.navigation.NavigationManager
import com.gmail.ivan.morozyk.mappy.navigation.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val userRepository: UserRepository,
) :
    ViewModel() {

    private val _uiState = mutableStateOf(SignInUiState("", ""))
    val uiState: State<SignInUiState>
        get() = _uiState

    fun onEmailChanged(email: String) {
        _uiState.value = _uiState.value.copy(email = email)
    }

    fun onPasswordChanged(password: String) {
        _uiState.value = _uiState.value.copy(password = password)
    }

    fun signInViaEmailAndPassword() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                userRepository.signInViewEmailAndPassword(
                    uiState.value.email, uiState.value.password
                )
            }
            navigationManager.navigate(Route.Splash)
        }

    }

    fun signInViaGoogle(googleSignInIdToken: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                userRepository.signInWithGoogle(googleSignInIdToken)
            }
            navigationManager.navigate(Route.Splash)
        }
    }

    fun signUp() {
        navigationManager.navigate(Route.SignUp)
    }
}

data class SignInUiState(val email: String, val password: String)