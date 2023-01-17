package com.jfalstaff.singitout.di

import com.jfalstaff.singitout.data.network.api.ApiFactory
import com.jfalstaff.singitout.data.network.api.ApiMusicService
import com.jfalstaff.singitout.data.network.api.ApiRapidLyricsService
import com.jfalstaff.singitout.data.network.api.ApiService
import com.jfalstaff.singitout.data.repository.RepositoryImpl
import com.jfalstaff.singitout.data.repository.RepositoryLyricsImpl
import com.jfalstaff.singitout.data.repository.RepositoryMusicImpl
import com.jfalstaff.singitout.domain.repository.ILyricsRepository
import com.jfalstaff.singitout.domain.repository.IRepository
import com.jfalstaff.singitout.domain.repository.IRepositoryMusic
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindRepository(impl: RepositoryImpl): IRepository

    @ApplicationScope
    @Binds
    fun bindRepositoryLyrics(impl: RepositoryLyricsImpl): ILyricsRepository

    @ApplicationScope
    @Binds
    fun bindRepositoryMusic(impl: RepositoryMusicImpl): IRepositoryMusic

    companion object {

        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }

        @ApplicationScope
        @Provides
        fun provideApiRapidLyricsService(): ApiRapidLyricsService {
            return ApiFactory.apiRapidLyricsService
        }

        @ApplicationScope
        @Provides
        fun provideApiMusicService(): ApiMusicService {
            return ApiFactory.apiMusicService
        }
    }
}