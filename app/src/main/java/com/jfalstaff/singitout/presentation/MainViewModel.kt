package com.jfalstaff.singitout.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfalstaff.singitout.data.network.ApiFactory
import com.jfalstaff.singitout.data.network.dto.searchDto.ResponseServer
import com.jfalstaff.singitout.data.repository.RepositoryImpl
import com.jfalstaff.singitout.domain.GetSearchResultUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(): ViewModel() {

    private val getSearchResultUseCase = GetSearchResultUseCase(RepositoryImpl(ApiFactory.apiService))

    private var _searchResult: MutableLiveData<ResponseServer> = MutableLiveData()
    val searchResult: LiveData<ResponseServer> get() = _searchResult

    fun loadSearchResult(search: String) {
        viewModelScope.launch {
             getSearchResultUseCase.invoke(search)
                 .catch { error ->
                     Log.d("VVV", error.stackTraceToString())
                 }
                .collect { response ->
                    _searchResult.value = response
                }

        }
    }


}