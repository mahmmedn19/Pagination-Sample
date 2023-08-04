package com.example.pagination.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagination.data.network.DataItem
import com.example.pagination.data.repository.DataRepository

class DataItemSource(
    private val repo: DataRepository
) : PagingSource<Int, DataItem>() {

    override fun getRefreshKey(state: PagingState<Int, DataItem>): Int? {
        return state.anchorPosition?.let {
            val page = state.closestPageToPosition(it)
            page?.prevKey?.minus(1) ?: page?.nextKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataItem> {
        return try {
            val page = params.key ?: 1 // Starting page is 1 if params.key is null
            val limit = params.loadSize

            // Fetch data using the DataRepository
            val response = repo.getData(page, limit)

            // Determine next key based on whether there is more data
            val nextPage = if (response.name.isNotEmpty()) page + 1 else null

            LoadResult.Page(
                data = listOf(response),
                prevKey = null,
                nextKey = nextPage
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
