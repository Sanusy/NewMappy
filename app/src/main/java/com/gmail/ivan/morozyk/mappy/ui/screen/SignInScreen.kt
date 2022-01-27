package com.gmail.ivan.morozyk.mappy.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gmail.ivan.morozyk.mappy.R
import com.gmail.ivan.morozyk.mappy.navigation.NavigationManager
import com.gmail.ivan.morozyk.mappy.navigation.Route
import com.gmail.ivan.morozyk.mappy.ui.theme.MappyTheme
import com.gmail.ivan.morozyk.mappy.viewmodel.SignInViewModel

@Composable
fun SignInScreen(signInViewModel: SignInViewModel) {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = stringResource(id = R.string.app_name)) })
    }) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth(),
                value = signInViewModel.emailState.value,
                onValueChange = signInViewModel::onEmailChanged,
                leadingIcon = { Icon(Icons.Default.Email, null) },
                label = { Text(stringResource(id = R.string.sign_in_screen_enter_email)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                singleLine = true,
            )

            TextField(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth(),
                value = signInViewModel.passwordState.value,
                onValueChange = signInViewModel::onPasswordChanged,
                leadingIcon = { Icon(Icons.Default.Lock, null) },
                label = { Text(stringResource(id = R.string.sign_in_screen_enter_password)) },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Button(
                modifier = Modifier.padding(8.dp),
                onClick = signInViewModel::logInViaEmailAndPassword
            ) {
                Text(text = stringResource(id = R.string.sign_in_screen_sign_in))
            }

            IconButton(
                modifier = Modifier.padding(8.dp),
                onClick = signInViewModel::logInViaGoogle
            ) {
                Image(
                    painterResource(id = R.drawable.googleg_standard_color_18),
                    contentDescription = null
                )
            }

            Button(
                modifier = Modifier.padding(8.dp),
                onClick = signInViewModel::signUp,
            ) {
                Text(text = stringResource(id = R.string.sign_in_screen_sign_up))
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    MappyTheme {
        SignInScreen(signInViewModel = SignInViewModel(object : NavigationManager {

            override fun navigate(route: Route, singleTop: Boolean) {
                TODO("Not yet implemented")
            }
        }))
    }
}