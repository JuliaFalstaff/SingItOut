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

    @Binds
    fun bindRepository(impl: RepositoryImpl): IRepository
    @Binds
    fun bindRepositoryLyrics(impl: RepositoryLyricsImpl): ILyricsRepository
    @Binds
    fun bindRepositoryMusic(impl: RepositoryMusicImpl): IRepositoryMusic

    companion object {

        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }

        @Provides
        fun provideApiRapidLyricsService(): ApiRapidLyricsService {
            return ApiFactory.apiRapidLyricsService
        }

        @Provides
        fun provideApiMusicService(): ApiMusicService {
            return ApiFactory.apiMusicService
        }
    }

}