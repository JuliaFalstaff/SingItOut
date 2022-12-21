package com.jfalstaff.singitout.data.repository

import com.jfalstaff.singitout.data.network.ApiService
import com.jfalstaff.singitout.data.network.dto.searchDto.ResponseServer
import com.jfalstaff.singitout.domain.IRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RepositoryImpl(val apiService: ApiService): IRepository {
    override suspend fun getSearchResult(search: String): Flow<ResponseServer> = flow {
        val list = apiService.searchResult(search)
        emit(list)
    }.flowOn(Dispatchers.IO)

}