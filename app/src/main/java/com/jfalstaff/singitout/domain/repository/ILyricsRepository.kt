package com.jfalstaff.singitout.domain.repository

import com.jfalstaff.singitout.domain.entities.lyricsEntity.Lyrics
import kotlinx.coroutines.flow.Flow

interface ILyricsRepository {
    suspend fun getSongsLyric(id: Int): Flow<Lyrics>
}