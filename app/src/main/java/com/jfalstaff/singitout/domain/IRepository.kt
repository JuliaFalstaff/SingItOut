package com.jfalstaff.singitout.domain

import androidx.paging.PagingData
import com.jfalstaff.singitout.data.network.dto.artists.Artist
import com.jfalstaff.singitout.data.network.dto.searchDto.Hit
import com.jfalstaff.singitout.data.network.dto.song.Song
import com.jfalstaff.singitout.data.network.dto.tracks.Track
import kotlinx.coroutines.flow.Flow

interface IRepository {
    suspend fun getSearchResult(search: String): Flow<PagingData<Hit>>
    suspend fun getArtistInfo(id: Int): Flow<Artist>
    suspend fun getAlbumTracks(id: Int): Flow<List<Track>>
    suspend fun getSongInfo(id: Int): Flow<Song>
}