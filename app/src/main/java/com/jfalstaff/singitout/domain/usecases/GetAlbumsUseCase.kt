package com.jfalstaff.singitout.domain.usecases

import com.jfalstaff.singitout.domain.repository.IRepositoryMusic
import javax.inject.Inject

class GetAlbumsUseCase @Inject constructor(
    private val repository: IRepositoryMusic
) {
    suspend operator fun invoke(artistId: Int) = repository.getArtistAlbums(artistId)
}