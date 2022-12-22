package com.jfalstaff.singitout.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.jfalstaff.singitout.data.network.ApiService
import com.jfalstaff.singitout.data.network.dto.searchDto.Hit
import com.jfalstaff.singitout.data.network.dto.searchDto.ResponseServer
import com.jfalstaff.singitout.data.network.paging.SearchResponsePagingSource
import com.jfalstaff.singitout.domain.IRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RepositoryImpl(val apiService: ApiService): IRepository {
//    override suspend fun getSearchResult(search: String): Flow<ResponseServer> = flow {
//        val list = apiService.searchResult(search)
//        emit(list)
//    }.flowOn(Dispatchers.IO)



    override suspend fun getSearchResult(search: String): Flow<PagingData<Hit>> {
        return Pager(
            config = PagingConfig(
                pageSize = ITEMS_PER_PAGE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                SearchResponsePagingSource(apiService, search)
            }
        ).flow
    }

    companion object {
        private const val ITEMS_PER_PAGE = 15
    }
}