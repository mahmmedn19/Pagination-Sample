package com.example.pagination.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagination.data.repository.DataRepository

class DataItemSource(
    private val repo: DataRepository
) : PagingSource<Int, String>() {

    override fun getRefreshKey(state: PagingState<Int, String>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestItemToPosition(anchorPosition)?.toInt()
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, String> {
        return try {
            val page = params.key ?: 1 // Starting page is 1 if params.key is null

            // Fetch data using the provided fetchData function
            val response = repo.getData(page, 10)

            // Determine next key based on whether there is more data
            val nextPage = if (response.isNotEmpty()) page + 1 else null

            LoadResult.Page(
                data = response,
                prevKey = if (page > 1) page - 1 else null,
                nextKey = nextPage
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
