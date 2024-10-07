package com.shs.detail

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.shs.ui.webview.WebViewScreen


@Composable
internal fun DetailRoute(
    pk : String,
    detailViewModel: DetailViewModel = hiltViewModel()
){
    val detailData = detailViewModel.uiState.collectAsStateWithLifecycle()
    LaunchedEffect(Unit){
        detailViewModel.fetchDetailInfo(pk = pk)
    }
    if(detailData.value.detailTopNews != null) DetailScreen(url = detailData.value.detailTopNews?.detailUrl.orEmpty(), context = LocalContext.current)
}

@Composable
internal fun DetailScreen(url : String, context : Context){
    WebViewScreen(url = url, context = context)
}