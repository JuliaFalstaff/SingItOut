package com.jfalstaff.singitout.domain.usecases

import com.jfalstaff.singitout.domain.repository.ILyricsRepository

class GetSongLyricUseCase(private val repository: ILyricsRepository) {
    suspend operator fun invoke(id: Int) = repository.getSongsLyric(id)
}