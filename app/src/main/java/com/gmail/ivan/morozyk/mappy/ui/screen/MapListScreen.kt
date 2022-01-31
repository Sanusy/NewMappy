package com.gmail.ivan.morozyk.mappy.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.gmail.ivan.morozyk.mappy.R
import com.gmail.ivan.morozyk.mappy.viewmodel.MapListViewModel

@Composable
fun MapListScreen(viewModel: MapListViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = viewModel::signOut) {
            Text(stringResource(id = R.string.map_list_sign_out))
        }
    }
}