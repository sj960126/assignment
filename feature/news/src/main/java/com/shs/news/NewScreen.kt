package com.shs.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberImagePainter
import com.shs.domain.top_headlines.model.TopNewsModel
import com.shs.ui.common.enableDiskAndMemoryCache
import com.shs.ui.common.isDeviceWidthOver
import com.shs.ui.component.LoadingIndicator
import com.shs.ui.design_system.LocalColorPalette
import com.shs.ui.design_system.LocalTypographySystem
import kotlinx.collections.immutable.ImmutableList


private const val MIN_LARGE_SCREEN_WIDTH = 600

@Composable
internal fun NewsRoute(
    onNewsClick : (String) -> Unit,
    newsViewModel: NewsViewModel = hiltViewModel()
) {
    val viewUiState = newsViewModel.uiState.collectAsStateWithLifecycle()
    val isLargeScreen = LocalConfiguration.current.isDeviceWidthOver(MIN_LARGE_SCREEN_WIDTH)

    LaunchedEffect(newsViewModel.effect){
        newsViewModel.effect.collect { effect ->
            when(effect){
                is NewsContract.NewsSideEffect.NavigateToDetail -> onNewsClick(effect.pk)
            }
        }
    }

    NewsScreen(
        viewUiState = viewUiState.value,
        isLargeScreen = isLargeScreen,
        onNewsClick = {
            newsViewModel.setEvent(event = NewsContract.NewsEvent.ItemClick(pk = it))
        }
    )

}

@Composable
internal fun NewsScreen(
    viewUiState: NewsContract.NewsUiState,
    isLargeScreen: Boolean,
    onNewsClick : (String) -> Unit,
) {
    when (viewUiState.newsUiState) {
        NewsContract.NewsContentUiState.Loading -> LoadingIndicator()
        NewsContract.NewsContentUiState.Empty -> Unit
        NewsContract.NewsContentUiState.Error -> Unit
        is NewsContract.NewsContentUiState.Success -> {
            if (isLargeScreen) {
                NewsGrid(newsList = viewUiState.newsUiState.news, onNewsClick = onNewsClick)
            } else {
                NewsList(newsList = viewUiState.newsUiState.news, onNewsClick = onNewsClick)
            }
        }
    }
}

@Composable
fun NewsGrid(
    newsList: ImmutableList<TopNewsModel>,
    onNewsClick : (String) -> Unit,
    cellCount : Int = 3,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(cellCount),
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        items(newsList, key = { it.pk }) {
            NewsCard(newsModel = it, onNewsClick = onNewsClick)
        }
    }
}

@Composable
fun NewsList(
    newsList: ImmutableList<TopNewsModel>,
    onNewsClick : (String) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        items(newsList, key = { it.pk }) {
            NewsCard(newsModel = it, onNewsClick = onNewsClick)
        }
    }
}

@Composable
fun NewsCard(
    modifier: Modifier = Modifier,
    newsModel: TopNewsModel,
    onNewsClick : (String) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable { onNewsClick(newsModel.pk) }
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
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            painter = rememberImagePainter(
                data = imageUrl,
                imageLoader = enableDiskAndMemoryCache(LocalContext.current),
                builder = {
                    crossfade(true)
                }
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun NewsInfo(newsModel: TopNewsModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = LocalColorPalette.current.gray80)
            .padding(start = 12.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        NewsText(
            text = newsModel.title,
            style = LocalTypographySystem.current.body14,
            color = if(newsModel.isSelected) LocalColorPalette.current.red else LocalColorPalette.current.white
        )
        Spacer(modifier = Modifier.height(3.dp))
        NewsText(text = newsModel.publishedAt, style = LocalTypographySystem.current.body12, color = LocalColorPalette.current.gray30)
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun NewsText(
    text: String,
    style: TextStyle,
    modifier: Modifier = Modifier,
    maxLines: Int = 2,
    color: Color = LocalColorPalette.current.white
) {
    Text(
        text = text,
        color = color,
        style = style,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier
    )
}

