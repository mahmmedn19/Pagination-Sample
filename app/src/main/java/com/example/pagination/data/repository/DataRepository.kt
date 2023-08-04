package com.example.pagination.data.repository

import com.example.pagination.data.network.DataItem

interface DataRepository {
    fun getData(page: Int, limit: Int): DataItem

}