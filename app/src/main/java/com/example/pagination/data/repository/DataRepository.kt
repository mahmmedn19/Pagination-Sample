package com.example.pagination.data.repository

interface DataRepository {
    suspend fun getData(page: Int, limit: Int): List<String>

}