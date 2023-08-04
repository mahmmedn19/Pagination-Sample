package com.example.pagination.screen

import com.example.pagination.data.network.DataItem

data class UiState(
    val page: Int = 1,
    val loading: Boolean = false,
    val data: List<DataItem> = emptyList(),
    val error: Boolean = false,
    val endReached: Boolean = false,
)
