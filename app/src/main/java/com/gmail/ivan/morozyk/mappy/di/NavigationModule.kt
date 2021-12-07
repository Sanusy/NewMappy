package com.gmail.ivan.morozyk.mappy.di

import com.gmail.ivan.morozyk.mappy.navigation.ComposeNavigationProvider
import com.gmail.ivan.morozyk.mappy.navigation.NavigationManager
import com.gmail.ivan.morozyk.mappy.navigation.Navigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class NavigationModule {

    @Binds
    abstract fun bindNavigationManager(navigationManager: Navigator): NavigationManager

    @Binds
    abstract fun bindComposeNavigationProvider(composeNavigationProvider: Navigator): ComposeNavigationProvider
}