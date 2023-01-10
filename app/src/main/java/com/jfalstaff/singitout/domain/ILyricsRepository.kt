package com.jfalstaff.singitout.domain

import androidx.paging.PagingData
import com.jfalstaff.singitout.data.network.dto.artists.Artist
import com.jfalstaff.singitout.data.network.dto.lyrics.Lyrics
import com.jfalstaff.singitout.data.network.dto.searchDto.Hit
import com.jfalstaff.singitout.data.network.dto.tracks.Track
import kotlinx.coroutines.flow.Flow

interface ILyricsRepository {
    suspend fun getSongsLyric(id: Int): Flow<Lyrics>
}