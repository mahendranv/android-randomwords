package com.ex2.randomword.di

import com.ex2.randomword.data.remote.WordRemoteApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    fun wordApi(retrofit: Retrofit): WordRemoteApi = retrofit.create(WordRemoteApi::class.java)
}