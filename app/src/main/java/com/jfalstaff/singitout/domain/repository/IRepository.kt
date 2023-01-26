package com.jfalstaff.singitout.domain.repository

import androidx.paging.PagingData
import com.jfalstaff.singitout.domain.entities.artistEntity.Artist
import com.jfalstaff.singitout.domain.entities.searchEntity.Hit
import com.jfalstaff.singitout.domain.entities.songEntity.Song
import com.jfalstaff.singitout.domain.entities.tracksEntity.Track
import kotlinx.coroutines.flow.Flow

interface IRepository {
    suspend fun getSearchResult(search: String): Flow<PagingData<Hit>>
    suspend fun getArtistInfo(id: Int): Flow<Artist>
    suspend fun getAlbumTracks(id: Int): Flow<List<Track>>
    suspend fun getSongInfo(id: Int): Flow<Song>
}