package com.gmail.ivan.morozyk.mappy.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gmail.ivan.morozyk.mappy.model.UserRepository
import com.gmail.ivan.morozyk.mappy.navigation.NavigationManager
import com.gmail.ivan.morozyk.mappy.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val userRepository: UserRepository,
) : ViewModel() {

    private val _uiState = mutableStateOf(SignUpUiState("", "", ""))
    val uiState: State<SignUpUiState>
        get() = _uiState

    fun onEmailChanged(email: String) {
        _uiState.value = _uiState.value.copy(email = email)
    }

    fun onPasswordChanged(password: String) {
        _uiState.value = _uiState.value.copy(password = password)
    }

    fun onNameChanged(name: String) {
        _uiState.value = _uiState.value.copy(name = name)
    }

    fun signUpViaEmailAndPassword() {
        viewModelScope.launch {

            with(uiState.value) {
                userRepository.addNewUserWithEmailAndPassword(
                    name = name,
                    email = email,
                    password = password
                )
            }

            navigationManager.navigate(Screen.Splash, singleTop = true)
        }
    }

    fun signUpViaGoogle() {

    }
}

data class SignUpUiState(val name: String, val email: String, val password: String)