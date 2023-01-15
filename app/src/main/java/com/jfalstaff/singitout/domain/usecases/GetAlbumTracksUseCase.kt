package com.jfalstaff.singitout.domain.usecases

import com.jfalstaff.singitout.domain.repository.IRepository
import javax.inject.Inject

class GetAlbumTracksUseCase @Inject constructor(
    private val repository: IRepository
) {
    suspend operator fun invoke(id: Int) = repository.getAlbumTracks(id)
}