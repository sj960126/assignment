package com.shs.news

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.shs.domain.top_headlines.usecase.FetchTopHeadlinesUseCase
import com.shs.ui.base.mvi.BaseMviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class NewsViewModel @Inject constructor(
    val fetchTopHeadlinesUseCase: FetchTopHeadlinesUseCase
): BaseMviViewModel<NewsContract.NewsEvent,NewsContract.NewsUiState,NewsContract.NewsSideEffect>(){

    override fun createInitialState(): NewsContract.NewsUiState = NewsContract.NewsUiState(newsUiState = NewsContract.NewsContentUiState.Loading)

    override fun handleEvent(event: NewsContract.NewsEvent) {
    }

    init {
        viewModelScope.launch {
            fetchTopHeadlinesUseCase("us").collectLatest {
                Log.d("디버그","${it}")
            }
        }
    }

}