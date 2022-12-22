package com.jfalstaff.singitout.data.network.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.jfalstaff.singitout.data.network.ApiService
import com.jfalstaff.singitout.data.network.dto.searchDto.Hit
import retrofit2.HttpException
import java.io.IOException

class SearchResponsePagingSource(
    private val apiService: ApiService,
    private val searchExpression: String
) : PagingSource<Int, Hit>() {

    override fun getRefreshKey(state: PagingState<Int, Hit>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Hit> {
        return try {
            val pageNumber = params.key ?: STARTING_KEY
            val pageSize = params.loadSize
            val responseFromApi = apiService.searchResult(searchExpression, pageNumber, pageSize)
            val nextKey = if (responseFromApi.response.hits.isNullOrEmpty()) {
                null
            } else {
                pageNumber + 1
            }
            LoadResult.Page(
                data = responseFromApi.response.hits ?: listOf(),
                prevKey = if (pageNumber == STARTING_KEY) null else pageNumber - 1,
                nextKey = nextKey
            )
        } catch (e: IOException) {
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    companion object {
        private val STARTING_KEY = 1
    }
}