package com.gmail.ivan.morozyk.mappy.di

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UserModule {

    @Provides
    fun provideFirebaseAuth() = FirebaseAuth.getInstance()
}