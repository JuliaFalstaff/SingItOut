package com.jfalstaff.singitout.domain

import androidx.paging.PagingData
import com.jfalstaff.singitout.data.network.dto.searchDto.Hit
import kotlinx.coroutines.flow.Flow

interface IRepository {
    suspend fun getSearchResult(search: String): Flow<PagingData<Hit>>
}