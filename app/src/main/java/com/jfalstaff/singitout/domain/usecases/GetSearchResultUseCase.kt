package com.jfalstaff.singitout.domain.usecases

import com.jfalstaff.singitout.domain.repository.IRepository

class GetSearchResultUseCase(private val repository: IRepository) {
    suspend operator fun invoke(search: String) = repository.getSearchResult(search)
}