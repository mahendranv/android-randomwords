package com.ex2.randomword.di

import com.ex2.randomword.data.local.AppDatabase
import com.ex2.randomword.data.remote.WordRemoteApi
import com.ex2.randomword.data.source.WordRepoImpl
import com.ex2.randomword.domain.source.WordRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Named

@InstallIn(ViewModelComponent::class)
@Module
class WordModule {

    @Provides
    fun wordRepo(
        db: AppDatabase,
        api: WordRemoteApi,
        @Named("io") io: CoroutineDispatcher
    ): WordRepo {
        return WordRepoImpl(
            db = db,
            remote = api,
            ioDispatcher = io
            )
    }
}