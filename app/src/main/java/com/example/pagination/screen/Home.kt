package com.example.pagination.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = hiltViewModel()
    val dataList = viewModel.dataPager.collectAsLazyPagingItems()

    LazyColumn {
        items(dataList.itemCount) { index ->
            dataList[index]?.let { dataItem ->
                DataCard(dataItem)
            }
        }

        when {
            dataList.loadState.refresh is LoadState.Loading -> {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .size(64.dp)
                                .padding(16.dp)
                                .align(Alignment.Center)
                        )
                    }
                }
            }

            dataList.loadState.append is LoadState.Loading -> {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .size(64.dp)
                                .padding(16.dp)
                                .align(Alignment.Center)
                        )
                    }
                }
            }

            dataList.loadState.refresh is LoadState.Error || dataList.loadState.append is LoadState.Error -> {
                item {
                    // Handle error state here, e.g., show an error message
                    Text(
                        text = "Error loading data.",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}


@Composable
fun DataCard(dataItem: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = dataItem,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}


@Preview
@Composable
fun PreviewDataCard() {

}

@Composable
fun PreviewData() {
    HomeScreen()
}