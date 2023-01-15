package com.jfalstaff.singitout.data.repository

import com.jfalstaff.singitout.data.mapper.LyricsMapper
import com.jfalstaff.singitout.data.network.api.ApiRapidLyricsService
import com.jfalstaff.singitout.domain.entities.lyricsEntity.Lyrics
import com.jfalstaff.singitout.domain.repository.ILyricsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RepositoryLyricsImpl @Inject constructor(
    private val apiRapidLyricsService: ApiRapidLyricsService,
    private val lyricsMapper: LyricsMapper
) :
    ILyricsRepository {
    override suspend fun getSongsLyric(id: Int): Flow<Lyrics> = flow {
        val lyricsData =
            lyricsMapper.mapLyricsResponseDtoToEntity(apiRapidLyricsService.getSongsLyric(id = id))
        emit(lyricsData.lyrics)
    }.flowOn(Dispatchers.IO)
}