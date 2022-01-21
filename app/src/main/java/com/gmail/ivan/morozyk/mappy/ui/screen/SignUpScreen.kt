package com.gmail.ivan.morozyk.mappy.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.gmail.ivan.morozyk.mappy.R
import com.gmail.ivan.morozyk.mappy.viewmodel.SignUpViewModel

@Composable
fun SignUpScreen(signUpViewModel: SignUpViewModel) {

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
                value = signUpViewModel.uiState.value.name,
                onValueChange = signUpViewModel::onNameChanged,
                leadingIcon = { Icon(Icons.Default.Person, null) },
                label = { Text(stringResource(id = R.string.sign_up_screen_enter_name)) },
                singleLine = true,
            )

            TextField(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth(),
                value = signUpViewModel.uiState.value.email,
                onValueChange = signUpViewModel::onEmailChanged,
                leadingIcon = { Icon(Icons.Default.Email, null) },
                label = { Text(stringResource(id = R.string.sign_up_screen_enter_email)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                singleLine = true,
            )

            TextField(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth(),
                value = signUpViewModel.uiState.value.password,
                onValueChange = signUpViewModel::onPasswordChanged,
                leadingIcon = { Icon(Icons.Default.Lock, null) },
                label = { Text(stringResource(id = R.string.sign_up_screen_enter_password)) },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Button(
                modifier = Modifier.padding(8.dp),
                onClick = signUpViewModel::signUpViaEmailAndPassword
            ) {
                Text(text = stringResource(id = R.string.sign_up_screen_sign_up))
            }

            IconButton(
                modifier = Modifier.padding(8.dp),
                onClick = signUpViewModel::signUpViaGoogle
            ) {
                Image(
                    painterResource(id = R.drawable.googleg_standard_color_18),
                    contentDescription = null
                )
            }
        }
    }
}