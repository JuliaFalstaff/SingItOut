package com.jfalstaff.singitout.domain

class GetSongInfoUseCase(private val repository: IRepository) {
    suspend operator fun invoke(id: Int) = repository.getSongInfo(id)
}