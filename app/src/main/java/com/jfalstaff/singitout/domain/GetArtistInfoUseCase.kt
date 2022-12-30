package com.jfalstaff.singitout.domain

class GetArtistInfoUseCase(private val repository: IRepository) {
    suspend operator fun invoke(id: Int) = repository.getArtistInfo(id)
}