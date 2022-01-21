package com.gmail.ivan.morozyk.mappy.ui.screen

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.gmail.ivan.morozyk.mappy.R
import com.gmail.ivan.morozyk.mappy.ui.widget.ProgressBar
import com.gmail.ivan.morozyk.mappy.viewmodel.SplashViewModel

@Composable
fun SplashScreen(splashViewModel: SplashViewModel) {

    splashViewModel.checkAuthorization()

    Scaffold(topBar = {
        TopAppBar(title = { Text(stringResource(id = R.string.app_name)) })
    }) {
        ProgressBar()
    }
}