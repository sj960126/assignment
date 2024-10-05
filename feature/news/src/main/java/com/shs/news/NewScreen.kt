package com.shs.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberImagePainter
import com.shs.domain.top_headlines.model.TopNewsModel
import com.shs.ui.design_system.LocalColorPalette
import com.shs.ui.design_system.LocalTypographySystem

@Composable
fun NewsRoute(){
    val newsViewModel : NewsViewModel = hiltViewModel()
    val viewUiState = newsViewModel.uiState.collectAsStateWithLifecycle()
    NewsScreen(
        viewUiState = viewUiState.value
    )
}

@Composable
internal fun NewsScreen(
    viewUiState: NewsContract.NewsUiState
){
    when(viewUiState.newsUiState){
        NewsContract.NewsContentUiState.Loading -> Unit
        NewsContract.NewsContentUiState.Empty -> Unit
        NewsContract.NewsContentUiState.Error -> Unit
        is NewsContract.NewsContentUiState.Success -> {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ){
                items(viewUiState.newsUiState.news){
                    NewsCard(newsModel = it)
                }
            }
        }
    }
}

@Composable
fun NewsCard(
    newsModel : TopNewsModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        NewsImage(newsModel.urlToImage)
        NewsInfo(newsModel)
    }
}

@Composable
fun NewsImage(imageUrl: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(16f / 9f)
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = rememberImagePainter(data = imageUrl),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}


@Composable
fun NewsInfo(newsModel: TopNewsModel) {
    Column(
        modifier = Modifier
            .background(color = LocalColorPalette.current.gray80)
            .padding(start = 12.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = newsModel.title,
            color = LocalColorPalette.current.white,
            style = LocalTypographySystem.current.body14
        )
        Spacer(modifier = Modifier.height(3.dp))
        Text(
            text = newsModel.publishedAt,
            color = LocalColorPalette.current.gray40,
            style = LocalTypographySystem.current.body12
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}
