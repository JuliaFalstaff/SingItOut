package com.jfalstaff.singitout.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.jfalstaff.singitout.data.network.ApiFactory
import com.jfalstaff.singitout.data.network.dto.searchDto.Hit
import com.jfalstaff.singitout.data.network.dto.searchDto.ResponseServer
import com.jfalstaff.singitout.data.repository.RepositoryImpl
import com.jfalstaff.singitout.domain.GetSearchResultUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainViewModel(): ViewModel() {

    private val getSearchResultUseCase = GetSearchResultUseCase(RepositoryImpl(ApiFactory.apiService))

    private var _searchResult: MutableLiveData<Hit> = MutableLiveData()
    val searchResult: LiveData<Hit> get() = _searchResult

//    fun loadSearchResult(search: String) {
//        viewModelScope.launch {
//             getSearchResultUseCase.invoke(search)
//                 .catch { error ->
//                     Log.d("VVV", error.stackTraceToString())
//                 }
//                .collect { response ->
//                    _searchResult.value = response
//                    Log.d("VVV", response.toString())
//                }
//
//        }
//    }

//    fun loadSearchResult(search: String) {
//        viewModelScope.launch {
//            val response = getSearchResultUseCase(search)
//                .catch {error ->
//                     Log.d("VVV", error.stackTraceToString())  }
//                .collectLatest {
//                    it.map {
//                        _searchResult.postValue(it)
//                    }
//                }
//        }
//    }

    suspend fun getPagingData(search: String) = getSearchResultUseCase.invoke(search).cachedIn(viewModelScope)


}