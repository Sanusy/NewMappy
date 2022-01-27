package com.gmail.ivan.morozyk.mappy.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.gmail.ivan.morozyk.mappy.navigation.NavigationManager
import com.gmail.ivan.morozyk.mappy.navigation.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val navigationManager: NavigationManager) :
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

    fun logInViaEmailAndPassword() {

    }

    fun logInViaGoogle() {

    }

    fun signUp() {
        navigationManager.navigate(Route.SignUp)
    }
}