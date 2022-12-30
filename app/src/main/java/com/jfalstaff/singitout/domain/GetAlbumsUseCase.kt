package com.jfalstaff.singitout.domain

class GetAlbumsUseCase(private val repository: IRepositoryMusic) {
    suspend operator fun invoke(artistId: Int) = repository.getArtistAlbums(artistId)
}