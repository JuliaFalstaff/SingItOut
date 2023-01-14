package com.jfalstaff.singitout.domain.usecases

import com.jfalstaff.singitout.domain.repository.IRepositoryMusic

class GetAlbumsUseCase(private val repository: IRepositoryMusic) {
    suspend operator fun invoke(artistId: Int) = repository.getArtistAlbums(artistId)
}