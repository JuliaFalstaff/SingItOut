package com.jfalstaff.singitout.domain.usecases

import com.jfalstaff.singitout.domain.repository.IRepository
import javax.inject.Inject

class GetSearchResultUseCase @Inject constructor(
    private val repository: IRepository
) {
    suspend operator fun invoke(search: String) = repository.getSearchResult(search)
}