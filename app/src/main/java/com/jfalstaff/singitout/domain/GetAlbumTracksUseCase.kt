package com.jfalstaff.singitout.domain

class GetAlbumTracksUseCase(private val repository: IRepository) {
    suspend operator fun invoke(id: Int) = repository.getAlbumTracks(id)
}