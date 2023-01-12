package com.jfalstaff.singitout.data.repository

import com.jfalstaff.singitout.data.network.api.ApiRapidLyricsService
import com.jfalstaff.singitout.data.network.dto.lyrics.Lyrics
import com.jfalstaff.singitout.domain.ILyricsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RepositoryLyricsImpl(private val apiRapidLyricsService: ApiRapidLyricsService) : ILyricsRepository {
    override suspend fun getSongsLyric(id: Int): Flow<Lyrics> = flow {
        val lyricsData = apiRapidLyricsService.getSongsLyric(id = id)
        emit(lyricsData.lyrics)
    }.flowOn(Dispatchers.IO)
}