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
class NewsViewModel @Inject constructor(
    val fetchTopHeadlinesUseCase: FetchTopHeadlinesUseCase
): BaseMviViewModel<NewsContract.NewsEvent,NewsContract.NewsUiState,NewsContract.NewsSideEffect>(){

    override fun createInitialState(): NewsContract.NewsUiState = NewsContract.NewsUiState(newsUiState = NewsContract.NewsContentUiState.Loading)

    init {
        fetchTopHeadlineNews()
    }

    override fun handleEvent(event: NewsContract.NewsEvent) {
        when(event){
            is NewsContract.NewsEvent.ItemClick ->{
                updateSelectedItem(event.pk)
                setEffect { NewsContract.NewsSideEffect.NavigateToDetail(event.pk) }
            }
        }
    }

    private fun updateSelectedItem(pk: String) {
        if (currentState.newsUiState is NewsContract.NewsContentUiState.Success) {
            val successState = currentState.newsUiState as NewsContract.NewsContentUiState.Success

            successState.news.find { it.pk == pk }?.let { selectedItem ->
                val updatedNews = successState.news.map {
                    if (it.pk == pk) selectedItem.copy(isSelected = true) else it
                }.toPersistentList()

                setState {
                    copy(newsUiState = successState.copy(news = updatedNews))
                }
            }
        }
    }

    private fun fetchTopHeadlineNews(){
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
