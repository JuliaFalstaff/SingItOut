package com.jfalstaff.singitout.domain

import com.jfalstaff.singitout.data.network.dto.searchDto.ResponseServer
import kotlinx.coroutines.flow.Flow

interface IRepository {

    suspend fun getSearchResult(search: String): Flow<ResponseServer>

}