package com.example.pagination.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.pagination.data.DataItemSource
import com.example.pagination.data.repository.DataRepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: DataRepositoryImp
) : ViewModel() {

    val dataPager: Flow<PagingData<String>> = Pager(
        config = PagingConfig(pageSize = 10)
    ) {
        DataItemSource(repository)
    }.flow.cachedIn(viewModelScope)
}
