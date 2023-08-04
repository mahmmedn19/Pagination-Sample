package com.example.pagination.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.pagination.data.DataItemSource
import com.example.pagination.data.network.DataItem
import com.example.pagination.data.repository.DataRepository
import com.example.pagination.data.repository.DataRepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: DataRepositoryImp
) : ViewModel() {

    private val _dataState = MutableStateFlow(UiState(loading = true))
    val dataState = _dataState.asStateFlow()

    val dataPager: Flow<PagingData<DataItem>> = Pager(
        config = PagingConfig(pageSize = 10)
    ) {
        DataItemSource(repository)
    }.flow.cachedIn(viewModelScope)

/*    fun fetchData() {
        viewModelScope.launch {
            try {
                val newData = repository.getData(_dataState.value.page, PAGE_SIZE)
                val updatedData = _dataState.value.data + newData
                val endReached = newData.name.isEmpty()

                _dataState.value = _dataState.value.copy(
                    loading = false,
                    data = updatedData,
                    endReached = endReached
                )
            } catch (e: Exception) {
                _dataState.value = UiState(error = false, loading = false)
            }
        }
    }

    companion object {
        private const val PAGE_SIZE = 10
    }*/
}
