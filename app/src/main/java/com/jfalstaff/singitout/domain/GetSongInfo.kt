package com.jfalstaff.singitout.domain

class GetSongInfo(private val repository: IRepository) {
    suspend operator fun invoke(id: Int) = repository.getSongInfo(id)
}