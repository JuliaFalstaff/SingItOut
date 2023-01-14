package com.jfalstaff.singitout.domain.usecases

import com.jfalstaff.singitout.domain.repository.IRepository

class GetArtistInfoUseCase(private val repository: IRepository) {
    suspend operator fun invoke(id: Int) = repository.getArtistInfo(id)
}