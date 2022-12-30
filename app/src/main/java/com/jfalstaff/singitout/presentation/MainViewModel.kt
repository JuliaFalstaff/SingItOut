package com.jfalstaff.singitout.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import com.jfalstaff.singitout.data.network.ApiFactory
import com.jfalstaff.singitout.data.network.dto.searchDto.Hit
import com.jfalstaff.singitout.data.repository.RepositoryImpl
import com.jfalstaff.singitout.domain.GetSearchResultUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MainViewModel() : ViewModel() {

    private val getSearchResultUseCase =
        GetSearchResultUseCase(RepositoryImpl(ApiFactory.apiService))

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