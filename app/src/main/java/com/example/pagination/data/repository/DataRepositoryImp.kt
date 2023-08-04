package com.example.pagination.data.repository

import com.example.pagination.data.network.DataItem
import com.example.pagination.data.network.FakeApi
import javax.inject.Inject

class DataRepositoryImp @Inject constructor() : DataRepository {
    override fun getData(page: Int, limit: Int): DataItem {
        return FakeApi.fetchData(page, limit)
    }
}