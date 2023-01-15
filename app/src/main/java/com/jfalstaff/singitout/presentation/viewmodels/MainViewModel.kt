package com.jfalstaff.singitout.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import com.jfalstaff.singitout.domain.entities.searchEntity.Hit
import com.jfalstaff.singitout.domain.usecases.GetSearchResultUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getSearchResultUseCase: GetSearchResultUseCase
) : ViewModel() {

    suspend fun getPagingData(search: String) =
        getSearchResultUseCase(search).cachedIn(viewModelScope)

    suspend fun getPagingDataOfArtist(search: String): Flow<PagingData<Hit>> {
        val artistSet = mutableSetOf<Int>()
        return getSearchResultUseCase(search).map {
            it.filter {
                if (artistSet.contains(it.result.primaryArtist.id)) {
                    false
                } else {
                    artistSet.add(it.result.primaryArtist.id)
                }
            }
        }.cachedIn(viewModelScope)
    }
}