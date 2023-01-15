package com.jfalstaff.singitout.domain.usecases

import com.jfalstaff.singitout.domain.repository.ILyricsRepository
import javax.inject.Inject

class GetSongLyricUseCase @Inject constructor(
    private val repository: ILyricsRepository
) {
    suspend operator fun invoke(id: Int) = repository.getSongsLyric(id)
}