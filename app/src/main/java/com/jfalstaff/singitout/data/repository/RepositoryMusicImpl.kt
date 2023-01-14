package com.jfalstaff.singitout.data.repository

import android.util.Log
import com.jfalstaff.singitout.data.mapper.AlbumsMapper
import com.jfalstaff.singitout.data.network.api.ApiMusicService
import com.jfalstaff.singitout.domain.repository.IRepositoryMusic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RepositoryMusicImpl(
    private val apiMusicService: ApiMusicService,
    private val albumsMapper: AlbumsMapper
    ) : IRepositoryMusic {

    override suspend fun getArtistAlbums(id: Int) = flow {
        val albums = albumsMapper.mapResponseAlbumDtoToEntity(apiMusicService.getArtistAlbums(id))
        Log.d("VVV Flow", albums.toString())
        emit(albums.response?.albums)
    }.flowOn(Dispatchers.IO)
}