package com.jfalstaff.singitout.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.jfalstaff.singitout.data.mapper.ArtistMapper
import com.jfalstaff.singitout.data.mapper.SearchResultMapper
import com.jfalstaff.singitout.data.mapper.SongMapper
import com.jfalstaff.singitout.data.mapper.TrackMapper
import com.jfalstaff.singitout.data.network.api.ApiService
import com.jfalstaff.singitout.data.network.paging.SearchResponsePagingSource
import com.jfalstaff.singitout.domain.entities.searchEntity.Hit
import com.jfalstaff.singitout.domain.entities.songEntity.Song
import com.jfalstaff.singitout.domain.entities.tracksEntity.Track
import com.jfalstaff.singitout.domain.repository.IRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val searchResultMapper: SearchResultMapper,
    private val trackMapper: TrackMapper,
    private val songMapper: SongMapper,
    private val artistMapper: ArtistMapper
) : IRepository {

    override suspend fun getSearchResult(search: String): Flow<PagingData<Hit>> {
        return Pager(
            config = PagingConfig(
                pageSize = ITEMS_PER_PAGE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                SearchResponsePagingSource(apiService, search, searchResultMapper)
            }
        ).flow
    }

    override suspend fun getArtistInfo(id: Int) = flow {
        val artistInfo = artistMapper.mapResponseArtistDtoToEntity(apiService.getArtistInfo(id))
        emit(artistInfo.response.artist)
    }.flowOn(Dispatchers.IO)

    override suspend fun getAlbumTracks(id: Int): Flow<List<Track>> = flow {
        val trackList = trackMapper.mapResponseAlbumTracksDtoToEntity(apiService.getAlbumTracks(id))
        emit(trackList.response.tracks ?: listOf())
    }.flowOn(Dispatchers.IO)

    override suspend fun getSongInfo(id: Int): Flow<Song> = flow {
        val song = songMapper.mapResponseSongDtoToEntity(apiService.getSongInfo(id))
        emit(song.response.song)
    }.flowOn(Dispatchers.IO)

    companion object {
        private val ITEMS_PER_PAGE = 10
    }
}