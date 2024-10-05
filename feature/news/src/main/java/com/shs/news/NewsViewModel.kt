package com.shs.news

import androidx.lifecycle.viewModelScope
import com.shs.domain.top_headlines.usecase.FetchTopHeadlinesUseCase
import com.shs.ui.base.mvi.BaseMviViewModel
import com.shs.ui.common.CountryType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.catch
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
        fetchNews()
    }

    private fun fetchNews(){
        viewModelScope.launch {
            fetchTopHeadlinesUseCase(country = CountryType.US.code)
                .catch {
                    setState {
                        copy(newsUiState =NewsContract.NewsContentUiState.Error)
                    }
                }
                .collect { news ->
                    setState {
                        copy(newsUiState = if(news.isEmpty()) NewsContract.NewsContentUiState.Empty else NewsContract.NewsContentUiState.Success(news = news.toPersistentList()))
                    }
                }
        }
    }

}
