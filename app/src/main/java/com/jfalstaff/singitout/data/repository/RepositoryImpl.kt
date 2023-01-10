package com.jfalstaff.singitout.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.jfalstaff.singitout.data.network.ApiService
import com.jfalstaff.singitout.data.network.dto.searchDto.Hit
import com.jfalstaff.singitout.data.network.dto.song.Song
import com.jfalstaff.singitout.data.network.dto.tracks.Track
import com.jfalstaff.singitout.data.network.paging.SearchResponsePagingSource
import com.jfalstaff.singitout.domain.IRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RepositoryImpl(private val apiService: ApiService) : IRepository {

    override suspend fun getSearchResult(search: String): Flow<PagingData<Hit>> {
        return Pager(
            config = PagingConfig(
                pageSize = ITEMS_PER_PAGE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                SearchResponsePagingSource(apiService, search)
            }
        ).flow
    }

    override suspend fun getArtistInfo(id: Int) = flow {
        val artistInfo = apiService.getArtistInfo(id)
        emit(artistInfo.response.artist)
    }.flowOn(Dispatchers.IO)

    override suspend fun getAlbumTracks(id: Int): Flow<List<Track>> = flow {
        val trackList = apiService.getAlbumTracks(id)
        emit(trackList.response.tracks ?: listOf())
    }.flowOn(Dispatchers.IO)

    override suspend fun getSongInfo(id: Int): Flow<Song> = flow {
        val song = apiService.getSongInfo(id)
        emit(song.response.song)
    }.flowOn(Dispatchers.IO)

    companion object {
        private val ITEMS_PER_PAGE = 10
    }
}