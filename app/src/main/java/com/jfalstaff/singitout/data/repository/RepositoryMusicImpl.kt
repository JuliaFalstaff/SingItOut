package com.jfalstaff.singitout.data.repository

import android.util.Log
import com.jfalstaff.singitout.data.network.api.ApiMusicService
import com.jfalstaff.singitout.domain.IRepositoryMusic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RepositoryMusicImpl(private val apiMusicService: ApiMusicService) : IRepositoryMusic {

    override suspend fun getArtistAlbums(id: Int) = flow {
        val albums = apiMusicService.getArtistAlbums(id).response?.albums
        Log.d("VVV Flow", albums.toString())
        emit(albums)
    }.flowOn(Dispatchers.IO)
}