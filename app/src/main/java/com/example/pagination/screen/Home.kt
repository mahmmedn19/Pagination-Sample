package com.example.pagination.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.pagination.data.network.DataItem

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = hiltViewModel()
    val dataList = viewModel.dataPager.collectAsLazyPagingItems()

    LazyColumn {
        items(dataList.itemCount) { index ->
            dataList[index]?.let { dataItem ->
                DataCard(dataItem)
            }
            when (dataList.loadState.append) {
                is LoadState.Error -> {
                }

                LoadState.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier,
                        progress = 0.5f,
                    )
                }

                is LoadState.NotLoading -> Unit
            }
        }
    }
}


@Composable
fun DataCard(dataItem: DataItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Name: ${dataItem.name}",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview
@Composable
fun PreviewDataCard() {
    DataCard(
        DataItem(
            name = listOf("Item 1", "Item 2", "Item 3"),
            page = 1,
            limit = 10
        )
    )
}

@Composable
fun PreviewData() {
    HomeScreen()
}