package com.jfalstaff.singitout.domain

class GetSongLyricUseCase(private val repository: ILyricsRepository) {
    suspend operator fun invoke(id: Int) = repository.getSongsLyric(id)
}