package com.example.pagination.data.repository

import com.example.pagination.data.network.FakeApi
import kotlinx.coroutines.delay
import java.io.IOException
import javax.inject.Inject

class DataRepositoryImp @Inject constructor() : DataRepository {
    var error = 0
    override suspend fun getData(page: Int, limit: Int): List<String> {
        delay(3000L)
        error++
        if (error == 4)
            throw IOException("")
        return FakeApi.fetchData(page, limit)
    }
}
