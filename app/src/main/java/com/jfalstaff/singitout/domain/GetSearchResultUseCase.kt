package com.jfalstaff.singitout.domain

class GetSearchResultUseCase(private val repository: IRepository) {
    suspend operator fun invoke(search: String) = repository.getSearchResult(search)
}