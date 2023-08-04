package com.example.pagination.data.network


object FakeApi {
    private const val TOTAL_ITEMS = 500

    fun fetchData(page: Int, limit: Int): List<String> {
        val startIndex = (page - 1) * limit
        val endIndex = minOf(startIndex + limit, TOTAL_ITEMS)
        return if (startIndex < TOTAL_ITEMS) {
            (startIndex until endIndex).map { "Item $it" }
        } else {
            emptyList()
        }
    }
}


