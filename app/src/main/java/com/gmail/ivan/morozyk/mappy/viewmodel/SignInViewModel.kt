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

    private val _emailState = mutableStateOf("")
    val emailState: State<String>
        get() = _emailState

    fun onEmailChanged(email: String) {
        _emailState.value = email
    }

    private val _passwordState = mutableStateOf("")
    val passwordState: State<String>
        get() = _passwordState

    fun onPasswordChanged(password: String) {
        _passwordState.value = password
    }

    fun signInViaEmailAndPassword() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                userRepository.signInViewEmailAndPassword(emailState.value, passwordState.value)
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